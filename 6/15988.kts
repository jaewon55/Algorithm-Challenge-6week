// https://www.acmicpc.net/problem/15988

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	val nums = IntArray(t) { reader.readLine().toInt() }
	val max = nums.max() ?: 1
	val mod = 1_000_000_009
	val dp = LongArray(max)
	dp[0] = 1L
	if (max > 1) dp[1] = 2L
	if (max > 2) dp[2] = 4L
	for (i in 3 until max) {
		dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod
	}
	for (e in nums) {
		writer.write("${dp[e - 1]}\n")
	}
	writer.flush()
}

main()
