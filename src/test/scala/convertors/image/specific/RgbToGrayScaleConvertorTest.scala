package convertors.image.specific

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.RgbImage
import AsciiArtApp.models.pixels.RgbPixel
import org.scalatest.FunSuite

class RgbToGrayScaleConvertorTest extends FunSuite{

  test("convert") {
    var testingPixels = Array.ofDim[RgbPixel](2, 2)
    testingPixels(0)(0) = new RgbPixel(255)
    testingPixels(0)(1) = new RgbPixel(300)
    testingPixels(1)(0) = new RgbPixel(1250)
    testingPixels(1)(1) = new RgbPixel(80)
    var testingImage = new RgbImage(new PixelGrid(testingPixels))

    val res = RgbToGrayScaleConvertor.convert(testingImage)
    assert(28 == res.getPixel(0,0).value)
    assert(5 == res.getPixel(0,1).value)
    assert(27 == res.getPixel(1,0).value)
    assert(8 == res.getPixel(1,1).value)
  }

}
