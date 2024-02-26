// https://www.acmicpc.net/problem/9465

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val sb = java.lang.StringBuilder()
	val t = reader.readLine().toInt()
	val sticker = Array(2) { IntArray(100_001) }
	val dp = Array(2) { IntArray(100_001) }

	repeat(t) {
		val n = reader.readLine().toInt()
		var token = StringTokenizer(reader.readLine())
		for (i in 0 until n) {
			sticker[0][i] = token.nextToken().toInt()
		}
		token = StringTokenizer(reader.readLine())
		for (i in 0 until n) {
			sticker[1][i] = token.nextToken().toInt()
		}

		dp[0][0] = sticker[0][0]
		dp[1][0] = sticker[1][0]
		dp[0][1] = dp[1][0] + sticker[0][1]
		dp[1][1] = dp[0][0] + sticker[1][1]
		
		for (i in 2 until n) {
			dp[0][i] = maxOf(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i]
			dp[1][i] = maxOf(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i]
		}
		sb.append("${maxOf(dp[0][n - 1], dp[1][n - 1])}\n")
	}
	print(sb)
}

main()
