// https://www.acmicpc.net/problem/16946

import java.util.*

val WALL = -1
val SPACE = -2

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val map = Array(n) {
	val line = reader.readLine()
	IntArray(m) { if (line[it] == '1') WALL else SPACE }
}
val countOfArea = IntArray(n * m / 2 + 1)
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun searchArea(sx: Int, sy: Int, areaNumber: Int): Int {
	val q: Queue<Pair<Int,Int>> = LinkedList()
	var count = 0

	q.offer(sx to sy)
	map[sx][sy] = areaNumber
	while (q.isNotEmpty()) {
		++count
		val p = q.poll()
		for (i in 0 until 4) {
			val x = p.first + dx[i]
			val y = p.second + dy[i]

			if (x !in 0 until n || y !in 0 until m || map[x][y] != SPACE) continue

			q.offer(x to y)
			map[x][y] = areaNumber
		}
	}
	return count
}

fun getCountOfMove(x: Int, y: Int): Int {
	val visit = mutableListOf<Int>()
	var count = 1

	for (i in 0 until 4) {
		val nx = x + dx[i]
		val ny = y + dy[i]
		val area: Int

		if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == WALL) continue
		area = map[nx][ny]
		if (area in visit) continue
		count += countOfArea[area]
		visit.add(area)
	}
	return count
}

fun main() {
	var areaNumber = 0

	for (x in 0 until n) {
		for (y in 0 until m) {
			if (map[x][y] == SPACE) {
				countOfArea[areaNumber] = searchArea(x, y, areaNumber)
				++areaNumber
			}
		}
	}
	for (x in 0 until n) {
		for (y in 0 until m) {
			if (map[x][y] == WALL) {
				writer.write("${getCountOfMove(x, y) % 10}")
			} else {
				writer.write("0")
			}
		}
		writer.write("\n")
	}
	writer.close()
}

main()
