package exporters.text.mixed

import exporters.text.TextExporter

/**
 * Collects all text exporters
 *
 * @param exporters Seq of exporters
 */
class MixedExporter(exporters: Seq[TextExporter]) extends TextExporter{

  /**
   * Execute all exporters on item
   *
   * @param image String to export
   */
  override def export(image: String): Unit =
    exporters.foreach(exporter => exporter.export(image))
}
