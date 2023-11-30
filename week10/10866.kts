// https://www.acmicpc.net/problem/10866

import java.util.*

val PUSH_FRONT = "push_front"
val PUSH_BACK = "push_back"
val POP_FRONT = "pop_front"
val POP_BACK = "pop_back"
val SIZE = "size"
val EMPTY = "empty"
val FRONT = "front"
val BACK = "back"

class Deque {
	private val list = ArrayList<Int>()

	fun pushFront(x: Int) {
		list.add(0, x)
	}

	fun pushBack(x: Int) {
		list.add(x)
	}

	fun popFront() = if (list.size == 0) -1 else list.removeAt(0)

	fun popBack() = if (list.size == 0) -1 else list.removeAt(list.lastIndex)

	fun size() = list.size

	fun empty() = if (list.isEmpty()) 1 else 0

	fun front() = if (list.isEmpty()) -1 else list[0]

	fun back() = if (list.isEmpty()) -1 else list[list.lastIndex]
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val deque = Deque()

	for (i in 0 until n) {
		val token = StringTokenizer(reader.readLine())
		val command = token.nextToken()
		when(command) {
			PUSH_FRONT -> deque.pushFront(token.nextToken().toInt())
			PUSH_BACK -> deque.pushBack(token.nextToken().toInt())
			POP_FRONT -> writer.write("${deque.popFront()}\n")
			POP_BACK -> writer.write("${deque.popBack()}\n")
			SIZE -> writer.write("${deque.size()}\n")
			EMPTY -> writer.write("${deque.empty()}\n")
			FRONT -> writer.write("${deque.front()}\n")
			BACK -> writer.write("${deque.back()}\n")
		}
	}
	writer.flush()
}

main()
