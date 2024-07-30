package filters.image.defaults

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.GrayScaleImage
import AsciiArtApp.models.pixels.GrayScalePixel
import filters.defaults.IdentityFilter
import org.scalatest.FunSuite

class ImageIdentityFilterTest extends FunSuite{

  test("Image identity filter"){
    val testingPixels = Array.ofDim[GrayScalePixel](1, 2)
    testingPixels(0)(0) = new GrayScalePixel(1)
    testingPixels(0)(1) = new GrayScalePixel(2)
    val testingImage = new GrayScaleImage(new PixelGrid(testingPixels))

    val res = ImageIdentityFilter.filter(testingImage)
    assert(res == testingImage)
  }
}
