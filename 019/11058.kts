// https://www.acmicpc.net/problem/11058

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val dp = LongArray(101)

	for (i in 1 .. n) {
		dp[i] = dp[i - 1] + 1
		for (j in 3 until i) {
			dp[i] = maxOf(dp[i], dp[i - j] * (j - 1))
		}
	}
	println(dp[n])
}

main()
