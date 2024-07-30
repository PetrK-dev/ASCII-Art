package filters.image.defaults

import AsciiArtApp.models.images.GrayScaleImage
import filters.defaults.IdentityFilter
import filters.image.ImageFilter

/**
 * Default filter for image
 */
object ImageIdentityFilter extends ImageFilter{
  /**
   * Filters an image
   * @param image The image to filter
   * @return The filtered image
   */
  override def filter(image: GrayScaleImage): GrayScaleImage = image
}
