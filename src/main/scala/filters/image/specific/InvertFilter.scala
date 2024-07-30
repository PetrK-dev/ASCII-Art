package filters.image.specific

import AsciiArtApp.models.grids.PixelGrid
import filters.image.ImageFilter
import AsciiArtApp.models.images.{GrayScaleImage, Image}
import AsciiArtApp.models.pixels.GrayScalePixel

/**
 * Invert filter inverts the grayscale value
 */
class InvertFilter extends ImageFilter {
  /**
   * Inverts the grayscale value of Image
   *
   * @param img image to filter
   * @return The filtered image
   */
  override def filter(img: GrayScaleImage): GrayScaleImage = {
    val pixels = img.transform(p => new GrayScalePixel( 255 - p.value )).getPixels
    new GrayScaleImage(new PixelGrid(pixels))
  }
}
