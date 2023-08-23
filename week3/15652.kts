// https://www.acmicpc.net/problem/15652

import java.util.StringTokenizer

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val arr = IntArray(m)


fun recur(depth: Int) {
	if (depth === m) return writer.write("${arr.joinToString(" ")}\n")

	for (i in 1..n) {
		if (depth > 0 && arr[depth - 1] > i) continue
		arr[depth] = i
		recur(depth + 1)
	}
}

fun main() {
	recur(0)
	writer.flush()
}

main()
