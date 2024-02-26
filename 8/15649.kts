// https://www.acmicpc.net/problem/15649

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val arr = Array(m) { 0 }
	val visit = Array(n + 1) { false }

	fun recur(depth: Int) {
		if (depth == m) {
			for (i in 0 until depth) {
				writer.write("${arr[i]}")
				if (i + 1 != depth) writer.write(" ")
			}
			writer.write("\n")
			return
		}

		for (i in 1..n) {
			if (visit[i]) continue
			arr[depth] = i
			visit[i] = true
			recur(depth + 1)
			visit[i] = false
		}
	}
	recur(0)
	writer.flush()
}

main()
