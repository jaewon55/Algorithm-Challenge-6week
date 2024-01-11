// https://www.acmicpc.net/problem/4179

import java.util.*

val WALL = 0
val SPACE = 1
val FIRE = 2

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val r = token.nextToken().toInt()
val c = token.nextToken().toInt()
val maze = Array(r) { IntArray(c) }
val visit = Array(r) { BooleanArray(c) }
val fireQueue: Queue<Position> = LinkedList()
val manQueue: Queue<Position> = LinkedList()

fun isOutOfMaze(x: Int, y: Int) = y !in 0 until r || x !in 0 until c
fun isEdge(x: Int, y: Int) = y == 0 || x == 0 || y + 1 == r || x + 1 == c

fun bfs(): Int {
	val dx = arrayOf(-1, 1, 0, 0)
	val dy = arrayOf(0, 0, -1, 1)
	var minute = 1

	while(manQueue.isNotEmpty()) {
		++minute
		repeat(fireQueue.size) {
			val pos = fireQueue.poll()
			for (i in 0 until 4) {
				val x = pos.x + dx[i]
				val y = pos.y + dy[i]

				if (isOutOfMaze(x, y) || maze[y][x] != SPACE) continue

				maze[y][x] = FIRE
				fireQueue.offer(Position(x, y))
			}
		}
		repeat(manQueue.size) {
			val pos = manQueue.poll()
			for (i in 0 until 4) {
				val x = pos.x + dx[i]
				val y = pos.y + dy[i]

				if (isOutOfMaze(x, y) || maze[y][x] != SPACE || visit[y][x]) continue

				if (isEdge(x, y)) return minute
				manQueue.offer(Position(x, y))
				visit[y][x] = true
			}
		}
	}
	return -1
}

fun main() {
	for (y in 0 until r) {
		val line = reader.readLine()
		for (x in 0 until c) {
			when(line[x]) {
				'#' -> maze[y][x] = WALL
				'.' -> maze[y][x] = SPACE
				'J' -> {
					maze[y][x] = SPACE
					visit[y][x] = true
					manQueue.offer(Position(x, y))
				}
				'F' -> {
					maze[y][x] = FIRE
					fireQueue.offer(Position(x, y))
				}
			}
		}
	}

	val firstPosition = manQueue.peek()
	if (isEdge(firstPosition.x, firstPosition.y)) {
		println(1)
	} else {
		bfs().let{
			if (it < 0) {
				println("IMPOSSIBLE")
			} else {
				println(it)
			}
		}
	}
}

data class Position(val x: Int, val y: Int)

main()
