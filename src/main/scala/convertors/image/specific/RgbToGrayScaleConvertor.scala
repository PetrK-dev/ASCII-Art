package convertors.image.specific

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.{GrayScaleImage, RgbImage}
import AsciiArtApp.models.pixels.{GrayScalePixel, RgbPixel}
import convertors.image.ImageConvertor

/**
 * Converts RGB image to greyscale
 */
object RgbToGrayScaleConvertor extends ImageConvertor[RgbImage, GrayScaleImage]{

  /**
   * Converts RGB image to greyscale image
   * @param RgbImage Image in RGB
   * @return Image converted to greyscale
   */
  override def convert(img: RgbImage): GrayScaleImage = {
    val pixels = img.transform(rgbToGray).getPixels
    new GrayScaleImage(new PixelGrid(pixels))
  }


  /**
   * Converts RGB pixel to greyscale pixel
   * @param RgbPixel Pixel in RGB
   * @return Pixel converted to greyscale
   */
  def rgbToGray(p: RgbPixel): GrayScalePixel = {
    new GrayScalePixel( ((0.3 * p.r) + (0.59 * p.g) + (0.11 * p.b)).toInt )
  }
}
