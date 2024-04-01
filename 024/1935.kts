// https://www.acmicpc.net/problem/1935

import java.util.*

fun calculate(r: Double, l: Double, oper: (Double, Double) -> Double) = oper(l, r)

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val postfix = reader.readLine()
	val numbers = IntArray(n) { reader.readLine().toInt() }
	val stack = LinkedList<Double>()

	for (c in postfix) {
		val pushNum = when (c) {
			'+' -> calculate(stack.pop(), stack.pop(), { l, r -> l + r })
			'-' -> calculate(stack.pop(), stack.pop(), { l, r -> l - r })
			'*' -> calculate(stack.pop(), stack.pop(), { l, r -> l * r })
			'/' -> calculate(stack.pop(), stack.pop(), { l, r -> l / r })
			else -> numbers[c.toInt() - 'A'.toInt()].toDouble()
		}
		stack.push(pushNum)
	}
	println("%.2f".format(stack.pop()))
}

main()
