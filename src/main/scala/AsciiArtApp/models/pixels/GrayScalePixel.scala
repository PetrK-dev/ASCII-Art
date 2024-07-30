package AsciiArtApp.models.pixels

/**
 * Immutable Gray Scale Pixel
 *
 * @param value pixel represented by Int
 */
class GrayScalePixel(val value: Int) extends Pixel {

  //value of Gray scale is just in range 0-255
  if (value < 0 || value > 255) {
    throw new Exception("GrayScale value is out of range 0-255, vase hodnota: " + value)
  }
}