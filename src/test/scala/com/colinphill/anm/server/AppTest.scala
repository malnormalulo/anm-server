package com.colinphill.anm.server

import org.scalatest.{WordSpec, Matchers}
import org.scalatest.prop.{TableDrivenPropertyChecks, PropertyChecks}
import scala.collection.immutable.{BitSet, HashSet, TreeSet}

abstract class AbstractSpec extends WordSpec with TableDrivenPropertyChecks with Matchers with PropertyChecks {
}

class AppTest extends AbstractSpec {

  "A Set" when {
    "empty" should {
      "have size 0" in {
        assert(Set.empty.size == 0)
      }

      "produce NoSuchElementException when head is invoked" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
      val examples =
            Table(
             "set",
             BitSet.empty,
             HashSet.empty[Int],
             TreeSet.empty[Int])
      "again have size 0" in {
        forAll(examples) { set => set.size should be(0) }
      }
    }
  }

  "A number" should {
    "divide in half" in {
      forAll { (n: Int) =>
        whenever(n > 1) { n / 2 should be > 0 }
      }
    }
  }
}
