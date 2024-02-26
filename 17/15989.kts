// https://www.acmicpc.net/problem/15989

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var t = reader.readLine().toInt()
	val numbers = IntArray(t) { reader.readLine().toInt() }
	val dp = Array(10_001) { IntArray(4) }

	dp[1][1] = 1
	dp[2][1] = 1
	dp[2][2] = 1
	dp[3][1] = 1
	dp[3][2] = 1
	dp[3][3] = 1

	for (i in 4..numbers.max()) {
		dp[i][1] = dp[i - 1][1]
		dp[i][2] = dp[i - 2][1] + dp[i - 2][2]
		dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]
	}

	for (n in numbers) {
		writer.write("${dp[n].sum()}\n")
	}

	writer.flush()
}

main()
