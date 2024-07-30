package convertors.image.specific

import AsciiArtApp.models.grids.PixelGrid
import convertors.image.ImageConvertor
import AsciiArtApp.models.images.{AsciiImage, GrayScaleImage}
import AsciiArtApp.models.pixels.{AsciiPixel, GrayScalePixel}


/**
 * Converts Gray scale image to Ascii
 */
object GrayScaleToAsciiConvertor extends ImageConvertor[GrayScaleImage, AsciiImage]{

  //val AsciiAlphabet: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~i!lI;:,\\\"^`\". "
  val AsciiAlphabet: String ="@%#*+=-:. "

  /**
   * Gray scale to Ascii art convertor
   *
   * Converts Gray scale image to Ascii
   * @param GrayScaleImage Image in Gray scale
   * @return Image converted to Ascii
   */
  override def convert(img: GrayScaleImage): AsciiImage = {
    val pixels = img.transform(GrayToAscii).getPixels
    new AsciiImage(new PixelGrid(pixels))
  }

  /**
   * Gray scale to Ascii art convertor
   *
   * Converts Gray scale pixel to Ascii
   * @param GrayScalePixel Pixel in Gray scale
   * @return Pixel converted to Ascii
   */
  def GrayToAscii(p: GrayScalePixel): AsciiPixel = {
    val t = 256 / AsciiAlphabet.length.toDouble
    val i = (p.value / t).toInt
    new AsciiPixel(AsciiAlphabet(i))
  }
}
