// https://www.acmicpc.net/problem/18428

import java.util.*

val TEACHER = 'T'
val STUDENT = 'S'
val BLANK = 'X'
val OBSTACLE = 'O'

val reader = System.`in`.bufferedReader()
val n = reader.readLine().toInt()
val students = LinkedList<Pair<Int,Int>>()
val map = Array(n) { x ->
	val token = StringTokenizer(reader.readLine())
	CharArray(n) { y ->
		val c = token.nextToken().first()
		if (c == STUDENT) students.add(x to y)
		c
	}
}

fun check(): Boolean {
	for (p in students) {
		val x = p.first
		val y = p.second
		for (i in x - 1 downTo 0) {
			if (map[i][y] == OBSTACLE) break
			if (map[i][y] == TEACHER) return false
		}
		for (i in x + 1 until n) {
			if (map[i][y] == OBSTACLE) break
			if (map[i][y] == TEACHER) return false
		}
		for (i in y - 1 downTo 0) {
			if (map[x][i] == OBSTACLE) break
			if (map[x][i] == TEACHER) return false
		}
		for (i in y + 1 until n) {
			if (map[x][i] == OBSTACLE) break
			if (map[x][i] == TEACHER) return false
		}
	}
	return true
}

fun bt(depth: Int, start: Int) {
	if (depth == 3) {
		if (check()) {
			println("YES")
			kotlin.system.exitProcess(0)
		}
		return
	}

	for (i in start until n * n) {
		val x = i / n
		val y = i % n
		if (map[x][y] != BLANK) continue
		map[x][y] = OBSTACLE
		bt(depth + 1, i + 1)
		map[x][y] = BLANK
	}
}

fun main() {
	bt(0, 0)
	println("NO")
}

main()
