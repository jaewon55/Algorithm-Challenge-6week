// https://www.acmicpc.net/problem/11053

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val nums = IntArray(n) { token.nextToken().toInt() }
	val dp = IntArray(n) { 1 }

	for (i in 1 until n) {
		for (j in 0 until i) {
			if (nums[i] <= nums[j]) continue
			dp[i] = maxOf(dp[i], dp[j] + 1)
		}
	}
	writer.write("${dp.max()}")
	writer.flush()
}

main()
