// https://www.acmicpc.net/problem/2293

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val k = token.nextToken().toInt()
	val coins = IntArray(n) { reader.readLine().toInt() }.sorted()
	val dp = IntArray(k + 1)

	dp[0] = 1
	for (coin in coins) {
		for (i in coin .. k) {
			dp[i] = dp[i] + dp[i - coin]
		}
	}
	println(dp[k])
}

main()
