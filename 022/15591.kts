// https://www.acmicpc.net/problem/15591

import java.util.*

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val q = token.nextToken().toInt()
val usado = Array(n + 1) { LinkedList<Pair<Int,Int>>() }

fun bfs(k: Int, v: Int): Int {
	val q: Queue<Int> = LinkedList()
	val visit = BooleanArray(n + 1)
	var count = 0

	q.offer(v)
	visit[v] = true

	while (q.isNotEmpty()) {
		val from = q.poll()

		for (pair in usado[from]) {
			val to = pair.first
			val dist = pair.second

			if (visit[to] || dist < k) continue

			q.offer(to)
			visit[to] = true
			++count
		}
	}
	return count
}

fun main() {
	repeat(n - 1) {
		token = StringTokenizer(reader.readLine())
		val from = token.nextToken().toInt()
		val to = token.nextToken().toInt()
		val dist = token.nextToken().toInt()

		usado[from].add(to to dist)
		usado[to].add(from to dist)
	}

	repeat(q) {
		token = StringTokenizer(reader.readLine())
		val k = token.nextToken().toInt()
		val v = token.nextToken().toInt()
		var count = bfs(k, v)
		writer.write("$count\n")
	}
	writer.close()
}

main()
