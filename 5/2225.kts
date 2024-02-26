// https://www.acmicpc.net/problem/2225

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val k = token.nextToken().toInt()
	val mod = 1_000_000_000
	val dp = Array(k) { i ->
		IntArray(n + 1) { j ->
			if (i == 0 || j == 0) 1 else 0
		}
	}
	for (i in 1 until k) {
		for (j in 1..n) {
			dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod
		}
	}
	println(dp[k - 1][n])
}

main()
