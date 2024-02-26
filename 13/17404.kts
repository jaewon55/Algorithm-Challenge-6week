// https://www.acmicpc.net/problem/17404

import java.util.*

val INF = 1000 * 1000 + 1

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val arr = Array(n) {
		val token = StringTokenizer(reader.readLine())
		IntArray(3) { token.nextToken().toInt() }
	}
	val dp = Array(n) { IntArray(3) }

	var result = INF

	for (i in 0 until 3) {
		for (j in 0 until 3) {
			dp[0][j] = if (i == j) arr[0][j] else INF
		}
		for (j in 1 until n) {
			dp[j][0] = arr[j][0] + minOf(dp[j - 1][1], dp[j - 1][2])
			dp[j][1] = arr[j][1] + minOf(dp[j - 1][0], dp[j - 1][2])
			dp[j][2] = arr[j][2] + minOf(dp[j - 1][1], dp[j - 1][0])
		}
		dp[n - 1][i] = INF
		result = minOf(dp[n - 1].min(), result)
	}
	println(result)
}

main()
