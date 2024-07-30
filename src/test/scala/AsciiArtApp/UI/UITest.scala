package AsciiArtApp.UI

import exporters.text.TextExporter
import filters.image.ImageFilter
import loaders.image.ImageLoader
import org.scalatest.{BeforeAndAfterEach, FunSuite}

import scala.collection.mutable.ArrayBuffer

class UITest extends FunSuite with BeforeAndAfterEach{

  override protected def afterEach(): Unit = {
    UI.imageLoaders = new ArrayBuffer[ImageLoader]
    UI.imageFilters = new ArrayBuffer[ImageFilter]
    UI.imageExecutors = new ArrayBuffer[TextExporter]
  }

    test("Correct args") {
    val textArgs: List[String] = List(
      "--image", "img.jpg",
      "--invert",
      "--flip", "x",
      "--brightness", "5",
      "--output-console"
    )
      UI.parse(textArgs)
  }

  test("Wrong arg") {
    val textArgs: List[String] = List(
      "--image", "img.jpg",
      "--OOP",
      "--flip", "x",
      "--brightness", "5",
      "--output-console"
    )
    assertThrows[IllegalArgumentException] {
      UI.parse(textArgs)
    }
  }

  test("Missing loader") {
    val args: List[String] = List(
      "--invert",
      "--flip", "x",
      "--brightness", "5",
      "--output-console"
    )
    assertThrows[IllegalArgumentException] {
      UI.parse(args)
    }
  }

  test("Too much loaders") {
    val args: List[String] = List(
      "--image", "files/test_gradient.psd",
      "--image-random",
      "--invert",
      "--flip", "x",
      "--brightness", "5",
      "--output-console"
    )
    assertThrows[IllegalArgumentException] {
      UI.parse(args)
    }
  }

  test("Missing export") {
    val args: List[String] = List(
      "--image", "files/test_gradient.psd",
      "--invert",
      "--flip", "x",
      "--brightness", "5"
    )
    assertThrows[IllegalArgumentException] {
      UI.parse(args)
    }
  }
}
