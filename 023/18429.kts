// https://www.acmicpc.net/problem/18429

import java.util.*

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val k = token.nextToken().toInt()
val kit = IntArray(n)
val visit = BooleanArray(n)
var result = 0

fun dfs(depth: Int, sum: Int) {
	if (depth == n) {
		++result
		return
	}

	for (i in 0 until n) {
		if (visit[i] || sum + kit[i] - k < 0) continue
		visit[i] = true
		dfs(depth + 1, sum + kit[i] - k)
		visit[i] = false
	}
}

fun main() {
	token = StringTokenizer(reader.readLine())
	for (i in 0 until n) {
		kit[i] = token.nextToken().toInt()
	}
	dfs(0, 0)
	println(result)
}

main()
