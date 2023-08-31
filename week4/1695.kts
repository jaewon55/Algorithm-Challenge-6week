// https://www.acmicpc.net/problem/1695

import java.util.*
/*
	LCS(최장 공통 수열)
	팰린드롬 = 뒤집어도 같은 수열
	답 : 원본 수열의 길이 - 원본 수열, 뒤집은 수열의 최장 공통 수열의 길이
	원본 수열에 최장 공통 수열에 해당하지 않는 수를 끼워넣으면 되기 때문
 */

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val nums = IntArray(n) { token.nextToken().toInt() }
	val revNums = nums.reversed()
	val dp = Array(n + 1) { IntArray(n + 1) }

	for (i in 1..n) {
		for (j in 1..n) {
			dp[i][j] = if (nums[i - 1] == revNums[j - 1]) {
				dp[i - 1][j - 1] + 1
			} else {
				maxOf(dp[i - 1][j], dp[i][j - 1])
			}
		}
	}
	writer.write("${n - dp[n][n]}")
	writer.flush()
}

main()
