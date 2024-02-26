// https://www.acmicpc.net/problem/14501

import java.util.*

data class S(val t: Int, val p: Int)

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val s = Array<S>(n) {
		val token = StringTokenizer(reader.readLine())
		S(token.nextToken().toInt(), token.nextToken().toInt())
	}
	val dp = IntArray(n) { 
		if (n < it + s[it].t) 0 else s[it].p
	}
	for (i in 1 until n) {
		if (dp[i] == 0) continue
		for (j in 0 until i) {
			if (i + 1 <= s[j].t + j) continue
			dp[i] = maxOf(dp[i], dp[j] + s[i].p)
		}
	}
	writer.write("${dp.max()}")
	writer.flush()
}

main()
