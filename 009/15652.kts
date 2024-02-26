// https://www.acmicpc.net/problem/15652

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val arr = IntArray(m)

	fun recur(depth: Int) {
		if (depth == m) {
			writer.write("${arr.joinToString(" ")}\n")
			return
		}

		for (i in 1 .. n) {
			if (0 < depth && i < arr[depth - 1]) continue
			arr[depth] = i
			recur(depth + 1)
		}
	}
	recur(0)
	writer.flush()
}

main()
