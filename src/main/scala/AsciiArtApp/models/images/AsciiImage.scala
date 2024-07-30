package AsciiArtApp.models.images

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.pixels.AsciiPixel

/**
 * Image made up of Ascii pixels
 *
 * @param asciiGrid grid of Ascii pixels
 */
class AsciiImage(val asciiGrid: PixelGrid[AsciiPixel]) extends Image(asciiGrid){

  /**
   * Put Ascii image to string
   *
   * @return Ascii image in string
   */
  override def toString: String = {
    var pixelsToPrint: String = ""
    for(x <- 0 until height){
      for(y <- 0 until width){
        pixelsToPrint += asciiGrid.getPixel(x,y).value
      }
      pixelsToPrint +='\n'
    }
    pixelsToPrint
  }
}
