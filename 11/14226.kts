// https://www.acmicpc.net/problem/14226

import java.util.*

val reader = System.`in`.bufferedReader()
val s = reader.readLine().toInt()
val dp = Array(1001) {
	IntArray(1001)
}

fun isValid(col: Int, row: Int) = col in 2 .. 1000 && dp[col][row] == 0

fun bfs(): Int {
	val queue: Queue<Pair<Int, Int>> = LinkedList()
	var second = 2

	dp[2][1] = 2
	queue.offer(2 to 1)

	while (queue.isNotEmpty()) {
		++second
		repeat(queue.size) {
			val pair = queue.poll()
			val screen = pair.first
			val clip = pair.second

			if (screen + clip == s || screen - 1 == s) {
				return second
			}
			if (isValid(screen + clip, clip)) {
				dp[screen + clip][clip] = second
				queue.offer(screen + clip to clip)
			}
			if (isValid(screen - 1, clip)) {
				dp[screen - 1][clip] = second
				queue.offer(screen - 1 to clip)
			}
			if (isValid(screen, screen)) {
				dp[screen][screen] = second
				queue.offer(screen to screen)
			}
		}
	}
	return 0
}

fun main() {
	if (s == 2) println(2) else println(bfs())
}

main()
