package exporters.text

import java.io.{File, FileOutputStream}

import helpers.TestWithFiles
import org.scalatest.FunSuite

class FileOutputExporterTest extends FunSuite
  with TestWithFiles{

  test("No file exists"){
    val fileName = getTestFile

    try {
      ensureDeleted(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputExporter(file)

      exporter.export("Ahoj")
      exporter.close()

      assertFileContent(fileName, "Ahoj")
    }
    finally {
      ensureDeleted(fileName)
    }
  }

  test("File already exists"){
    val fileName = getTestFile

    try{
      ensureCreated(fileName)

      val file = new File(fileName)
      val exporter = new FileOutputExporter(file)

      exporter.export("Ahoj")
      exporter.close()

      assertFileContent(fileName, "Ahoj")
    }
    finally{
      ensureDeleted(fileName)
    }
  }
}

