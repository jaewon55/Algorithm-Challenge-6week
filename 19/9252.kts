// https://www.acmicpc.net/problem/9252

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val a = reader.readLine()
val b = reader.readLine()
val dp = Array(1001) { IntArray(1001) }

fun recur(i: Int, j: Int) {
	if (dp[i][j] == 0) return
	if (a[i - 1] == b[j - 1]) {
		recur(i - 1, j - 1)
		writer.write("${a[i - 1]}")
	} else if (dp[i - 1][j] < dp[i][j - 1]) {
		recur(i, j - 1)
	} else {
		recur(i - 1, j)
	}
}

fun main() {
	for (i in 1 .. a.length) {
		for (j in 1 .. b.length) {
			if (a[i - 1] == b[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1
			} else {
				dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
			}
		}
	}
	writer.write("${dp[a.length][b.length]}\n")
	recur(a.length, b.length)
	writer.write("\n")
	writer.flush()
}

main()
