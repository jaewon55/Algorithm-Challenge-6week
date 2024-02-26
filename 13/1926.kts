// https://www.acmicpc.net/problem/1926

import java.util.*


val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val map = Array(n) { 
	token = StringTokenizer(reader.readLine())
	BooleanArray(m) { token.nextToken() == "1" }
}
val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

fun isOutOfMap(x: Int, y: Int) = x < 0 || m <= x || y < 0 || n <= y

fun bfs(x: Int, y: Int): Int {
	var	size = 1
	val q: Queue<Pair<Int, Int>> = LinkedList()
	map[y][x] = false
	q.offer(x to y)

	while (q.isNotEmpty()) {
		val position = q.poll()

		for (i in 0 until 4) {
			val nx = position.first + dx[i]
			val ny = position.second + dy[i]

			if (isOutOfMap(nx, ny) || !map[ny][nx]) continue
			map[ny][nx] = false
			q.offer(nx to ny)
			++size
		}
	}
	return size
}

fun main() {
	var count = 0
	var biggest = 0

	for (y in 0 until n) {
		for (x in 0 until m) {
			if (!map[y][x]) continue
			++count
			biggest = maxOf(biggest, bfs(x, y))
		}
	}
	println(count)
	println(biggest)
}

main()
