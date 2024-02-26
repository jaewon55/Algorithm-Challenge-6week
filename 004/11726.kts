// https://www.acmicpc.net/problem/11726

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val n = reader.readLine().toInt()
    val dp = IntArray(n)
    dp[0] = 1
    if (n > 1) dp[1] = 2
    for (i in 2 until n) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }
    writer.write("${dp[n - 1]}")
    writer.flush()
}

main()
