// https://www.acmicpc.net/problem/5014

import java.util.*

val reader = System.`in`.bufferedReader()
val token = StringTokenizer(reader.readLine())
val top = token.nextToken().toInt()
val start = token.nextToken().toInt()
val goal = token.nextToken().toInt()
val up = token.nextToken().toInt()
val down = token.nextToken().toInt()

fun bfs(): Int {
	val q: Queue<Int> = LinkedList()
	val visit = BooleanArray(top + 1)
	var count = 1

	q.offer(start)
	visit[start] = true

	while (q.isNotEmpty()) {
		repeat(q.size) {
			val p = q.poll()

			if (p + up == goal || p - down == goal) return count

			if (p + up <= top && !visit[p + up]) {
				q.offer(p + up)
				visit[p + up] = true
			}
			if (1 <= p - down && !visit[p - down]) {
				q.offer(p - down)
				visit[p - down] = true
			}
		}
		++count
	}
	return -1
}

fun main() {
	if (start == goal) {
		println(0)
		return
	}
	val count = bfs()
	if (count < 0) {
		println("use the stairs")
	} else {
		println(count)
	}
}

main()
