// https://www.acmicpc.net/problem/1932

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val arr = Array(n) { i ->
		val token = StringTokenizer(reader.readLine())
		IntArray(i + 1) { token.nextToken().toInt() }
	}
	val dp = arr.copyOf()
	for (i in 1 until n) {
		for (j in 0..i) {
			val l = if (j == 0) 0 else dp[i - 1][j - 1]
			val r = if (j == i) 0 else dp[i - 1][j]
			dp[i][j] = maxOf(l, r) + arr[i][j]
		}
	}
	println(dp[n - 1].max())
}

main()
