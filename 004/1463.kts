// https://www.acmicpc.net/problem/1463

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val n = reader.readLine().toInt()
    val dp = IntArray(n)
    if (n > 1) dp[1] = 1
    if (n > 2) dp[2] = 1
    for (i in 3 until n) {
      val a = if ((i + 1) % 3 == 0) dp[(i + 1) / 3 - 1] else Int.MAX_VALUE
      val b = if ((i + 1) % 2 == 0) dp[(i + 1) / 2 - 1] else Int.MAX_VALUE
      val c = dp[i - 1]
      dp[i] = minOf(a, b, c) + 1
    }
    writer.write("${dp[n - 1]}")
    writer.flush()
}

main()
