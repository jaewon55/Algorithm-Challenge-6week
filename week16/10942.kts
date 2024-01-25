// https://www.acmicpc.net/problem/10942

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val perm = IntArray(n) { token.nextToken().toInt() }
	val dp = Array(n) { BooleanArray(n) }

	for (i in 0 until n) {
		dp[i][i] = true
	}
	for (i in 0 until n - 1) {
		if (perm[i] == perm[i + 1]) dp[i][i + 1] = true
	}

	for (size in 3..n) {
		for (i in 0 until n - size + 1) {
			val j = i + size - 1
			if (perm[i] == perm[j] && dp[i + 1][j - 1]) {
				dp[i][j] = true
			}
		}
	}

	repeat(reader.readLine().toInt()) {
		val se = StringTokenizer(reader.readLine())
		val s = se.nextToken().toInt()
		val e = se.nextToken().toInt()

		if (dp[s - 1][e - 1]) {
			writer.write("1\n")
		} else {
			writer.write("0\n")
		}
	}
	writer.flush()
}

main()
