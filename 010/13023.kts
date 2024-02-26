// https://www.acmicpc.net/problem/13023

import java.util.*

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val people = Array(n) { mutableListOf<Int>() }
val visit = Array(n) { false }

fun recur(depth: Int, idx: Int) {
	if (depth == 5) {
		println(1)
		kotlin.system.exitProcess(0)
	}

	for (i in people[idx]) {
		if (visit[i]) continue
		visit[i] = true
		recur(depth + 1, i)
		visit[i] = false
	}
}

fun main() {
	for (i in 0 until m) {
		token = StringTokenizer(reader.readLine())
		val a = token.nextToken().toInt()
		val b = token.nextToken().toInt()
		people[a].add(b)
		people[b].add(a)
	}
	for (i in 0 until n) {
		visit[i] = true
		recur(1, i)
		visit[i] = false
	}
	println(0)
}

main()
