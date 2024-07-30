package filters.image.specific

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.GrayScaleImage
import AsciiArtApp.models.pixels.GrayScalePixel
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class BrightnessFilterTest extends FunSuite with BeforeAndAfterEach{

  var testingImage: GrayScaleImage = _

  override protected def beforeEach(): Unit =  {
    var testingPixels = Array.ofDim[GrayScalePixel](1, 2)
    testingPixels(0)(0) = new GrayScalePixel(0)
    testingPixels(0)(1) = new GrayScalePixel(1)
    testingImage = new GrayScaleImage(new PixelGrid(testingPixels))
  }

  test("Change brightness about positive middle value"){
    val brightFil = new BrightnessFilter(100)

    val afterFilter = brightFil.filter(testingImage)
    assertResult(100){
      afterFilter.getPixel(0,0).value
    }
    assertResult(101){
      afterFilter.getPixel(0,1).value
    }
  }

  test("Change brightness about negative middle value"){
    val brightFil = new BrightnessFilter(-100)

    val afterFilter = brightFil.filter(testingImage)
    assertResult(0){
      afterFilter.getPixel(0,0).value
    }
    assertResult(0){
      afterFilter.getPixel(0,1).value
    }
  }

  test("Change brightness about positive great value"){
    val brightFil = new BrightnessFilter(255)

    val afterFilter = brightFil.filter(testingImage)
    assertResult(255){
      afterFilter.getPixel(0,0).value
    }
    assertResult(255){
      afterFilter.getPixel(0,1).value
    }
  }

  test("Change brightness about negative great value"){
    val brightFil = new BrightnessFilter(-255)

    val afterFilter = brightFil.filter(testingImage)
    assertResult(0){
      afterFilter.getPixel(0,0).value
    }
    assertResult(0){
      afterFilter.getPixel(0,1).value
    }
  }

  test("Change brightness about zero value"){
    val brightFil = new BrightnessFilter(0)

    val afterFilter = brightFil.filter(testingImage)
    assertResult(0){
      afterFilter.getPixel(0,0).value
    }
    assertResult(1){
      afterFilter.getPixel(0,1).value
    }
  }

  test("Add positive middle value"){
    val brightFil = new BrightnessFilter(100)

    val pixel = new GrayScalePixel(100)
    val newPixel = brightFil.addBrightness(pixel)
    assertResult(200) {
      newPixel.value
    }
  }

  test("Add negative middle value"){
    val brightFil = new BrightnessFilter(-100)

    val pixel = new GrayScalePixel(100)
    val newPixel = brightFil.addBrightness(pixel)
    assertResult(0) {
      newPixel.value
    }
  }

  test("Add positive great value"){
    val brightFil = new BrightnessFilter(255)

    val pixel = new GrayScalePixel(100)
    val newPixel = brightFil.addBrightness(pixel)
    assertResult(255) {
      newPixel.value
    }
  }

  test("Add negative great value"){
    val brightFil = new BrightnessFilter(-255)

    val pixel = new GrayScalePixel(100)
    val newPixel = brightFil.addBrightness(pixel)
    assertResult(0) {
      newPixel.value
    }
  }

  test("Add about zero value"){
    val brightFil = new BrightnessFilter(0)

    val pixel = new GrayScalePixel(100)
    val newPixel = brightFil.addBrightness(pixel)
    assertResult(100) {
      newPixel.value
    }
  }

}
