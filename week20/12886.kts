// https://www.acmicpc.net/problem/12886

import java.util.*

fun bfs(sum: Int, ab: Pair<Int, Int>): Int {
	val q: Queue<Pair<Int,Int>> = LinkedList()
	val v = Array(1001) { BooleanArray(1001) }

	if (ab.first == ab.second && ab.first == sum / 3) return 1

	q.offer(ab)
	v[ab.first][ab.second] = true

	while (q.isNotEmpty()) {
		val (a, b) = q.poll()
		val abc = intArrayOf(a, b, sum - a - b)

		for (i in 0 until 3) {
			for (j in 0 until 3) {
				if (abc[i] < abc[j]) {
					val n1 = abc[i] * 2
					val n2 = abc[j] - abc[i]

					if (n1 == n2 && n1 == sum / 3) return 1
					if (v[n1][n2]) continue

					q.offer(n1 to n2)
					v[n1][n2] = true
				}
			}
		}
	}

	return 0
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val a = token.nextToken().toInt()
	val b = token.nextToken().toInt()
	val c = token.nextToken().toInt()
	val sum = a + b + c

	if (sum % 3 != 0) {
		println(0)
	} else {
		println(bfs(sum, a to b))
	}
}

main()
