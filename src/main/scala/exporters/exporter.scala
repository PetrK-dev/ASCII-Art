package exporters

trait exporter[T] {
  /**
   * Exports an item
   * @param item The item to export
   */
  def export(item: T): Unit
}
