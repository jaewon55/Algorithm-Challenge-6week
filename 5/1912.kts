// https://www.acmicpc.net/problem/1912

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val nums = IntArray(n) { token.nextToken().toInt() }

	for (i in 1 until n) {
		nums[i] = maxOf(nums[i], nums[i - 1] + nums[i])
	}
	writer.write("${nums.max()}")
	writer.flush()
}

main()
