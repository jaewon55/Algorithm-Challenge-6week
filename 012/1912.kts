// https://www.acmicpc.net/problem/1912

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val perm = IntArray(n) { token.nextToken().toInt() }
	val dp = IntArray(n)

	dp[0] = perm[0]
	for (i in 1 until n) {
		dp[i] = maxOf(perm[i], dp[i - 1] + perm[i])
	}
	println(dp.max())
}

main()
