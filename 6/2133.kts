// https://www.acmicpc.net/problem/2133

fun main() {
	val n = System.`in`.bufferedReader().readLine().toInt()
	val dp = IntArray(31)
	dp[2] = 3
	for (i in 4..n step 2) {
		dp[i] = dp[i - 2] * 3 + 2
		for (j in 2 until i - 2 step 2) {
			dp[i] += dp[j] * 2
		}
	}
	println(dp[n])
}

main()
