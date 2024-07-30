package convertors.image.specific

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.GrayScaleImage
import AsciiArtApp.models.pixels.GrayScalePixel
import org.scalatest.FunSuite

class GrayScaleToAsciiConvertorTest extends FunSuite{


  test("@ - low value") {
    val testPixel = new GrayScalePixel(0)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '@')
  }

  test("@ - high value") {
    val testPixel = new GrayScalePixel(25)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '@')
  }

  test("% - low value") {
    val testPixel = new GrayScalePixel(26)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '%')
  }

  test("% - high value") {
    val testPixel = new GrayScalePixel(51)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '%')
  }

  test("# - low value") {
    val testPixel = new GrayScalePixel(52)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '#')
  }

  test("# - high value") {
    val testPixel = new GrayScalePixel(76)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '#')
  }

  test("* - low value") {
    val testPixel = new GrayScalePixel(77)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '*')
  }

  test("* - high value") {
    val testPixel = new GrayScalePixel(102)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '*')
  }

  test("+ - low value") {
    val testPixel = new GrayScalePixel(103)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '+')
  }

  test("+ - high value") {
    val testPixel = new GrayScalePixel(127)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '+')
  }

  test("= - low value") {
    val testPixel = new GrayScalePixel(128)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '=')
  }

  test("= - high value") {
    val testPixel = new GrayScalePixel(153)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '=')
  }

  test("- - low value") {
    val testPixel = new GrayScalePixel(154)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '-')
  }

  test("- - high value") {
    val testPixel = new GrayScalePixel(179)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '-')
  }

  test(": - low value") {
    val testPixel = new GrayScalePixel(180)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == ':')
  }

  test(": - high value") {
    val testPixel = new GrayScalePixel(204)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == ':')
  }


  test(". - low value") {
    val testPixel = new GrayScalePixel(205)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '.')
  }

  test(". - high value") {
    val testPixel = new GrayScalePixel(230)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == '.')
  }


  test("space - low value") {
    val testPixel = new GrayScalePixel(231)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == ' ')
  }

  test("space - high value") {
    val testPixel = new GrayScalePixel(255)
    val res = GrayScaleToAsciiConvertor.GrayToAscii(testPixel)
    assert(res.value == ' ')
  }

  test("convert") {
    var testingPixels = Array.ofDim[GrayScalePixel](2, 2)
    testingPixels(0)(0) = new GrayScalePixel(1)
    testingPixels(0)(1) = new GrayScalePixel(50)
    testingPixels(1)(0) = new GrayScalePixel(125)
    testingPixels(1)(1) = new GrayScalePixel(255)
    var testingImage = new GrayScaleImage(new PixelGrid(testingPixels))

    val res = GrayScaleToAsciiConvertor.convert(testingImage)
    assertResult('@'){ res.getPixel(0,0).value }
    assertResult('%'){ res.getPixel(0,1).value }
    assertResult('+'){ res.getPixel(1,0).value }
    assertResult(' '){ res.getPixel(1,1).value }
  }

}
