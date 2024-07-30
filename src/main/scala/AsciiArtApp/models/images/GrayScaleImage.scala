package AsciiArtApp.models.images

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.pixels.GrayScalePixel

/**
 * Image made up of Grayscale pixels
 *
 * @param grayScaleGrid grid of Grayscale pixels
 */
class GrayScaleImage(val grayScaleGrid: PixelGrid[GrayScalePixel]) extends Image(grayScaleGrid)
