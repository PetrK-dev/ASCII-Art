package AsciiArtApp.models.pixels

import org.scalatest.FunSuite

class RgbPixelTest extends FunSuite{
  test("midValue") {
    try {
      new RgbPixel((125<<16) | (125<<8) | 125 )
    }
    catch {
      case e: Exception => fail()
    }
  }

  test("minValue") {
    try {
      new RgbPixel((0<<16) | (0<<8) | 0 )
    }
    catch {
      case e: Exception => fail()
    }
  }

  test("maxValue") {
    try {
      new RgbPixel((255<<16) | (255<<8) | 255 )
    }
    catch {
      case e: Exception => fail()
    }
  }

  test("get R,G,B") {
    val p = new RgbPixel((30<<16) | (60<<8) | 90 )
    assert(p.r == 30)
    assert(p.g == 60)
    assert(p.b == 90)

  }
}