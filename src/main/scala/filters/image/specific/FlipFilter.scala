package filters.image.specific

import AsciiArtApp.models.grids.PixelGrid
import filters.image.ImageFilter
import AsciiArtApp.models.images.GrayScaleImage
import AsciiArtApp.models.pixels.GrayScalePixel

/**
 * Flip filter flips the image on “y” or “x” axes
 *
 * @param axis PixelGrid of T Pixels
 */
class FlipFilter(axis: String) extends ImageFilter{

  if( axis != "x" && axis != "y" )
    throw new IllegalArgumentException("Wrong input for flip: " + axis + ". Only x or y")

  /**
   * Flips the image on “y” or “x” axes
   *
   * @param img image to filter
   * @return The filtered image
   */
  override def filter(img: GrayScaleImage): GrayScaleImage = {
    val imgGrid = img.getPixels

    axis match {
      case "x" => new GrayScaleImage(new PixelGrid(flipGridX(imgGrid)))
      case "y" => new GrayScaleImage(new PixelGrid(flipGridY(imgGrid)))
      case _ => throw new IllegalArgumentException("wrong input for flip: " + axis)
    }
  }

  //flip the grid on “x” axis
  def flipGridX(imgGrid: Array[Array[GrayScalePixel]]): Array[Array[GrayScalePixel]] = imgGrid.reverse

  //flip the grid on “y” axis
  def flipGridY(imgGrid: Array[Array[GrayScalePixel]]): Array[Array[GrayScalePixel]] = {
    for(i <- 0 until imgGrid.length )
      imgGrid(i) = imgGrid(i).reverse

    imgGrid
  }
}
