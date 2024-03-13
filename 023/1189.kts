// https://www.acmicpc.net/problem/1189

import java.util.*

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val r = token.nextToken().toInt()
val c = token.nextToken().toInt()
val k = token.nextToken().toInt()
val map = Array(r) { reader.readLine() }
val visit = Array(r) { BooleanArray(c) }
val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)
var result = 0

fun dfs(depth: Int, x: Int, y: Int) {
	if (depth == k) {
		if (x == 0 && y == c - 1) ++result
		return
	}

	for (i in 0 until 4) {
		val nx = x + dx[i]
		val ny = y + dy[i]

		if (nx !in 0 until r || ny !in 0 until c) continue
		if (map[nx][ny] == 'T' || visit[nx][ny]) continue
		visit[nx][ny] = true
		dfs(depth + 1, nx, ny)
		visit[nx][ny] = false
	}
}

fun main() {
	visit[r - 1][0] = true
	dfs(1, r - 1, 0)
	println(result)
}

main()
