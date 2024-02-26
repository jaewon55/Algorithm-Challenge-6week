// https://www.acmicpc.net/problem/11052

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val packs = IntArray(n) { token.nextToken().toInt() }
	val dp = Array(n + 1) { IntArray(n + 1) }
	for (i in 1..n) {
		val price = packs[i - 1]
		for (j in 1..n) {
			dp[i][j] = dp[i - 1][j]
			if (j < i) continue
			dp[i][j] = maxOf(dp[i][j], dp[i][j - i] + price)
		}
	}
	writer.write("${dp[n][n]}")
	writer.flush()
}

main()
