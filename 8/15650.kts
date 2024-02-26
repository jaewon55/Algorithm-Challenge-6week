// https://www.acmicpc.net/problem/15650

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val arr = Array(m) { 0 }
	
	fun recur(depth: Int, prev: Int) {
		if (depth == m) {
			writer.write("${arr.joinToString(" ")}\n")
			return
		}


		for (i in prev + 1 .. n) {
			arr[depth] = i
			recur(depth + 1, i)
		}
	}
	recur(0, 0)
	writer.flush()
}

main()
