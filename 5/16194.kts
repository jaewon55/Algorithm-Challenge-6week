// https://www.acmicpc.net/problem/16194

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val pack = Array(n) { token.nextToken().toInt() }
	val dp = Array(n + 1) { IntArray(n + 1) }

	for (i in 1..n) {
		val price = pack[i - 1]
		for (j in 1..n) {
			dp[i][j] = dp[i - 1][j]
			if (j < i) continue
			dp[i][j] = if (dp[i][j] == 0) {
				dp[i][j - 1] + price
			} else {
				minOf(dp[i][j], dp[i][j - i] + price)
			}
		}
	}
	writer.write("${dp[n][n]}")
	writer.flush()
}

main()
