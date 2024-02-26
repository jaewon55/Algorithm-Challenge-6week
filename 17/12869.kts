// https://www.acmicpc.net/problem/12869

import java.util.*

fun bfs(scv: IntArray): Int {
	val q: Queue<Triple<Int,Int,Int>> = LinkedList()
	val visit = Array(61) { Array(61) { BooleanArray(61) } }
	val cases = arrayOf (
		arrayOf(9, 3, 1),
		arrayOf(9, 1, 3),
		arrayOf(3, 9, 1),
		arrayOf(3, 1, 9),
		arrayOf(1, 9, 3),
		arrayOf(1, 3, 9)
	)
	var result = 0

	q.offer(Triple(scv[0], scv[1], scv[2]))
	visit[scv[0]][scv[1]][scv[2]]

	while (q.isNotEmpty()) {
		++result
		repeat(q.size) {
			val xyz = q.poll()

			for (case in cases) {
				val x = if (xyz.first < case[0]) 0 else xyz.first - case[0]
				val y = if (xyz.second < case[1]) 0 else xyz.second - case[1]
				val z = if (xyz.third < case[2]) 0 else xyz.third - case[2]

				if (x == 0 && y == 0 && z == 0) return result
				if (visit[x][y][z]) continue

				q.offer(Triple(x, y, z))
				visit[x][y][z] = true
			}
		}
	}
	return 0
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val scv = IntArray(3)

	for (i in 0 until n) {
		scv[i] = token.nextToken().toInt()
	}

	println(bfs(scv))
}

main()
