// https://www.acmicpc.net/problem/2294

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val k = token.nextToken().toInt()
	val coins = IntArray(n) { reader.readLine().toInt() }.toSet()
	val dp = IntArray(k + 1) { 10_001 }

	dp[0] = 0

	for (coin in coins) {
		for (i in coin .. k) {
			dp[i] = minOf(dp[i], dp[i - coin] + 1)
		}
	}
	if (10_000 < dp[k]) println(-1) else println(dp[k])
}

main()
