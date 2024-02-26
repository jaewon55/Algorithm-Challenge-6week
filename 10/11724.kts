// https://www.acmicpc.net/problem/11724

import java.util.*

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val arr = Array(n + 1) { ArrayList<Int>() }
val visit = BooleanArray(n + 1)

fun bfs(s: Int) {
	val queue = ArrayList<Int>()
	queue.add(s)
	visit[s] = true

	while(!queue.isEmpty()) {
		val v = queue.removeAt(0)
		for (u in arr[v]) {
			if (visit[u]) continue
			queue.add(u)
			visit[u] = true
		}
	}
}

fun main() {
	var result = 0
	for (i in 0 until m) {
		token = StringTokenizer(reader.readLine())
		val u = token.nextToken().toInt()
		val v = token.nextToken().toInt()
		arr[u].add(v)
		arr[v].add(u)
	}
	for (s in 1 .. n) {
		if (visit[s]) continue
		++result
		bfs(s)
	}
	println(result)
}

main()
