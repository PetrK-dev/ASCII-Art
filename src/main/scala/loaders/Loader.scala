package loaders

trait Loader[T]{
  /**
   * Loads an item
   * @return The loaded item
   */
  def load(): T
}
