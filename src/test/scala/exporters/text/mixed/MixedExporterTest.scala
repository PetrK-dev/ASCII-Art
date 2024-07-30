package exporters.text.mixed

import java.io.{ByteArrayOutputStream, File}

import exporters.text.{FileOutputExporter, StreamTextExporter}
import helpers.TestWithFiles
import org.scalatest.FunSuite

class MixedExporterTest extends FunSuite with TestWithFiles{

  test("Single exporter - file output"){
    val fileName = getTestFile

    try {
      ensureDeleted(fileName)

      val file = new File(fileName)
      val fileExporter = new FileOutputExporter(file)
      val mixedExporter = new MixedExporter( List( fileExporter ) )

      mixedExporter.export("Ahoj")
      fileExporter.close()

      assertFileContent(fileName, "Ahoj")
    }
    finally {
      ensureDeleted(fileName)
    }
  }


  test("Single exporter - stream"){
    val stream = new ByteArrayOutputStream()
    val mixedExporter = new MixedExporter( List( new StreamTextExporter(stream) ) )

    mixedExporter.export("Ahoj")

    assert(stream.toString("UTF-8") == "Ahoj")
}

  test("Mixed all exporters - file output, stream"){
    val fileName = getTestFile
    val stream = new ByteArrayOutputStream()
    try {
      ensureDeleted(fileName)

      val file = new File(fileName)

      val fileExporter = new FileOutputExporter(file)
      val mixedExporter = new MixedExporter( List(fileExporter, new StreamTextExporter(stream) ) )
      mixedExporter.export("Ahoj")
      fileExporter.close()

      assert(stream.toString("UTF-8") == "Ahoj")
      assertFileContent(fileName, "Ahoj")
    }
    finally {
      ensureDeleted(fileName)
    }
  }


}
