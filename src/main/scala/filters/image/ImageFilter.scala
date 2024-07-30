package filters.image

import filters.filter
import AsciiArtApp.models.images.{GrayScaleImage, Image}

/**
 * Filters an image
 */
trait ImageFilter extends filter[GrayScaleImage]
