package loaders.image.specific

import java.io.File

import AsciiArtApp.models.images.RgbImage
import javax.imageio.ImageIO
import loaders.image.ImageLoader

/**
 * Manage loading of image by format
 *
 * @param pathToFile path to image
 * @return The loaded image
 */
class FileImageManagerLoader(val pathToFile: String) extends ImageLoader{

  /**
   * Choose specific loader for image format
   * @return The loaded image
   */
  def load(): RgbImage = {

    val imgBuff = ImageIO.read(new File(pathToFile))

    val fileFormat = pathToFile.substring(pathToFile.lastIndexOf(".") + 1)

    fileFormat match {
      case "jpg"|"jpeg" => new JPGLoader(imgBuff).load()
      case "png" => new PNGLoader(imgBuff).load()
      case _ => throw new IllegalArgumentException("Unsupported format of image")
    }
  }
}