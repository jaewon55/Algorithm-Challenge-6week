// https://www.acmicpc.net/problem/1107

import java.util.*

val Int.length : Int
	get() = this.toString().length

fun availableChannel(n: Int, broken: Array<Int>): Boolean {
	val numString = n.toString()
	for (c in numString) {
		if (c - '0' in broken) return false
	}
	return true
}

fun case1(n: Int) = Math.abs(n - 100)

fun case2(n: Int, broken: Array<Int>): Int {
	for (channel in n downTo 0) {
		if (availableChannel(channel, broken)) {
			return n - channel + channel.length
		}
	}
	return Int.MAX_VALUE
}

fun case3(n: Int, broken: Array<Int>): Int {
	for (channel in n..999_999) {
		if (availableChannel(channel, broken)) {
			return channel - n + channel.length
		}
	}
	return Int.MAX_VALUE
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val m = reader.readLine().toInt()
	val broken = if (m == 0 ) {
		emptyArray()
	} else {
		val token = StringTokenizer(reader.readLine())
		Array(m) { token.nextToken().toInt() }
	}
	println(minOf(case1(n), case2(n, broken), case3(n, broken)))
}

main()
