package filters.image.mixed

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.GrayScaleImage
import AsciiArtApp.models.pixels.GrayScalePixel
import filters.image.specific.{BrightnessFilter, FlipFilter, InvertFilter}
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class MixedFilterTest extends FunSuite with BeforeAndAfterEach{

  var testingImage: GrayScaleImage = _

  override protected def beforeEach(): Unit =  {
    var testingPixels = Array.ofDim[GrayScalePixel](2, 2)
    testingPixels(0)(0) = new GrayScalePixel(1)
    testingPixels(0)(1) = new GrayScalePixel(2)
    testingPixels(1)(0) = new GrayScalePixel(3)
    testingPixels(1)(1) = new GrayScalePixel(4)
    testingImage = new GrayScaleImage(new PixelGrid(testingPixels))
  }


  test("Single filter - brightness"){
    val mixedFilter = new MixedFilter( List( new BrightnessFilter(100) ) )

    val res = mixedFilter.filter(testingImage)
    assertResult(101){
      res.getPixel(0,0).value
    }
  }

  test("Single filter - flip"){
    val mixedFilter = new MixedFilter( List( new FlipFilter("x") ) )

    val res = mixedFilter.filter(testingImage)
    assertResult(1){ res.getPixel(1,0).value }
    assertResult(2){ res.getPixel(1,1).value }
  }

  test("Single filter - invert"){
    val mixedFilter = new MixedFilter( List( new InvertFilter() ) )

    val res = mixedFilter.filter(testingImage)
    assertResult(254){ res.getPixel(0,0).value }
    assertResult(253){ res.getPixel(0,1).value }
  }

  test("Mixed two filters - flip, invert"){
    val mixedFilter = new MixedFilter(
      List(
        new FlipFilter("x"),
        new InvertFilter()
      )
    )
    val res = mixedFilter.filter(testingImage)
    assertResult(254){ res.getPixel(1,0).value }
    assertResult(253){ res.getPixel(1,1).value }
    assertResult(252){ res.getPixel(0,0).value }
    assertResult(251){ res.getPixel(0,1).value }
  }

  test("Mixed all filters - brightness, flip, invert"){
    val mixedFilter = new MixedFilter(
      List(
        new BrightnessFilter(100),
        new FlipFilter("x"),
        new InvertFilter()
      )
    )
    val res = mixedFilter.filter(testingImage)
    assertResult(154){ res.getPixel(1,0).value }
    assertResult(153){ res.getPixel(1,1).value }
    assertResult(152){ res.getPixel(0,0).value }
    assertResult(151){ res.getPixel(0,1).value }
  }
}

