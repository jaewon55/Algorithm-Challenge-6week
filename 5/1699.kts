// https://www.acmicpc.net/problem/1699

fun main() {
	val n = readln().toInt()
	var s = 2
	val dp = IntArray(n + 1)
	dp[1] = 1
	for (i in 2..n) {
		if (i == s*s) {
			++s
			dp[i] = 1
		} else {
			dp[i] = dp[i - (s - 1) * (s - 1)] + 1
			for (j in 1 until s - 1) {
				dp[i] = minOf(dp[i], dp[i - j * j] + 1)
			}
		}
	}
	println(dp[n])
}

main()
