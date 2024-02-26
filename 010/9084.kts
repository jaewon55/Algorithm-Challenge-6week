// https://www.acmicpc.net/problem/9084

import java.util.*

val coins = IntArray(20)

fun solve(n: Int, m: Int): Int {
	val dp = IntArray(10001)
	dp[0] = 1
	for (i in 1 .. n) {
		val coin = coins[i - 1]
		for (j in coin .. m) {
			dp[j] += dp[j - coin]
		}
	}
	return dp[m]
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	var n: Int
	var token: StringTokenizer
	var m: Int

	for (i in 0 until t) {
		n = reader.readLine().toInt()
		token = StringTokenizer(reader.readLine())
		for (j in 0 until n) {
			coins[j] = token.nextToken().toInt()
		}
		m = reader.readLine().toInt()
		writer.write("${solve(n, m)}\n")
	}
	writer.flush()
}

main()
