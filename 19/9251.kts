// https://www.acmicpc.net/problem/9251

fun main() {
	val reader = System.`in`.bufferedReader()
	val a = reader.readLine()
	val b = reader.readLine()
	val dp = Array(1001) { IntArray(1001) }

	for (i in 1 .. a.length) {
		for (j in 1 .. b.length) {
			dp[i][j] = if (a[i - 1] == b[j - 1]) {
				dp[i - 1][j - 1] + 1
			} else {
				maxOf(dp[i - 1][j], dp[i][j - 1])
			}
		}
	}
	println(dp[a.length][b.length])
}

main()
