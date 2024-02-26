// https://www.acmicpc.net/problem/11066

import java.util.*

fun solution(files: IntArray, sum: IntArray, k: Int): Int {
	val dp = Array(k + 1) { IntArray(k + 1) }

	for (i in 1 until k) {
		for (j in 1 .. k - i) {
			dp[j][j + i] = Int.MAX_VALUE
			for (m in j until j + i) {
				dp[j][j + i] = minOf(dp[j][j + i], dp[j][m] + dp[m + 1][j + i] + sum[j + i] - sum[j - 1])
			}
		}
	}
	return dp[1][k]
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()

	repeat(t) {
		val k = reader.readLine().toInt()
		val token = StringTokenizer(reader.readLine())
		val sum = IntArray(k + 1)
		val files = IntArray(k + 1)

		for (i in 1 .. k) {
			files[i] = token.nextToken().toInt()
			sum[i] = sum[i - 1] + files[i]
		}
		writer.write("${solution(files, sum, k)}\n")
	}
	writer.flush()
}

main()
