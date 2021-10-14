package leetcode

object MedianSortedArrays {
    def main(args: Array[String]): Unit = {
        val start = System.currentTimeMillis()
        val result = findMedianSortedArrays(Array(1, 2), Array(3, 4))
        val time = System.currentTimeMillis() - start
        println(result)
        println(time)
    }

    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val merged = Array.ofDim[Int](nums1.length + nums2.length)
        var i = 0
        var j = 0
        merged.indices.foreach { k =>
            if (i >= nums1.length) {
                merged.update(k, nums2(j))
                j = j + 1
            } else if (j >= nums2.length) {
                merged.update(k, nums1(i))
                i = i + 1
            } else if (nums2(j) < nums1(i)) {
                merged.update(k, nums2(j))
                j = j + 1
            } else {
                merged.update(k, nums1(i))
                i = i + 1
            }
        }
        val mid = merged.length / 2 
        if (merged.length % 2 == 0)
            (merged(mid - 1).toDouble + merged(mid).toDouble) / 2.0
        else
            merged(mid).toDouble
    }

}