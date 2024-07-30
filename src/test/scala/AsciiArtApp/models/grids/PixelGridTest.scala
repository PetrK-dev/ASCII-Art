package AsciiArtApp.models.grids

import AsciiArtApp.models.pixels.{GrayScalePixel, Pixel}
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class PixelGridTest extends FunSuite with BeforeAndAfterEach{

  var testingPixels: Array[Array[GrayScalePixel]] = _
  var testingGrid: PixelGrid[GrayScalePixel] = _

  override protected def beforeEach(): Unit =  {
    testingPixels = Array.ofDim[GrayScalePixel](2, 3)
    testingPixels(0)(0)=new GrayScalePixel(1)
    testingPixels(0)(1)=new GrayScalePixel(2)
    testingPixels(0)(2)=new GrayScalePixel(3)
    testingPixels(1)(0)=new GrayScalePixel(4)
    testingPixels(1)(1)=new GrayScalePixel(5)
    testingPixels(1)(2)=new GrayScalePixel(6)
    testingGrid = new PixelGrid[GrayScalePixel](testingPixels)
  }

  test("Height and Width") {
    assert(2 == testingGrid.height)
    assert(3 == testingGrid.width)
  }

  test("Empty array"){
    assertThrows[Exception]{
      new PixelGrid[GrayScalePixel](new Array[Array[GrayScalePixel]](0))
    }
  }

  test("Transform without change"){
    val res = testingGrid.transform(P=>P)
    assert(1 == res.getPixel(0,0).value )
    assert(2 == res.getPixel(0,1).value )
    assert(3 == res.getPixel(0,2).value )
    assert(4 == res.getPixel(1,0).value )
    assert(5 == res.getPixel(1,1).value )
    assert(6 == res.getPixel(1,2).value )
  }

  test("Transform with change"){
    val res = testingGrid.transform(p => new GrayScalePixel(1 + p.value))
    assert(2 == res.getPixel(0,0).value )
    assert(3 == res.getPixel(0,1).value )
    assert(4 == res.getPixel(0,2).value )
    assert(5 == res.getPixel(1,0).value )
    assert(6 == res.getPixel(1,1).value )
    assert(7 == res.getPixel(1,2).value )
  }

  test("Immutable 2D array") {
    val testingGrid2 = new PixelGrid[GrayScalePixel](testingGrid.pixels)
    val res = testingGrid2.transform(p => new GrayScalePixel(1 + p.value))
    assert(res.getPixel(0,0).value != testingGrid.getPixel(0,0).value)
  }

  test("Get pixel negative"){
    assertThrows[Exception]{ testingGrid.getPixel(-1,0) }
    assertThrows[Exception]{ testingGrid.getPixel(0,-1) }
  }

  test("Get pixel outside"){
    assertThrows[Exception]{ testingGrid.getPixel(2,0) }
    assertThrows[Exception]{ testingGrid.getPixel(0,3) }
  }

  test("Get pixel OK"){
    assertResult(1){ testingGrid.getPixel(0,0).value }
    assertResult(2){ testingGrid.getPixel(0,1).value }
  }
}
