// https://www.acmicpc.net/problem/15661

import java.util.*

val reader = System.`in`.bufferedReader()
val n = reader.readLine().toInt()
val table = Array(n) {
	val token = StringTokenizer(reader.readLine())
	IntArray(n) { token.nextToken().toInt() }
}
val selected = BooleanArray(n)
var t = 0
var result = Int.MAX_VALUE

fun diff(): Int {
	var start = 0
	var link = 0

	for (i in 0 until n) {
		for (j in i until n) {
			if (selected[i] != selected[j]) continue
			if (selected[i]) {
				start += table[i][j] + table[j][i]
			} else {
				link += table[i][j] + table[j][i]
			}
		}
	}
	return Math.abs(start - link)
}

fun dfs(depth: Int, s: Int) {
	if (depth == t) {
		result = minOf(result, diff())
		return
	}

	for (i in s until n) {
		if (selected[i]) continue
		selected[i] = true
		dfs(depth + 1, i + 1)
		selected[i] = false
	}
}

fun main() {
	for (i in 1 until n) {
		t = i
		dfs(0, 0)
	}
	println(result)
}

main()
