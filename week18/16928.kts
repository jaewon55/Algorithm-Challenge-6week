// https://www.acmicpc.net/problem/16928

import java.util.*

fun bfs(ladders: IntArray): Int {
	val visit = BooleanArray(101)
	val q: Queue<Int> = LinkedList()
	var count = 0

	q.offer(1)
	visit[1] = true

	while (q.isNotEmpty()) {
		++count
		repeat(q.size) {
			val x = q.poll()

			for (i in 1 .. 6) {
				if (x + i == 100) return count

				if (100 < x + i || visit[x + i] || visit[ladders[x + i]]) continue

				q.offer(ladders[x + i])
				visit[x + i] = true
				visit[ladders[x + i]] = true
			}
		}
	}
	return 0
}

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val ladders = IntArray(101) { it }

	repeat(n + m) {
		token = StringTokenizer(reader.readLine())
		val x = token.nextToken().toInt()
		val y = token.nextToken().toInt()
		ladders[x] = y
	}
	println(bfs(ladders))
}

main()
