package filters.defaults

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.GrayScaleImage
import AsciiArtApp.models.pixels.GrayScalePixel
import filters.image.defaults.ImageIdentityFilter
import org.scalatest.FunSuite

class IdentityFilterTest extends FunSuite{

  test("Identity filter"){
    val testingPixels = Array.ofDim[GrayScalePixel](1, 2)
    testingPixels(0)(0) = new GrayScalePixel(1)
    testingPixels(0)(1) = new GrayScalePixel(2)
    val testingImage = new GrayScaleImage(new PixelGrid(testingPixels))

    val res = new IdentityFilter().filter(testingImage)
    assert(res == testingImage)
  }
}

