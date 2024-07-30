package exporters.text

import java.io.{File, FileOutputStream}

/**
 * Exports to file
 */
class FileOutputExporter(file: File)
  extends StreamTextExporter(new FileOutputStream(file)) {
}
