// https://www.acmicpc.net/problem/1309

fun main() {
	val n = System.`in`.bufferedReader().readLine().toInt()
	val dp = Array(n + 1) {
		IntArray(3)
	}
	val mod = 9901
	dp[0][0] = 1
	for (i in 1..n) {
		dp[i][0] = dp[i - 1].sum() % mod
		dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod
		dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod
	}
	println(dp[n].sum() % mod)
}

main()
