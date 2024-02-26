// https://www.acmicpc.net/problem/13913

import java.util.*

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val k = token.nextToken().toInt()
val visit = BooleanArray(100_001)
val prevPositions = IntArray(100_001)

fun isValid(x: Int) = x in 0..100_000 && !visit[x]

fun bfs(): Int {
	val queue: Queue<Int> = LinkedList()
	var count = 0

	queue.offer(n)
	visit[k] = true

	while (queue.isNotEmpty()) {
		++count
		repeat(queue.size) {
			val x = queue.poll()

			if (x + 1 == k || x - 1 == k || x * 2 == k) {
				prevPositions[k] = x
				return count
			}
			if (isValid(x + 1)) {
				queue.offer(x + 1)
				visit[x + 1] = true
				prevPositions[x + 1] = x
			}
			if (isValid(x - 1)) {
				queue.offer(x - 1)
				visit[x - 1] = true
				prevPositions[x - 1] = x
			}
			if (isValid(x * 2)) {
				queue.offer(x * 2)
				visit[x * 2] = true
				prevPositions[x * 2] = x
			}
		}
	}
	return 0
}

fun main() {
	if (n == k) {
		writer.write("0\n$n")
	} else {
		val second = bfs()
		val stack = LinkedList<Int>()
		var position = k

		while (true) {
			stack.push(position)
			if (position == n) break
			position = prevPositions[position]
		}

		writer.write("$second\n")
		while (stack.isNotEmpty()) {
			writer.write("${stack.pop()} ")
		}
		writer.write("\n")
	}
	writer.flush()
}

main()
