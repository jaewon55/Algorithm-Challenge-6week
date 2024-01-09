// https://www.acmicpc.net/problem/7569

import java.util.*

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val m = token.nextToken().toInt()
val n = token.nextToken().toInt()
val h = token.nextToken().toInt()
val queue: Queue<Position> = LinkedList()
val box = Array(h) { z ->
	Array(n) { y ->
		token = StringTokenizer(reader.readLine())
		IntArray(m) { x ->
			val tomato = token.nextToken().toInt()
			if (tomato == 1) queue.offer(Position(x, y, z))
			tomato
		}
	}
}
val dx = arrayOf(-1, 1, 0, 0, 0, 0)
val dy = arrayOf(0, 0, -1, 1, 0, 0)
val dz = arrayOf(0, 0, 0, 0, -1, 1)

fun isOutOfBox(x: Int, y: Int, z: Int) =
	x < 0 || y < 0 || z < 0 || m <= x || n <= y || h <= z

fun main() {
	var days = -1

	while (queue.isNotEmpty()) {
		++days
		repeat(queue.size) {
			val pos = queue.poll()
			for (i in 0 until 6) {
				val x = pos.x + dx[i]
				val y = pos.y + dy[i]
				val z = pos.z + dz[i]

				if (isOutOfBox(x, y, z) || box[z][y][x] != 0) continue
				box[z][y][x] = 1
				queue.offer(Position(x, y, z))
			}
		}
	}

	for (z in 0 until h) {
		for (y in 0 until n) {
			for (x in 0 until m) {
				if (box[z][y][x] == 0) {
					println(-1)
					return
				}
			}
		}
	}
	println(days)
}

data class Position(val x: Int, val y: Int, val z: Int)

main()
