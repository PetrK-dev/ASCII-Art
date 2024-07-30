package loaders.image.specific

import java.awt.image.BufferedImage

import AsciiArtApp.models.images.RgbImage
import loaders.image.ImageLoader

import scala.util.Random

/**
 * Generates random image
 *
 * @return The generated random Image to RGB
 */
class RandomImageLoader() extends ImageLoader{
  val width = 20
  val height = 10

  /**
   * Generates the random image
   * @return The generated random image
   */
  override def load(): RgbImage = {
    //Generate random imageBuffer and use JPGLoader to create RGB image
    var img: BufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

    for (x <- 0 until height) {
      for (y <- 0 until width) {
        val r: Int = Random.nextInt(255)
        val g: Int = Random.nextInt(255)
        val b: Int = Random.nextInt(255)

        val pixel: Int = (r<<16) | (g<<8) | b
        img.setRGB(y, x, pixel)
      }
    }
    new JPGLoader(img).load()
  }
}

