// https://www.acmicpc.net/problem/12996

import java.util.*

val DIV = 1_000_000_007

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val s = token.nextToken().toInt()
val arr = IntArray(3) { token.nextToken().toInt() }
val dp = Array(51) {
	Array(51) {
		Array(51) {
			LongArray(51) { -1L }
		}
	}
}

fun solve(s: Int, a: Int, b: Int, c: Int): Long {
	if (s == 0) {
		if (a == 0 && b == 0 && c == 0) {
			return 1L
		} else {
			return 0L
		}
	}

	if (a < 0 || b < 0 || c < 0) return 0

	if (dp[s][a][b][c] != -1L) return dp[s][a][b][c]

	dp[s][a][b][c] = 0L

	dp[s][a][b][c] += solve(s -1, a - 1, b, c)
	dp[s][a][b][c] += solve(s -1, a, b - 1, c)
	dp[s][a][b][c] += solve(s -1, a, b, c - 1)
	dp[s][a][b][c] += solve(s -1, a - 1, b - 1, c)
	dp[s][a][b][c] += solve(s -1, a - 1, b, c - 1)
	dp[s][a][b][c] += solve(s -1, a, b - 1, c - 1)
	dp[s][a][b][c] += solve(s -1, a - 1, b - 1, c - 1)
	dp[s][a][b][c] = dp[s][a][b][c] % DIV

	return dp[s][a][b][c]
}

fun main() {
	println(solve(s, arr[0], arr[1], arr[2]))
}

main()
