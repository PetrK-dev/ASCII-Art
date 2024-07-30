package filters

trait filter[T] {
  /**
   * Filters an item
   * @param item The item to filter
   * @return The filtered item
   */
  def filter(item: T): T
}
