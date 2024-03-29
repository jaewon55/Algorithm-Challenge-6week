// https://www.acmicpc.net/problem/2164

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val deque = LinkedList<Int>()

	for (i in 1 .. n) {
		deque.offerLast(i)
	}

	while (1 < deque.size) {
		deque.pollFirst()
		deque.offerLast(deque.pollFirst())
	}

	println(deque.peek())
}

main()
