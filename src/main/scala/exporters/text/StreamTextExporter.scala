package exporters.text

import java.io.OutputStream

/**
 * Exports to chosen outputStream
 *
 * @param outputStream stream used to export
 */
class StreamTextExporter(outputStream: OutputStream) extends TextExporter {
  private var closed = false

  /**
   * exports text
   *
   * @param text String to export
   */
  protected def exportToStream(text: String): Unit ={

    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
  }

  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  override def export(item: String): Unit = exportToStream(item)

}
