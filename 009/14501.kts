// https://www.acmicpc.net/problem/14501

import java.util.*

data class Schedule(val t: Int, val p: Int)

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	var token: StringTokenizer
	val schedules = Array(n) {
		token = StringTokenizer(reader.readLine())
		Schedule(token.nextToken().toInt(), token.nextToken().toInt())
	}
	val dp = Array(n) {
		if (n < it + schedules[it].t) 0 else schedules[it].p
	}
	for (i in 1 until n) {
		if (dp[i] == 0) continue
		for (j in 0 until i) {
			if (i < schedules[j].t + j) continue
			dp[i] = maxOf(dp[i], dp[j] + schedules[i].p)
		}
	}
	println(dp.max())
}

main()
