// https://www.acmicpc.net/problem/17413

import java.util.*
import java.io.*

fun LinkedList<Char>.popOutStack(writer: BufferedWriter) {
	while (this.isNotEmpty()) {
		writer.write(this.pop().toInt())
	}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val line = reader.readLine()
	val stack = LinkedList<Char>()
	var isTag = false

	for (c in line) {
		if (isTag) {
			writer.write(c.toInt())
			if (c == '>') isTag = false
		} else if (c == '<' || c == ' ') {
			stack.popOutStack(writer)
			writer.write(c.toInt())
			isTag = c == '<'
		} else {
			stack.push(c)
		}
	}
	stack.popOutStack(writer)
	writer.write("\n")
	writer.close()
}

main()
