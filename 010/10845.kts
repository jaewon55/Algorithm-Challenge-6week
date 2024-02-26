// https://www.acmicpc.net/problem/10845

import java.util.*

val PUSH = "push"
val POP = "pop"
val SIZE = "size"
val EMPTY = "empty"
val FRONT = "front"
val BACK = "back"

class Queue {
	private val list = ArrayList<Int>()

	fun push(x: Int) {
		list.add(x)
	}

	fun pop() = if (list.size == 0) -1 else list.removeAt(0)

	fun size() = list.size

	fun empty() = if (list.size == 0) 1 else 0

	fun front() = if (list.size == 0) -1 else list[0]

	fun back() = if (list.size == 0) -1 else list[list.lastIndex]
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val queue = Queue()
	for (i in 0 until n) {
		val token = StringTokenizer(reader.readLine())
		val command = token.nextToken()
		when(command) {
			PUSH -> queue.push(token.nextToken().toInt())
			POP -> writer.write("${queue.pop()}\n")
			SIZE -> writer.write("${queue.size()}\n")
			EMPTY -> writer.write("${queue.empty()}\n")
			FRONT -> writer.write("${queue.front()}\n")
			else -> writer.write("${queue.back()}\n")
		}
	}
	writer.flush()
}

main()
