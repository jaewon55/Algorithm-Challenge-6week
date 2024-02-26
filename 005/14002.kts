// https://www.acmicpc.net/problem/14002

import java.util.*

data class Element(val num : Int, var count: Int, var prev: Int)

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val nums = IntArray(n) { token.nextToken().toInt() }
	val dp = Array<Element>(n) { Element(nums[it], 1, it) }
	for (i in 1 until n) {
		for (j in 0 until i) {
			if (nums[i] <= nums[j] || dp[j].count + 1 < dp[i].count) continue
			dp[i].count = dp[j].count + 1
			dp[i].prev = j
		}
	}
	val max = dp.maxBy{ it.count }!!
	val list = mutableListOf<Element>()
	writer.write("${max.count}\n")
	var e = max
	while (list.size != max.count) {
		list.add(e)
		e = dp[e.prev]
	}
	list.reverse()
	for (i in 0 until list.size) {
		if (i != 0) writer.write(" ")
		writer.write("${list[i].num}")
	}
	writer.flush()
}

main()
