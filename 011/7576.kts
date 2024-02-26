// https://www.acmicpc.net/problem/7576

import java.util.*

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val m = token.nextToken().toInt()
val n = token.nextToken().toInt()
val queue: Queue<Pair<Int,Int>> = LinkedList()
val box = Array(n) {
	token = StringTokenizer(reader.readLine())
	IntArray(m) { token.nextToken().toInt() }
}
val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun bfs(): Int {
	var max = 1

	while (!queue.isEmpty()) {
		val p = queue.poll()
		val y = p.first
		val x = p.second

		for (i in 0 until 4) {
			val nextY = y + dy[i]
			val nextX = x + dx[i]
			if (nextY < 0 || n <= nextY || nextX < 0 || m <= nextX) continue
			if (box[nextY][nextX] != 0) continue
			box[nextY][nextX] = box[y][x] + 1
			queue.offer(nextY to nextX)
			if (max < box[nextY][nextX]) max = box[nextY][nextX]
		}
	}
	return max
}

fun main() {
	for (y in 0 until n) {
		for (x in 0 until m) {
			if (box[y][x] == 1) queue.offer(y to x)
		}
	}
	var result = bfs() - 1
	for (arr in box) {
		if (0 in arr) {
			result = -1
			break
		}
	}
	println(result)
}

main()
