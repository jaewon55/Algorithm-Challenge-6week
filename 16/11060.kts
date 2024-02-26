// https://www.acmicpc.net/problem/11060

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val maze = IntArray(n) { token.nextToken().toInt() }
	val visit = BooleanArray(n)
	val dp = IntArray(n) { Int.MAX_VALUE }

	dp[0] = 0
	visit[0] = true
	for (i in 1 until n) {
		for (j in 0 until i) {
			if (visit[j] == false || j + maze[j] < i) continue
			dp[i] = minOf(dp[i], dp[j] + 1)
			visit[i] = true
		}
	}

	if (visit[n - 1] == false) {
		println(-1)
	} else {
		println(dp[n - 1])
	}
}

main()
