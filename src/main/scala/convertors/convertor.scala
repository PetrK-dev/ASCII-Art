package convertors

/**
 * Converts an image
 *
 * @tparam T Type of input item
 * @tparam S Type of output item
 */
trait convertor[T, S] {
  /**
   * Converts an item
   * @param item The item to convert
   * @return The converted item
   */
  def convert(item: T): S
}
