// https://www.acmicpc.net/problem/1406

import java.util.*

class Editor(s: String) {
	val left = LinkedList<Char>()
	val right = LinkedList<Char>()

	init {
		s.forEach { left.add(it) }
	}

	fun cmdL() {
		if (left.isNotEmpty()) {
			right.offerFirst(left.pollLast())
		}
	}

	fun cmdD() {
		if (right.isNotEmpty()) {
			left.offerLast(right.pollFirst())
		}
	}

	fun cmdB() {
		if (left.isNotEmpty()) {
			left.pollLast()
		}
	}

	fun cmdP(c: Char) {
		left.offerLast(c)
	}

	fun print() {
		println(left.joinToString("") + right.joinToString(""))
	}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val editor = Editor(reader.readLine())
	val m = reader.readLine().toInt()

	repeat(m) {
		val line = reader.readLine()
		when(line[0]) {
			'L' -> editor.cmdL()
			'D' -> editor.cmdD()
			'B' -> editor.cmdB()
			else -> editor.cmdP(line[2])
		}
	}
	while(editor.left.isNotEmpty()) {
		writer.write(editor.left.pollFirst().toInt())
	}
	while(editor.right.isNotEmpty()) {
		writer.write(editor.right.pollFirst().toInt())
	}
	writer.write("\n")
	writer.close()
}

main()
