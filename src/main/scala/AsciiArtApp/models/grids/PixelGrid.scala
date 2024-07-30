package AsciiArtApp.models.grids

import AsciiArtApp.models.pixels.Pixel

import scala.reflect.ClassTag


/**
 * Immutable Grid of pixels
 *
 * @param pixels 2D matrix of pixels
 * @tparam T Type of Pixel
 */
class PixelGrid[T<:Pixel:ClassTag](val pixels: Array[Array[T]]){
  val height: Int = pixels.length
  val width: Int = pixels.head.length

  //Check empty grid
  if(pixels.isEmpty)
    throw new IllegalArgumentException("Obrazek nema vysku => vyska = 0")

  /**
   * Transform each pixel in the grid using function as a parameter
   *
   * @param func Operator which defines function of transform operation
   * @tparam S Type of Pixel that forms the resulting PixelGrid
   * @return New pixel grid transformed by function
   */
  def transform[S <: Pixel:ClassTag](func: T => S): PixelGrid[S] = {
    val transformedPixels = Array.ofDim[S](height, width)

    for(h <- 0 until height)
      for(w <- 0 until width)
      transformedPixels(h)(w)=func(pixels(h)(w))

    new PixelGrid[S](transformedPixels)
  }

  def getPixels(): Array[Array[T]] = pixels.clone()

  def getPixel(x: Int, y: Int): T = {
    if (x < 0 || y < 0)
      throw new IllegalArgumentException("Zadan zaporny index")
    if(x > height - 1 || y > width - 1)
      throw new IllegalArgumentException("Prilis vysoka hodnota, vyska = "+ height + " a sirka = " + width)

    val tmp = pixels.clone()
    tmp(x)(y)
  }
}
