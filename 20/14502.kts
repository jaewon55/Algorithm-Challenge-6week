// https://www.acmicpc.net/problem/14502

import java.util.*

val BLANK = 0
val WALL = 1
val VIRUS = 2

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val virusList = LinkedList<Pair<Int,Int>>()
val blankList = ArrayList<Pair<Int,Int>>()
val map = Array(n) { i ->
	token = StringTokenizer(reader.readLine())
	IntArray(m) { j ->
		val w = token.nextToken().toInt()

		when(w) {
			BLANK -> blankList.add(i to j)
			VIRUS -> virusList.add(i to j)
		}

		w
	} 
}
val copyMap = Array(n) { IntArray(m) }
var result = 0

fun mapCopy() {
	for (i in 0 until n) {
		for (j in 0 until m) {
			copyMap[i][j] = map[i][j]
		}
	}
}

fun bfs() {
	val queue: Queue<Pair<Int,Int>> = LinkedList(virusList)
	val dx = arrayOf(1, -1, 0, 0)
	val dy = arrayOf(0, 0, 1, -1)
	var count = blankList.size - 3

	while (queue.isNotEmpty()) {
		val p = queue.poll()

		for (i in 0 until 4) {
			val x = p.first + dx[i]
			val y = p.second + dy[i]

			if (x !in 0 until n || y !in 0 until m || copyMap[x][y] != BLANK) continue

			copyMap[x][y] = VIRUS
			queue.offer(x to y)
			--count
		}
	}
	result = maxOf(result, count)
}

fun main() {
	for (i in 0 until blankList.size) {
		for (j in i until blankList.size) {
			for (k in j until blankList.size) {
				mapCopy()

				copyMap[blankList[i].first][blankList[i].second] = WALL
				copyMap[blankList[j].first][blankList[j].second] = WALL
				copyMap[blankList[k].first][blankList[k].second] = WALL

				bfs()
			}
		}
	}
	println(result)
}

main()
