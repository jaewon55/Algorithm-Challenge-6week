// https://www.acmicpc.net/problem/15656

import java.util.*

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val numbers = IntArray(n)

fun dfs(depth: Int, prev: String) {
	if (depth == m) {
		writer.write("$prev\n")
		return
	}

	for (i in 0 until n) {
		dfs(depth + 1,"$prev${numbers[i]} ")
	}
}

fun main() {
	token = StringTokenizer(reader.readLine())
	for (i in 0 until n) {
		numbers[i] = token.nextToken().toInt()
	}
	numbers.sort()

	dfs(0, "")
	writer.flush()
}

main()
