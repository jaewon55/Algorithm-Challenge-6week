// https://www.acmicpc.net/problem/1495

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val s = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	token = StringTokenizer(reader.readLine())
	val v = IntArray(n) { token.nextToken().toInt() }
	val dp = Array(n + 1) { BooleanArray(m + 1) }
	var result = -1

	dp[0][s] = true

	for (i in 1 .. n) {
		for (j in 0 .. m) {
			if (!dp[i - 1][j]) continue

			if (j + v[i - 1] in 0..m) {
				dp[i][j + v[i - 1]] = true
			}

			if (j - v[i - 1] in 0..m) {
				dp[i][j - v[i - 1]] = true
			}
		}
	}

	for (i in m downTo 0) {
		if(dp[n][i]) {
			result = i
			break
		}
	}
	println(result)
}

main()
