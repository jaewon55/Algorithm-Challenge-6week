// https://www.acmicpc.net/problem/10021

import java.util.*

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val c = token.nextToken().toInt()
val root = IntArray(n) { it }

fun find(x: Int): Int {
	if (root[x] == x) return x
	root[x] = find(root[x])
	return root[x]
}

fun union(a: Int, b: Int): Boolean {
	val rootOfA = root[a]
	val rootOfB = root[b]

	if (rootOfA == rootOfB) return false

	if (rootOfA < rootOfB) {
		root[rootOfB] = rootOfA
	} else {
		root[rootOfA] = rootOfB
	}
	return true
}

fun main() {
	val x = IntArray(n)
	val y = IntArray(n)
	val pq = PriorityQueue<Edge>(compareBy{ it.weight })
	var count = 0
	var result = 0

	for (i in 0 until n) {
		token = StringTokenizer(reader.readLine())
		x[i] = token.nextToken().toInt()
		y[i] = token.nextToken().toInt()
	}
	
	for (i in 0 until n) {
		for (j in i + 1 until n) {
			val dx = x[i] - x[j]
			val dy = y[i] - y[j]
			val weight = dx * dx + dy * dy

			if (weight < c) continue
			pq.offer(Edge(i, j, dx * dx + dy * dy))
		}
	}

	while (count < n - 1 && pq.isNotEmpty()) {
		val edge = pq.poll()

		if (!union(edge.a, edge.b)) continue
		result += edge.weight
		++count
	}

	if (count < n - 1) {
		println(-1)
	} else {
		println(result)
	}
}

data class Edge(val a: Int, val b: Int, val weight: Int)

main()
