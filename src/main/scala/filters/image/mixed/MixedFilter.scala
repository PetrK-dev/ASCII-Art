package filters.image.mixed

import filters.image.ImageFilter
import AsciiArtApp.models.images.{GrayScaleImage, Image, RgbImage}
import AsciiArtApp.models.pixels.Pixel

/**
 * Collects all filters
 *
 * @param filters Seq of Filters
 */
class MixedFilter(filters: Seq[ImageFilter]) extends ImageFilter{
  /**
   * Execute all filters on image
   *
   * @param image image to filter
   * @return The filtered image
   */
  override def filter(image: GrayScaleImage): GrayScaleImage =
    filters.foldLeft(image)((accumulator, filterer) => filterer.filter(accumulator))
}
