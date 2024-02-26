// https://www.acmicpc.net/problem/1874

import java.util.*
import java.lang.StringBuilder

val PUSH = "+"
val POP = "-"

val reader = System.`in`.bufferedReader() 
val sb = StringBuilder()
val n = reader.readLine().toInt()
val arr = IntArray(n) { reader.readLine().toInt() }
val stack = LinkedList<Int>()
var pushNumber = 1
var popCount = 0
val popNumber: Int
		get() = arr[popCount]

fun push(): Boolean {
	if (n < pushNumber) return false
	stack.push(pushNumber++)
	sb.append("$PUSH\n")
	return true
}

fun pop(): Boolean {
	if (stack.isEmpty() || stack.peek() != popNumber) return false
	stack.pop()
	sb.append("$POP\n")
	++popCount
	return true
}

fun main() {
	while (popCount < n) {
		if (stack.isEmpty() || stack.peek() != popNumber) {
			while(pushNumber <= popNumber) {
				if (!push()) return println("NO") 
			}
		}
		if (!pop()) return println("NO")
	}
	println(sb)
}

main()
