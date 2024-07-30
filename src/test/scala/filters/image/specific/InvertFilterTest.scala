package filters.image.specific

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.GrayScaleImage
import AsciiArtApp.models.pixels.GrayScalePixel
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class InvertFilterTest extends FunSuite with BeforeAndAfterEach {
  var testingImage: GrayScaleImage = _

  override protected def beforeEach(): Unit = {
    var testingPixels = Array.ofDim[GrayScalePixel](2, 2)
    testingPixels(0)(0) = new GrayScalePixel(0)
    testingPixels(0)(1) = new GrayScalePixel(1)
    testingPixels(1)(0) = new GrayScalePixel(100)
    testingPixels(1)(1) = new GrayScalePixel(255)
    testingImage = new GrayScaleImage(new PixelGrid(testingPixels))
  }

  test("Invert"){
    val invertFilter = new InvertFilter()
    val res = invertFilter.filter(testingImage)
    assertResult(255){ res.getPixel(0,0).value }
    assertResult(254){ res.getPixel(0,1).value }
    assertResult(155){ res.getPixel(1,0).value }
    assertResult(0){ res.getPixel(1,1).value }
  }

}
