// https://www.acmicpc.net/problem/1260

import java.util.*

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val v = token.nextToken().toInt()
val graph = Array(n + 1) {
	BooleanArray(n + 1)
}
val visit = BooleanArray(n + 1)

fun dfs(x: Int) {
	visit[x] = true
	writer.write("$x ")
	for (i in 1 .. n) {
		if (visit[i] || !graph[x][i]) continue
		dfs(i)
	}
}

fun bfs(x: Int) {
	val queue = ArrayList<Int>()
	visit[x] = true
	queue.add(x)
	while (!queue.isEmpty()) {
		val num = queue.removeAt(0)
		writer.write("$num ")
		for (i in 1 .. n) {
			if (visit[i] || !graph[num][i]) continue
			visit[i] = true
			queue.add(i)
		}
	}
}

fun main() {
	for (i in 0 until m) {
		token = StringTokenizer(reader.readLine())
		val a = token.nextToken().toInt()
		val b = token.nextToken().toInt()
		graph[a][b] = true
		graph[b][a] = true
	}
	dfs(v)
	writer.write("\n")
	visit.fill(false)
	bfs(v)
	writer.write("\n")
	writer.flush()
}

main()
