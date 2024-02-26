// https://www.acmicpc.net/problem/12851

import java.util.*

fun bfs(n : Int, k: Int, position: IntArray): Int {
	if (n == k) {
		position[k] = 1
		return 1
	}
	val q: Queue<Int> = LinkedList()
	var seconds = 1
	var count = 0

	position[k] = Int.MAX_VALUE
	q.offer(n)
	position[n] = 1
	while (q.isNotEmpty()) {
		++seconds
		if (position[k] < seconds) break
		repeat(q.size) {
			val top = q.poll()

			for (i in 0 until 3) {
				val x = when (i) {
					0 -> top + 1
					1 -> top - 1
					else -> top * 2
				}

				if (x !in 0..100_000) continue
				if (x == k) {
					position[x] = seconds
					++count
				}
				if (position[x] == 0 || position[x] == seconds) {
					q.offer(x)
					position[x] = seconds
				}
			}
		}
	}
	return count
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val k = token.nextToken().toInt()
	val position = IntArray(100_001)
	val count = bfs(n, k, position)

	println("${position[k] - 1}\n$count")
}

main()
