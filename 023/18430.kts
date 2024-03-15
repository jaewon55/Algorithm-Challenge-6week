// https://www.acmicpc.net/problem/18430

import java.util.*
val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val tree = Array(n) {
	token = StringTokenizer(reader.readLine())
	IntArray(m) { token.nextToken().toInt() }
}
val visit = Array(n) { BooleanArray(m) }
val dx = arrayOf(0 to -1, -1 to 0, 0 to 1, 1 to 0)
val dy = arrayOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
var result = 0

fun bt(p: Int, q: Int, sum: Int) {
	val cx = if (q == m) p + 1 else p
	val cy = if (cx != p) 0 else q
	if (cx == n) {
		result = maxOf(result, sum)
		return
	}

	if (!visit[cx][cy]) {
		visit[cx][cy] = true
		for (i in 0 until 4) {
			val x1 = cx + dx[i].first
			val y1 = cy + dy[i].first
			val x2 = cx + dx[i].second
			val y2 = cy + dy[i].second
			if (x1 !in 0 until n || x2 !in 0 until n) continue
			if (y1 !in 0 until m || y2 !in 0 until m) continue
			if (visit[x1][y1] || visit[x2][y2]) continue
			visit[x1][y1] = true
			visit[x2][y2] = true
			val strength = tree[cx][cy] * 2 + tree[x1][y1] + tree[x2][y2]
			bt(cx, cy + 1, sum + strength)
			visit[x1][y1] = false
			visit[x2][y2] = false
		}
		visit[cx][cy] = false
	}
	bt(cx, cy + 1, sum)
}

fun main() {
	bt(0, 0, 0)
	println(result)
}

main()