package loaders.image.specific

import java.io. IOException

import org.scalatest.FunSuite

class FileImageManagerLoaderTest extends FunSuite{
  val testFolder = "src/test/scala/testFiles/"

  test("Load png") {
    val loader: FileImageManagerLoader = new FileImageManagerLoader(testFolder + "test.png")
    assert(loader.load != null)
  }

  test("Load jpg") {
    val loader: FileImageManagerLoader = new FileImageManagerLoader(testFolder + "test.jpg")
    assert(loader.load != null)
  }

  test("Not existing file") {
    val loader: FileImageManagerLoader = new FileImageManagerLoader(testFolder + "notExists.png")
    intercept[IOException]{
      loader.load
    }
  }

  test("Not supported format") {
    val loader: FileImageManagerLoader = new FileImageManagerLoader(testFolder + "nice.try")
    intercept[IOException]{
      loader.load
    }
  }

}