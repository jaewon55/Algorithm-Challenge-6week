// https://www.acmicpc.net/problem/11055

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val arr = IntArray(n) { token.nextToken().toInt() }
	val dp = IntArray(n)
	dp[0] = arr[0]
	for (i in 1 until n) {
		dp[i] = arr[i]
		for (j in 0 until i) {
			if (arr[i] <= arr[j]) continue
			dp[i] = maxOf(dp[i], dp[j] + arr[i])
		}
	}
	println(dp.max())
}

main()
