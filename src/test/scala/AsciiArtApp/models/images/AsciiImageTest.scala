package AsciiArtApp.models.images

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.pixels.AsciiPixel
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class AsciiImageTest extends FunSuite with BeforeAndAfterEach {
  var testingImage: AsciiImage = _


  override protected def beforeEach(): Unit = {
    var testingPixels = Array.ofDim[AsciiPixel](2, 2)
    testingPixels(0)(0) = new AsciiPixel('t')
    testingPixels(0)(1) = new AsciiPixel('e')
    testingPixels(1)(0) = new AsciiPixel('s')
    testingPixels(1)(1) = new AsciiPixel('t')
    testingImage = new AsciiImage(new PixelGrid(testingPixels))
  }

  test("Ascii to string") {
    val res = testingImage.toString
    assert(res == "te\nst\n")
  }
}