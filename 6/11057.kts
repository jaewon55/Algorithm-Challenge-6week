// https://www.acmicpc.net/problem/11057

fun main() {
	val n = System.`in`.bufferedReader().readLine().toInt()
	val dp = IntArray(10) { 1 }
	val mod = 10007
	repeat(n - 1) {
		for (i in 1 until 10) {
			dp[i] = (dp[i - 1] + dp[i]) % mod
		}
	}
	println(dp.sum() % mod)
}

main()
