package AsciiArtApp.models.images

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.pixels.GrayScalePixel
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class ImageTest extends FunSuite with BeforeAndAfterEach {
  var testingPixels: Array[Array[GrayScalePixel]] = _
  var testingGrid: PixelGrid[GrayScalePixel] = _
  var testingImage: GrayScaleImage = _

  override protected def beforeEach(): Unit = {
    testingPixels = Array.ofDim[GrayScalePixel](2, 3)
    testingPixels(0)(0)=new GrayScalePixel(1)
    testingPixels(0)(1)=new GrayScalePixel(2)
    testingPixels(0)(2)=new GrayScalePixel(3)
    testingPixels(1)(0)=new GrayScalePixel(4)
    testingPixels(1)(1)=new GrayScalePixel(5)
    testingPixels(1)(2)=new GrayScalePixel(6)
    testingGrid = new PixelGrid(testingPixels)
    testingImage = new GrayScaleImage(testingGrid)
  }

  test("Height and Width") {
    assert(2 == testingImage.height)
    assert(3 == testingImage.width)
  }

  test("Transform without change"){
    val res = testingImage.transform(P=>P)
    assert(1 == res.getPixel(0,0).value )
    assert(2 == res.getPixel(0,1).value )
    assert(3 == res.getPixel(0,2).value )
    assert(4 == res.getPixel(1,0).value )
    assert(5 == res.getPixel(1,1).value )
    assert(6 == res.getPixel(1,2).value )
  }

  test("Transform with change"){
    val res = testingImage.transform(p => new GrayScalePixel(1 + p.value))
    assert(2 == res.getPixel(0,0).value )
    assert(3 == res.getPixel(0,1).value )
    assert(4 == res.getPixel(0,2).value )
    assert(5 == res.getPixel(1,0).value )
    assert(6 == res.getPixel(1,1).value )
    assert(7 == res.getPixel(1,2).value )
  }

  test("Immutable grid") {
    val testingImage2 = new PixelGrid[GrayScalePixel](testingImage.getPixels)
    val res = testingImage2.transform(p => new GrayScalePixel(1 + p.value))
    assert(res.getPixel(0,0).value != testingImage.getPixel(0,0).value)
  }

  test("Get pixel negative"){
    assertThrows[Exception]{ testingImage.getPixel(-1,0) }
    assertThrows[Exception]{ testingImage.getPixel(0,-1) }
  }

  test("Get pixel outside"){
    assertThrows[Exception]{ testingImage.getPixel(2,0) }
    assertThrows[Exception]{ testingImage.getPixel(0,3) }
  }

  test("Get pixel OK"){
    assertResult(1){ testingImage.getPixel(0,0).value }
    assertResult(2){ testingImage.getPixel(0,1).value }
  }

}
