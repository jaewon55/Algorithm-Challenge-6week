// https://www.acmicpc.net/problem/14889

import java.util.*

var min = Int.MAX_VALUE
lateinit var arr: Array<IntArray>

fun calculate(selected: BooleanArray) {
	var sumA = 0
	var sumB = 0
	for (i in 0 until selected.size) {
		for (j in i + 1 until selected.size) {
			if (selected[i] && selected[j]) {
				sumA += arr[i][j] + arr[j][i]
			} else if (!selected[i] && !selected[j]) {
				sumB += arr[i][j] + arr[j][i]
			}
		}
	}
	val abs = Math.abs(sumA - sumB)
	if (abs < min) min = abs
}

fun recur(depth: Int, idx: Int, n: Int, selected: BooleanArray) {
	if (depth == n / 2) {
		return calculate(selected)
	}
	for (i in idx until n) {
		if (selected[i]) continue
		selected[i] = true
		recur(depth + 1, i + 1, n, selected)
		selected[i] = false
	}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	arr = Array(n) {
		val token = StringTokenizer(reader.readLine())
		IntArray(n) { token.nextToken().toInt()}
	}
	recur(0, 0, n, BooleanArray(n){ false })
	writer.write("${min}\n")
	writer.flush()
}

main()
