// https://www.acmicpc.net/problem/10971

import java.util.*

val reader = System.`in`.bufferedReader()
val n = reader.readLine().toInt()
val w = Array(n) {
	val token = StringTokenizer(reader.readLine())
	IntArray(n) { token.nextToken().toInt() }
}
var result = Long.MAX_VALUE
val visit = Array(n) { false }

fun recur(depth: Int, position: Int, start: Int, cost: Long) {
	if (depth == n) {
		if (w[position][start] != 0) result = minOf(result, cost + w[position][start])
		return
	}

	for (i in 0 until n) {
		if (visit[i] || w[position][i] == 0) continue
		visit[i] = true
		recur(depth + 1, i, start, cost + w[position][i])
		visit[i] = false
	}
}

fun main() {
	
	for (i in 0 until n) {
		visit[i] = true
		recur(1, i, i, 0L)
		visit[i] = false
	}
	println(result)
}

main()
