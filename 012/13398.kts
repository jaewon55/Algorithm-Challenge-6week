// https://www.acmicpc.net/problem/13398

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val perm = IntArray(n) { token.nextToken().toInt() }
	val dp = Array(n){ IntArray(2) }
	var result = perm[0]

	dp[0][0] = perm[0]
	dp[0][1] = perm[0]
	for (i in 1 until n) {
		dp[i][0] = maxOf(perm[i], dp[i - 1][0] + perm[i])
		dp[i][1] = maxOf(dp[i - 1][0], dp[i - 1][1] + perm[i])
		result = maxOf(result, dp[i][0], dp[i][1])
	}
	println(result)
}

main()
