// https://www.acmicpc.net/problem/2193

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val dp = Array(n) {
		LongArray(2)
	}
	dp[0][1] = 1L
	for (i in 1 until n) {
		dp[i][0] = dp[i - 1].sum()
		dp[i][1] = dp[i - 1][0]
	}
	writer.write("${dp[n - 1].sum()}")
	writer.flush()
}

main()
