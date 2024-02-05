// https://www.acmicpc.net/problem/10422

import java.util.*

val DIV = 1_000_000_007

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	val case = IntArray(t) { reader.readLine().toInt() }
	val dp = IntArray(5001)

	dp[0] = 1
	dp[2] = 1
	dp[4] = 2

	for (i in 6 .. case.max() step 2) {
		for (j in 0 until i step 2) {
			val sum = (dp[j].toLong() * dp[i - j - 2] % DIV).toInt()
			dp[i] = (dp[i] + sum) % DIV
		}
	}

	for (c in case) {
		writer.write("${dp[c]}\n")
	}
	writer.flush()
}

main()
