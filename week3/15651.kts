// https://www.acmicpc.net/problem/15651

import java.util.*
import java.io.*

fun recur(depth: Int, arr: IntArray, n: Int, m: Int, writer: BufferedWriter) {
	if (depth == m) return writer.write("${arr.joinToString(" ")}\n")

	for (i in 1..n) {
		arr[depth] = i
		recur(depth + 1, arr, n, m, writer)
	}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()

	recur(0, IntArray(m), n, m, writer)
	writer.flush()
}

main()
