// https://www.acmicpc.net/problem/11049

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val matrix = Array(n) { 
		val token = StringTokenizer(reader.readLine())
		IntArray(2) { token.nextToken().toInt() }
	}
	val dp = Array(501) { IntArray(501) }

	for (d in 1 until n) {
		for (i in 0 until n - d) {
			val j = i + d
			dp[i][j] = Int.MAX_VALUE
			for (m in i .. i + d) {
				dp[i][j] = minOf(dp[i][j], dp[i][m] + dp[m + 1][i + d] + matrix[i][0] * matrix[m][1] * matrix[i + d][1])
			}
		}
	}
	println(dp[0][n - 1])
}

main()
