// https://www.acmicpc.net/problem/8061

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val dist = Array(n) { IntArray(m) { Int.MAX_VALUE } }
	val q: Queue<Pair<Int,Int>> = LinkedList()
	val dx = arrayOf(1, -1, 0, 0)
	val dy = arrayOf(0, 0, 1, -1)

	for (i in 0 until n) {
		val line = reader.readLine()
		for (j in 0 until m) {
			if (line[j] == '1') {
				q.offer(i to j)
				dist[i][j] = 0
			}
		}
	}

	while (q.isNotEmpty()) {
		val pos = q.poll()
		val curDist = dist[pos.first][pos.second]
		for (i in 0 until 4) {
			val x = pos.first + dx[i]
			val y = pos.second + dy[i]

			if (x !in 0 until n || y !in 0 until m || dist[x][y] <= curDist + 1) continue
			q.offer(x to y)
			dist[x][y] = curDist + 1
		}
	}

	for (i in 0 until n) {
		for (j in 0 until m) {
			writer.write("${dist[i][j]} ")
		}
		writer.write("\n")
	}
	writer.close()
}

main()
