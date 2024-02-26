// https://www.acmicpc.net/problem/15990

val DIV = 1_000_000_009L

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	val nums = IntArray(t) { reader.readLine().toInt() }
	val max = nums.max() ?: 0
	val dp = Array(max + 1) {
		LongArray(4)
	}
	dp[0][1] = 1L
	dp[1][1] = 1L
	if (max > 1) dp[2][2] = 1L
	for (i in 3..max) {
		dp[i][1] = dp[i - 1][2] + dp[i - 1][3] % DIV
		dp[i][2] = dp[i - 2][1] + dp[i - 2][3] % DIV
		dp[i][3] = dp[i - 3][1] + dp[i - 3][2] % DIV
	}
	for (e in nums) {
	  writer.write("${dp[e].sum() % DIV}\n")
	}
	writer.flush()
}

main()
