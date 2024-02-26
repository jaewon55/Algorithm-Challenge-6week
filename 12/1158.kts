// https://www.acmicpc.net/problem/1158

import java.util.*

val reader = System.`in`.bufferedReader()
val sb = java.lang.StringBuilder()
val token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val k = token.nextToken().toInt()
val queue: Queue<Int> = LinkedList()

fun main() {
	for (i in 1 .. n) {
		queue.offer(i)
	}
	sb.append("<")
	repeat (n) {
		repeat(k - 1) {
			queue.offer(queue.poll())
		}
		sb.append("${queue.poll()}")
		if (queue.isNotEmpty()) sb.append(", ")
	}
	sb.append(">")
	println(sb)
}

main()
