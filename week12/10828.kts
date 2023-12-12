// https://www.acmicpc.net/problem/10828

import java.util.*

private val sb = java.lang.StringBuilder()

class Stack {
	private val stack = LinkedList<Int>()

	fun push(x: Int) {
		stack.push(x)
	}

	fun pop() {
		val n = if (stack.isEmpty()) -1 else stack.pop()
		sb.append("$n\n")
	}

	fun size() {
		sb.append("${stack.size}\n")
	}

	fun empty() {
		val n = if (stack.isEmpty()) 1 else 0
		sb.append("$n\n")
	}

	fun top() {
		val n = if (stack.isEmpty()) -1 else stack.peek()
		sb.append("$n\n")
	}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val stack = Stack()

	repeat(n) {
		val token = StringTokenizer(reader.readLine())
		val cmd = token.nextToken()
		when(cmd) {
			"push" -> stack.push(token.nextToken().toInt())
			"pop" -> stack.pop()
			"size" -> stack.size()
			"empty" -> stack.empty()
			"top" -> stack.top()
		}
	}
	print(sb)
}

main()
