// https://www.acmicpc.net/problem/1476

import java.util.*

val MAX_OF_E = 15
val MAX_OF_S = 28
val MAX_OF_M = 19

class OtherCalendar(var year: Int) {
	val e: Int
		get() = (year % MAX_OF_E).let { if (it == 0) MAX_OF_E else it}
	val s: Int
		get() = (year % MAX_OF_S).let { if (it == 0) MAX_OF_S else it}
	val m: Int
		get() = (year % MAX_OF_M).let { if (it == 0) MAX_OF_M else it}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val e = token.nextToken().toInt()
	val s = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	var otherCalendar = OtherCalendar(s)
	
	while (e != otherCalendar.e || s != otherCalendar.s || m != otherCalendar.m) {
		otherCalendar.year += 28
	}
	println(otherCalendar.year)
}

main()
