// https://www.acmicpc.net/problem/9093

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	val stack = LinkedList<Char>()

	repeat(t) {
		val token = StringTokenizer(reader.readLine())
		var line = token.nextToken()

		for (c in line) {
			stack.push(c)
		}
		while (stack.isNotEmpty()) {
			writer.write("${stack.pop()}")
		}

		while (token.hasMoreTokens()) {
			line = token.nextToken()
			writer.write(" ")
			for (c in line) {
				stack.push(c)
			}
			while (stack.isNotEmpty()) {
				writer.write("${stack.pop()}")
			}
		}
		writer.write("\n")
	}
	writer.close()
}

main()
