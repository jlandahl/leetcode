package leetcode

class FirstBadVersionSpec extends Spec {
  "firstBadVersion" should "return 243" in {
    FirstBadVersion.firstBadVersion(300) should be (243)
  }
}
