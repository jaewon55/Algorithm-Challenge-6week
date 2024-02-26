// https://www.acmicpc.net/problem/11054

import java.util.*

val LEFT = 0
val RIGHT = 1

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val perm = IntArray(n) { token.nextToken().toInt() }
	val dp = Array(2) { IntArray(n) { 1 } }
	var result = 0

	for (i in 1 until n) {
		for (j in 0 until i) {
			if (perm[i] <= perm[j]) continue
			dp[LEFT][i] = maxOf(dp[LEFT][i], dp[LEFT][j] + 1)
		}
	}

	for (i in n - 2 downTo 0) {
		for (j in n - 1 downTo i + 1) {
			if (perm[i] <= perm[j]) continue
			dp[RIGHT][i] = maxOf(dp[RIGHT][i], dp[RIGHT][j] + 1)
		}
	}

	for (i in 0 until n) {
		result = maxOf(result, dp[RIGHT][i] + dp[LEFT][i])
	}
	println(result - 1)
}

main()
