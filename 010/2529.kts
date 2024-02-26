// https://www.acmicpc.net/problem/2529

import java.util.*

val Long.length: Int
	get() = this.toString().length

fun main() {
	val reader = System.`in`.bufferedReader()
	val k = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val arr = Array(k) { token.nextToken() == "<" }

	var min = Long.MAX_VALUE
	var max = 0L
	val visit = Array(10) { false }
	fun recur(depth: Int, sum: Long) {
		if (depth == k) {
			if (sum < min) min = sum
			if (max < sum) max = sum
			return
		}

		for (i in 0 until 10) {
			if (visit[i]) continue
			if (arr[depth] && !(sum % 10 < i)) continue
			if (!arr[depth] && !(sum % 10 > i)) continue
			visit[i] = true
			recur(depth + 1, sum * 10 + i)
			visit[i] = false
		}
	}
	for (i in 0 until 10) {
		visit[i] = true
		recur(0, i + 0L)
		visit[i] = false
	}
	if (max.length < k + 1) println("0$max") else println(max)
	if (min.length < k + 1) println("0$min") else println(min)
}

main()
