// https://www.acmicpc.net/problem/6064

import java.util.*

val M = 0
val N = 1
val X = 2
val Y = 3

fun findGCD(a: Int, b: Int): Int {
	var x = a
	var y = b
	while (y != 0) {
		val temp = y
		y = x % y
		x = temp
	}
	return x
}

fun findLCM(a: Int, b: Int) = (a * b) / findGCD(a, b)

fun findK(arr: IntArray): Int {
	val last = findLCM(arr[M], arr[N])

	for (k in arr[X]..last step arr[M]) {
		val y = (k % arr[N]).let{ if (it != 0) it else arr[N] }
		if (y == arr[Y]) return k
	}
	return -1
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val t = reader.readLine().toInt()
	val input = Array(t) {
		val token = StringTokenizer(reader.readLine())
		IntArray(4) { token.nextToken().toInt() }
	}
	for (arr in input) {
		println(findK(arr))
	}
}

main()
