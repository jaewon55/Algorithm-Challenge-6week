// https://www.acmicpc.net/problem/11048

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val maze = Array(n) {
		token = StringTokenizer(reader.readLine())
		IntArray(m) { token.nextToken().toInt() }
	}
	val dp = Array(n) { IntArray(m) }

	dp[0][0] = maze[0][0]

	for (i in 1 until m) {
		dp[0][i] = dp[0][i - 1] + maze[0][i]
	}

	for (i in 1 until n) {
		dp[i][0] = dp[i - 1][0] + maze[i][0]
	}

	for (y in 1 until n) {
		for (x in 1 until m) {
			dp[y][x] = maxOf(dp[y - 1][x], dp[y - 1][x - 1], dp[y][x - 1]) + maze[y][x]
		}
	}
	println(dp[n - 1][m - 1])
}

main()
