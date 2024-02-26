// https://www.acmicpc.net/problem/1697

import java.util.*

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val k = token.nextToken().toInt()
val visit = BooleanArray(100_001)

fun valid(x: Int) = x in 0..100_000 && !visit[x]

fun bfs(): Int {
	val q: Queue<Int> = LinkedList()
	var count = 0

	q.offer(n)
	visit[n] = true

	while(q.isNotEmpty()) {
		++count
		repeat(q.size) {
			val p = q.poll()
			if (p + 1 == k || p - 1 == k || p * 2 == k)
				return count
			if (valid(p + 1)) {
				q.offer(p + 1)
				visit[p + 1] = true
			}
			if (valid(p - 1)) {
				q.offer(p - 1)
				visit[p - 1] = true
			}
			if (valid(p * 2)) {
				q.offer(p * 2)
				visit[p * 2] = true
			}
		}
	}
	return 0
}

fun main() {
	if (n == k) println(0) else println(bfs())
}

main()
