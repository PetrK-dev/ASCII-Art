package loaders.image.specific

import java.awt.image.BufferedImage

import org.scalatest.{BeforeAndAfterEach, FunSuite}

class RgbLoaderTest extends FunSuite with BeforeAndAfterEach{
  val testFolder = "src/test/scala/testFiles/"

  test("load small image buffer"){
    var imgBuffer: BufferedImage = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB)
    imgBuffer.setRGB(0, 0, (255<<16) | (255<<8) | 255)
    imgBuffer.setRGB(1, 0, (200<<16) | (60<<8) | 50)
    imgBuffer.setRGB(0, 1, (50<<16) | (40<<8) | 200)
    imgBuffer.setRGB(1, 1, (0<<16) | (0<<8) | 0)

    val rgbLoader = new RgbLoader(imgBuffer)
    val res = rgbLoader.load()
    assert(res.getPixel(0,0).r == 255)
    assert(res.getPixel(0,0).g == 255)
    assert(res.getPixel(0,0).b == 255)
    assert(res.getPixel(0,1).r == 200)
    assert(res.getPixel(0,1).g == 60)
    assert(res.getPixel(0,1).b == 50)
    assert(res.getPixel(1,0).r == 50)
    assert(res.getPixel(1,0).g == 40)
    assert(res.getPixel(1,0).b == 200)
    assert(res.getPixel(1,1).r == 0)
    assert(res.getPixel(1,1).g == 0)
    assert(res.getPixel(1,1).b == 0)

  }
}
