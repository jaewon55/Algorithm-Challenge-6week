// https://www.acmicpc.net/problem/11722

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val arr = IntArray(n) { token.nextToken().toInt() }
	val dp = IntArray(n) { 1 }
	for (i in 1 until n) {
		for (j in 0 until i) {
			if (arr[j] <= arr[i]) continue
			dp[i] = maxOf(dp[i], dp[j] + 1)
		}
	}
	println(dp.max())
}

main()
