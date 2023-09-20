// https://www.acmicpc.net/problem/2156

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val wines = IntArray(n + 1) { if (it == 0) 0 else reader.readLine().toInt() }
	val dp = IntArray(n + 1)
	dp[1] = wines[1]
	if(n > 1) dp[2] = wines[1] + wines[2]
	for (i in 3..n) {
		dp[i] = dp[i - 1]
		dp[i] = maxOf(dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i], dp[i])
	}
	println(dp[n])
}

main()
