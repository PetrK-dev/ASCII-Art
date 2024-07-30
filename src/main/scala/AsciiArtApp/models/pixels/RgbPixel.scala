package AsciiArtApp.models.pixels

/**
 * Immutable RGB Pixel
 *
 * @param value pixel represented by Int
 */
class RgbPixel(val value: Int)extends Pixel {

  //value of color of RGB is just in range 0-255
  if(r<0||g<0||b<0||r>255||g>255||b>255)
    throw new Exception("RGB value is out of range 0-255")

  //returns chosen color of RGB Pixel
  def r: Int = (value >> 16) & 0xff
  def g: Int = (value >> 8)  & 0xff
  def b: Int =  value        & 0xff
}