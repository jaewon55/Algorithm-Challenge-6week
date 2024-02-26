// https://www.acmicpc.net/problem/15655

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	token = StringTokenizer(reader.readLine())
	val arr = Array(n) {
		token.nextToken().toInt()
	}.sorted()
	val visit = Array(n) { false }
	val numbers = IntArray(m)

	fun recur(depth: Int) {
		if (depth == m) {
			writer.write("${numbers.joinToString(" ")}\n")
			return
		}

		for (i in 0 until n) {
			if (visit[i] || (0 < depth && arr[i] < numbers[depth - 1])) continue
			visit[i] = true
			numbers[depth] = arr[i]
			recur(depth + 1)
			visit[i] = false
		}
	}
	recur(0)
	writer.flush()
}

main()
