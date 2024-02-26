// https://www.acmicpc.net/problem/1149

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	var token : StringTokenizer
	val arr = Array(n) {
		token = StringTokenizer(reader.readLine())
		IntArray(3) { token.nextToken().toInt() }
	}
	val dp = Array(n) { IntArray(3) }
	dp[0] = arr[0]
	for (i in 1 until n) {
		dp[i][0] = minOf(dp[i - 1][1], dp[i -1][2]) + arr[i][0]
		dp[i][1] = minOf(dp[i - 1][0], dp[i -1][2]) + arr[i][1]
		dp[i][2] = minOf(dp[i - 1][0], dp[i -1][1]) + arr[i][2]
	}
	writer.write("${dp[n - 1].min()}")
	writer.flush()
}

main()
