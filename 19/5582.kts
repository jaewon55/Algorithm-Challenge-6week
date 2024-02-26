// https://www.acmicpc.net/problem/5582

fun main() {
	val reader = System.`in`.bufferedReader()
	val a = reader.readLine()
	val b = reader.readLine()
	val dp = Array(4001) { IntArray(4001) }
	var result = 0

	for (i in 1 .. a.length) {
		for (j in 1 .. b.length) {
			if (a[i - 1] == b[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1
				result = maxOf(result, dp[i][j])
			}
		}
	}
	println(result)
}

main()
