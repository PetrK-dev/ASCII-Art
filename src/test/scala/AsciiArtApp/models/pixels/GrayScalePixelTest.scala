package AsciiArtApp.models.pixels

import org.scalatest.FunSuite

class GrayScalePixelTest extends FunSuite {
  test("mid value") {
    try {
      new GrayScalePixel(125)
    }
    catch {
      case e: Exception => fail()
    }
  }

  test("min value") {
    try {
      new GrayScalePixel(0)
    }
    catch {
      case e: Exception => fail()
    }
  }

  test("max value") {
    try {
      new GrayScalePixel(255)
    }
    catch {
      case e: Exception => fail()
    }
  }

  test("negative value") {
    assertThrows[Exception]{ new GrayScalePixel(-1) }
  }

  test("over value") {
    assertThrows[Exception]{ new GrayScalePixel(256) }
  }
}