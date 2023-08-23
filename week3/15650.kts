// https://www.acmicpc.net/problem/15650

import java.util.StringTokenizer
import java.io.*

fun recur(depth: Int, n: Int, m: Int, arr: IntArray, writer: BufferedWriter) {
	if (depth == m) return writer.write("${arr.joinToString(" ")}\n")

	val start = if (depth > 0) arr[depth - 1] + 1 else 1

	for (i in start..n) {
		arr[depth] = i
		recur(depth + 1, n, m, arr, writer)
	}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val arr = IntArray(m)

	recur(0, n, m, arr, writer)
	writer.flush()
}

main()
