package AsciiArtApp.models.images

import AsciiArtApp.models.grids.PixelGrid
import AsciiArtApp.models.pixels.RgbPixel

/**
 * Image made up of RGB pixels
 *
 * @param rgbGrid grid of RGB pixels
 */
class RgbImage(val rgbGrid: PixelGrid[RgbPixel]) extends Image(rgbGrid)
