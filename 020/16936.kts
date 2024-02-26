// https://www.acmicpc.net/problem/16936

import java.util.*

val reader = System.`in`.bufferedReader()
val n = reader.readLine().toInt()
val token = StringTokenizer(reader.readLine())
val arrB = LongArray(n) { token.nextToken().toLong() }
val arrA = LongArray(n) { -1 }

fun dfs(depth: Int, x: Long) {
	if (depth == n) {
		println(arrA.joinToString(" "))
		kotlin.system.exitProcess(0)
	}

	if (x !in arrB || x in arrA) return

	arrA[depth] = x

	dfs(depth + 1, x * 2)

	if (x % 3 == 0L) dfs(depth + 1, x / 3)

	arrA[depth] = -1
}

fun main() {
	for(e in arrB) {
		dfs(0, e)
	}
}

main()
