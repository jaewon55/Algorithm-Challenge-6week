// https://www.acmicpc.net/problem/1707

import java.util.*

fun bfs(s: Int, graph: Array<ArrayList<Int>>, color: IntArray): Boolean {
	val queue = ArrayList<Int>()
	queue.add(s)
	color[s] = 1

	while(!queue.isEmpty()) {
		val u = queue.removeAt(0)
		for (v in graph[u]) {
			when(color[v]) {
				color[u] -> return false
				0 -> {
					color[v] = -color[u]
					queue.add(v)
				}
			}
		}
	}
	return true
}


fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val k = reader.readLine().toInt()
	var token : StringTokenizer
	repeat(k) {
		token = StringTokenizer(reader.readLine())
		val v = token.nextToken().toInt()
		val e = token.nextToken().toInt()
		val graph = Array(v + 1) { ArrayList<Int>() }
		val color = IntArray(v + 1)
		var result = "YES"

		repeat (e) {
			token = StringTokenizer(reader.readLine())
			val a = token.nextToken().toInt()
			val b = token.nextToken().toInt()
			graph[a].add(b)
			graph[b].add(a)
		}

		for (i in 1 .. v) {
			if (color[i] != 0) continue
			if (!bfs(i, graph, color)) {
				result = "NO"
				break
			}
		}

		writer.write("$result\n")
	}
	writer.flush()
}

main()
