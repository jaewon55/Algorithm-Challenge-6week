// https://www.acmicpc.net/problem/9095

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	val nums = IntArray(t) {
		reader.readLine().toInt()
	}
	val max = nums.max() ?: 0
	val dp = IntArray(max + 1)
	dp[0] = 1
	dp[1] = 1
	if (t > 1) dp[2] = 2
	for (i in 3..max) {
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
	}
	for(n in nums) {
		writer.write("${dp[n]}\n")
	}
	writer.flush()
}

main()
