package exporters.text

import java.io.{ByteArrayOutputStream, OutputStream}

import org.scalatest.FunSuite

class StreamTextExporterTest extends FunSuite {
  test("Write"){
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.export("Ahoj")

    assert(stream.toString("UTF-8") == "Ahoj")
  }
}

