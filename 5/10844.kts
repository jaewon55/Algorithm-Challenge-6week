// https://www.acmicpc.net/problem/10844

val MOD = 1_000_000_000

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val dp = Array(n + 1) {
		if (it == 1) {
			IntArray(10) {1}
		} else {
			IntArray(10)
		}
	}
	dp[1][0] = 0
	for (i in 2..n) {
		for (j in 0..9) {
			dp[i][j] = when (j) {
				0 -> dp[i - 1][1]
				9 -> dp[i - 1][8]
				else -> (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD
			}
		}
	}

	var ret = 0
	for (e in dp[n]) {
		ret = (ret + e) % MOD
	}

	writer.write("$ret")
	writer.flush()
}

main()
