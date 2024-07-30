package loaders.image.specific

import org.scalatest.FunSuite

class RandomImageLoaderTest extends FunSuite{

  test("No exporter"){
    val loader = new RandomImageLoader()
    val res = loader.load()

    assertResult(20){ res.width }
    assertResult(10){ res.height }
  }
}

