package filters.image.specific

import AsciiArtApp.models.grids.PixelGrid
import filters.image.ImageFilter
import AsciiArtApp.models.images.{GrayScaleImage, Image}
import AsciiArtApp.models.pixels.GrayScalePixel

/**
 * Brightness filter changes the greyscale value
 *
 * @param bright value to add
 */
class BrightnessFilter(bright: Int) extends ImageFilter{

  /**
   * Changes the greyscale value of Image
   *
   * @param img image to filter
   * @return The filtered image
   */
  override def filter(img: GrayScaleImage): GrayScaleImage = {
    val pixels = img.transform(addBrightness).getPixels
    new GrayScaleImage(new PixelGrid(pixels))
  }

  /**
   * Changes the greyscale value of Pixel
   *
   * @param p pixel to change
   * @return The changed pixel
   */
  def addBrightness(p: GrayScalePixel): GrayScalePixel = {
    var newValue: Int = p.value + bright
    if( newValue > 255)
      newValue = 255
    else if(newValue < 0)
      newValue = 0

    new GrayScalePixel(newValue)
  }
}
