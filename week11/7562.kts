// https://www.acmicpc.net/problem/7562

import java.util.*

val dx = arrayOf(-1, -1, 1, 1, -2, 2, -2, 2)
val dy = arrayOf(2, -2, 2, -2, 1, 1, -1, -1)
val check = Array(300) { IntArray(300) }

fun isOut(x: Int, y: Int, n: Int) = x < 0 || n <= x || y < 0 || n <= y

fun bfs(from: Pair<Int, Int>, to: Pair<Int, Int>, n: Int): Int {
	if (from.first == to.first && from.second == to.second) return 0
	val q: Queue<Pair<Int, Int>> = LinkedList()
	val visit = Array(n) { BooleanArray(n) }
	q.offer(from)
	check[from.first][from.second] = 0
	visit[from.first][from.second] = true

	while (!q.isEmpty()) {
		val p = q.poll()
		val y = p.first
		val x = p.second

		for (i in 0 until 8) {
			val nextY = y + dy[i]
			val nextX = x + dx[i]
			if (isOut(nextX, nextY, n) || visit[nextY][nextX]) continue
			if (to.first == nextY && to.second == nextX) {
				return check[y][x] + 1
			} else {
				check[nextY][nextX] = check[y][x] + 1
				q.offer(nextY to nextX)
				visit[nextY][nextX] = true
			}
		}
	}
	return 0
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	repeat(t) {
		val n = reader.readLine().toInt()
		var token = StringTokenizer(reader.readLine())
		val from = token.nextToken().toInt() to token.nextToken().toInt()
		token = StringTokenizer(reader.readLine())
		val to = token.nextToken().toInt() to token.nextToken().toInt()
		writer.write("${bfs(from, to, n)}\n")
	}
	writer.flush()
}

main()
