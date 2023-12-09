// https://www.acmicpc.net/problem/13549

import java.util.*

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val k = token.nextToken().toInt()
val visit = IntArray(100_001)

fun bfs(): Int {
	val deque = LinkedList<Int>()

	deque.offerFirst(n)
	visit[n] = 1

	while(deque.isNotEmpty()) {
		val x = deque.pollFirst()

		if (x == k) return visit[x] - 1

		if (x * 2 < 100_001 && visit[x * 2] == 0) {
			deque.offerFirst(x * 2)
			visit[x * 2] = visit[x]
		}

		if (0 <= x - 1 && visit[x - 1] == 0) {
			deque.offerLast(x - 1)
			visit[x - 1] = visit[x] + 1
		}

		if (x + 1 < 100_001 && visit[x + 1] == 0) {
			deque.offerLast(x + 1)
			visit[x + 1] = visit[x] + 1
		}
	}
	return 0
}

fun main() {
	println(bfs())
}

main()
