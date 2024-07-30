package AsciiArtApp.UI

import java.io.File

import exporters.text.{FileOutputExporter, StdOutputExporter, TextExporter}
import filters.image.ImageFilter
import filters.image.defaults.ImageIdentityFilter
import filters.image.specific.{BrightnessFilter, FlipFilter, InvertFilter}
import loaders.image.ImageLoader
import loaders.image.specific.{FileImageManagerLoader, RandomImageLoader}

import scala.collection.mutable.ArrayBuffer


/**
 * Object UI for processing console input
 */
object UI {

  var imageLoaders:  ArrayBuffer[ImageLoader] = new ArrayBuffer[ImageLoader]
  var imageFilters: ArrayBuffer[ImageFilter] = new ArrayBuffer[ImageFilter]
  var imageExecutors: ArrayBuffer[TextExporter] = new ArrayBuffer[TextExporter]

  /**
   * Split arguments from console by categories
   *
   * @param args List of arguments from console
   */
  def parse(args: List[String]): Unit= {
    //add default filter to filters
    imageFilters.append(ImageIdentityFilter)

    //split arguments by categories
    args match {
      case Nil => (imageLoaders, imageFilters.toArray, imageExecutors.toArray)
      case "--image" :: path :: tail =>
        imageLoaders.append(new FileImageManagerLoader(path))
        parse(tail)
      case "--image-random" :: tail =>
        imageLoaders.append(new RandomImageLoader)
        parse(tail)
      case "--invert" :: tail =>
        imageFilters.append(new InvertFilter)
        parse(tail)
      case "--flip" :: value :: tail =>
        imageFilters.append(new FlipFilter(value))
        parse(tail)
      case "--brightness" :: value :: tail =>
        imageFilters.append(new BrightnessFilter(value.toInt))
        parse(tail)
      case "--output-console" :: tail =>
        imageExecutors.append(new StdOutputExporter)
        parse(tail)
      case "--output-file" :: path :: tail =>
        imageExecutors.append(new FileOutputExporter(new File(path)))
        parse(tail)
      case _ => throw new IllegalArgumentException("Wrong input - unknown order")
    }

    if(imageLoaders.length > 1)
      throw new IllegalArgumentException("Wrong input - you can choose only one way to import")

    else if(imageLoaders.length == 0)
      throw new IllegalArgumentException("Wrong input - you must choose way to import")

    if(imageExecutors.length == 0)
      throw new IllegalArgumentException("Wrong input - you must choose at least one way to export")
  }
}
