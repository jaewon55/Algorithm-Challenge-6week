// https://www.acmicpc.net/problem/13913

import java.util.*

fun bfs(n: Int, k: Int, arr: IntArray): Int {
	val q: Queue<Int> = LinkedList()
	val visit = BooleanArray(100_001)
	var sec: Int = 1

	q.offer(n)
	visit[n] = true
	while(q.isNotEmpty()) {
		repeat(q.size) {
			val x = q.poll()

			if (x - 1 in 0..100_000 && visit[x - 1] == false) {
				q.offer(x - 1)
				arr[x - 1] = x
				visit[x - 1] = true
			}

			if (x + 1 in 0..100_000 && visit[x + 1] == false) {
				q.offer(x + 1)
				arr[x + 1] = x
				visit[x + 1] = true
			}

			if (x * 2 in 0..100_000 && visit[x * 2] == false) {
				q.offer(x * 2)
				arr[x * 2] = x
				visit[x * 2] = true
			}

			if (x - 1 == k || x + 1 == k || x * 2 == k) return sec
		}
		++sec
	}
	return 0
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val k = token.nextToken().toInt()
	val arr = IntArray(100_001)

	if (n == k) {
		writer.write("0\n$n")
	} else {
		val stack = LinkedList<Int>()

		writer.write("${bfs(n, k, arr)}\n")

		stack.push(k)
		while (stack.peek() != n) {
			stack.push(arr[stack.peek()])
		}
		while (stack.isNotEmpty()) {
			writer.write("${stack.pop()} ")
		}
		writer.write("\n")
	}
	writer.flush()
}

main()
