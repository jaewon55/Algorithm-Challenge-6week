// https://www.acmicpc.net/problem/17199

import java.util.*

val reader = System.`in`.bufferedReader()
val n = reader.readLine().toInt()
val graph = Array(n + 1) { LinkedList<Int>() }
val visit = BooleanArray(n + 1)

fun dfs(node: Int) {
	visit[node] = true
	for (i in 0 until graph[node].size) {
		val next = graph[node][i]
		if (!visit[next]) dfs(next)
	}
}

fun check(): Boolean {
	var ret = true
	for (i in 1 .. n) {
		if (!visit[i]) ret = false
		visit[i] = false
	}
	return ret
}

fun main() {
	repeat(n - 1) {
		val token = StringTokenizer(reader.readLine())
		val a = token.nextToken().toInt()
		val b = token.nextToken().toInt()
		graph[b].add(a)
	}

	for (i in 1 .. n) {
		dfs(i)
		if (check()) {
			println(i)
			return
		}
	}
	println(-1)
}

main()
