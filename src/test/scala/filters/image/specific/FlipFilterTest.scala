package filters.image.specific

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.GrayScaleImage
import AsciiArtApp.models.pixels.GrayScalePixel
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class FlipFilterTest extends FunSuite with BeforeAndAfterEach{
  var testingImage: GrayScaleImage = _


  override protected def beforeEach(): Unit =  {
    var testingPixels = Array.ofDim[GrayScalePixel](2, 2)
    testingPixels(0)(0) = new GrayScalePixel(1)
    testingPixels(0)(1) = new GrayScalePixel(2)
    testingPixels(1)(0) = new GrayScalePixel(3)
    testingPixels(1)(1) = new GrayScalePixel(4)
    testingImage = new GrayScaleImage(new PixelGrid(testingPixels))
  }

  test("Flip wrong axis"){
    assertThrows[Exception] {
      new FlipFilter("z")
    }
    assertThrows[Exception] {
      new FlipFilter("5")
    }
  }

  test("Flip x axis"){
    val flipFilter = new FlipFilter("x")
    val res = flipFilter.filter(testingImage)
    assertResult(1){ res.getPixel(1,0).value }
    assertResult(2){ res.getPixel(1,1).value }
    assertResult(3){ res.getPixel(0,0).value }
    assertResult(4){ res.getPixel(0,1).value }
  }

  test("Flip y axis"){
    val flipFilter = new FlipFilter("y")
    val res = flipFilter.filter(testingImage)
    assertResult(1){ res.getPixel(0,1).value }
    assertResult(2){ res.getPixel(0,0).value }
    assertResult(3){ res.getPixel(1,1).value }
    assertResult(4){ res.getPixel(1,0).value }
  }
}
