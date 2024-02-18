// https://www.acmicpc.net/problem/5557

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val numbers = IntArray(n) { token.nextToken().toInt() }
	val dp = Array(101) { LongArray(21) }

	dp[0][numbers[0]] = 1

	for (i in 1 until n - 1) {
		val number = numbers[i]
		for (j in 0 .. 20) {
			if (dp[i - 1][j] == 0L) continue

			val plus = j + number
			val minus = j - number

			if (plus in 0..20) dp[i][plus] += dp[i - 1][j]
			if (minus in 0..20) dp[i][minus] += dp[i - 1][j]
		}
	}
	println(dp[n - 2][numbers[n - 1]])
}

main()
