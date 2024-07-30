package filters.defaults

import filters.filter

/**
 * Default filter
 */
class IdentityFilter[T] extends filter[T]{
  /**
   * Filters an item
   * @param item The item to filter
   * @return The filtered item
   */
  override def filter(item: T): T = item
}
