package leetcode

object MedianSortedArrays {
  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()
    val result = findMedianSortedArrays(Array(1, 2), Array(3, 4))
    val time = System.currentTimeMillis() - start
    println(result)
    println(time)
  }

  // Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median
  // of the two sorted arrays.
  //
  // The overall run time complexity should be O(log (m+n)).

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val merged = Array.ofDim[Int](nums1.length + nums2.length)
    var i = 0
    var j = 0
    merged.indices.foreach { k =>
      if (i >= nums1.length) {
        merged(k) = nums2(j)
        j += 1
      } else if (j >= nums2.length) {
        merged(k) = nums1(i)
        i += 1
      } else if (nums2(j) < nums1(i)) {
        merged(k) = nums2(j)
        j += 1
      } else {
        merged(k) = nums1(i)
        i += 1
      }
    }
    val mid = merged.length / 2
    if (merged.length % 2 == 0)
      (merged(mid - 1).toDouble + merged(mid).toDouble) / 2.0
    else
      merged(mid).toDouble
  }

}