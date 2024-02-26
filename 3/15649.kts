// https://www.acmicpc.net/problem/15649

import java.util.*

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val arr = IntArray(m)
val visited = BooleanArray(n) { false }

fun recur(depth: Int) {
	if (depth == m) return writer.write("${arr.joinToString(" ")}\n")

	for (i in 1..n) {
		if (visited[i - 1]) continue
		arr[depth] = i
		visited[i - 1] = true
		recur(depth + 1)
		visited[i - 1] = false
	}
}

fun main() {
	recur(0)
	writer.flush()
}


main()
