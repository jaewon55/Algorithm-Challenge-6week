// https://www.acmicpc.net/problem/14500

import java.util.*

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val arr = Array(n) {
	token = StringTokenizer(reader.readLine())
	IntArray(m) { token.nextToken().toInt() }
}
val visit = Array(n) {
	Array(m) { false }
}
val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(1, -1, 0, 0)
var result = 0

fun recur(depth: Int, x: Int, y: Int, sum: Int) {
	if (depth == 4) {
		if (result < sum) result = sum
		return
	}

	for (i in 0 until 4) {
		val nextX = x + dx[i]
		val nextY = y + dy[i]

		if (nextX < 0 || nextY < 0 || m <= nextX || n <= nextY) continue
		if (visit[nextY][nextX]) continue

		visit[nextY][nextX] = true
		if (depth == 2) recur(depth + 1, x, y, sum + arr[nextY][nextX])
		recur(depth + 1, nextX, nextY, sum + arr[nextY][nextX])
		visit[nextY][nextX] = false
	}
}

fun main() {
	for (y in 0 until n) {
		for (x in 0 until m) {
			visit[y][x] = true
			recur(1, x, y, arr[y][x])
			visit[y][x] = false
		}
	}
	println(result)
}

main()
