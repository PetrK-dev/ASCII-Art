package loaders.image.specific

import java.awt.image.BufferedImage

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.images.RgbImage
import AsciiArtApp.models.pixels.RgbPixel
import loaders.image.ImageLoader

/**
 * Loads image to RGB model
 *
 * @param imgBuffer buffer of file to load
 * @return The loaded Image to RGB
 */
class RgbLoader(imgBuffer: BufferedImage) extends ImageLoader {

  /**
   * Loads the image from imageBuffer
   * @return The loaded image
   */
  override def load(): RgbImage = {

    val height = imgBuffer.getHeight
    val width = imgBuffer.getWidth
    var pixels: Array[Array[RgbPixel]] = new Array[Array[RgbPixel]](height)

    for(h <- 0 until height){
      val pixelArray: Array[RgbPixel] = new Array[RgbPixel](width)
      for(w <- 0 until width){
        val rgbPixel = imgBuffer.getRGB(w, h)
        pixelArray(w) = new RgbPixel(rgbPixel)
      }
      pixels(h) = pixelArray
    }
    new RgbImage(new PixelGrid(pixels))
  }
}
