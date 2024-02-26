// https://www.acmicpc.net/problem/1463

import java.util.*

val INF = 1_000_000

fun bfs(n: Int): Int {
	val q: Queue<Int> = LinkedList()
	val visit = BooleanArray(INF + 1)
	var count = 0

	q.offer(1)
	visit[1] = true

	while (q.isNotEmpty()) {
		++count
		repeat(q.size) {
			val x = q.poll()

			if (x * 3 == n || x * 2 == n || x + 1 == n) {
				return count
			}

			if (x * 3 <= n && visit[x * 3] == false) {
				q.offer(x * 3)
				visit[x * 3] = true
			}
			if (x * 2 <= n && visit[x * 2] == false) {
				q.offer(x * 2)
				visit[x * 2] = true
			}
			if (x + 1 <= n && visit[x + 1] == false) {
				q.offer(x + 1)
				visit[x + 1] = true
			}
		}
	}
	return 0
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	if (n == 1) {
		println(0)
	} else {
		println(bfs(n))
	}
}

main()
