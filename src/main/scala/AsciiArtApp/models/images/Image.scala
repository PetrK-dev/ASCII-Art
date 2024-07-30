package AsciiArtApp.models.images

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.pixels.Pixel

import scala.reflect.ClassTag


/**
 * Immutable Image
 *
 * @param pixelGrid PixelGrid of T Pixels
 * @tparam T Type of Pixel that forms this image
 */
class Image[T<:Pixel](val pixelGrid: PixelGrid[T]) {

  def width: Int = pixelGrid.width

  def height: Int = pixelGrid.height

  /**
   * Transform each pixel in the grid using function as a parameter
   *
   * @param func Operator which defines function of transform operation
   * @tparam S Type of Pixel of resulting Image
   * @return New pixel grid transformed by function
   */
  def transform[S <:Pixel:ClassTag](func: T => S): Image[S] = new Image[S](pixelGrid.transform(func))

  def getPixels: Array[Array[T]] = pixelGrid.getPixels()

  def getPixel(x: Int, y: Int): T = pixelGrid.getPixel(x,y)
}
