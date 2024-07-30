package AsciiArtApp.App

import AsciiArtApp.UI.UI.{imageExecutors, imageFilters, imageLoaders, parse}
import convertors.image.specific.{GrayScaleToAsciiConvertor, RgbToGrayScaleConvertor}
import exporters.text.mixed.MixedExporter
import filters.image.mixed.MixedFilter

/**
 * Application
 */
object Main extends App {
   run()

  /**
   * Run main app
   */
  def run ():Unit = {
    //load arguments and set them to variables
    parse(args.toList)
    val imageLoader = imageLoaders.head
    val imageFilter = new MixedFilter(imageFilters.toSeq)
    val imageExporter = new MixedExporter(imageExecutors.toSeq)

    //load RGB image
    val rgbImage = imageLoader.load()

    //convert RGB image to Gray scale image
    val grayScaleImage = RgbToGrayScaleConvertor.convert(rgbImage)

    //run all filters on Gray scale image
    val filteredGrayScaleImage = imageFilter.filter(grayScaleImage)

    //convert Gray scale image to Ascii art
    val asciiImage = GrayScaleToAsciiConvertor.convert(filteredGrayScaleImage)

    //print or save Ascii art image
    imageExporter.export(asciiImage.toString)
  }
}
