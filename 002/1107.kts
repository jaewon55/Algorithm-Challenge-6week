// https://www.acmicpc.net/problem/1107

import java.util.StringTokenizer

var brokenBtn = IntArray(0)
var availableBtn = IntArray(10){it}

fun case1(n: Int): Int {
	val str = n.toString()
	for (c in str) {
		val num = c - '0'
		if (num in brokenBtn) return Int.MAX_VALUE
	}
	return str.length
}

fun case2(n: Int): Int {
	if (availableBtn.isEmpty()) return Int.MAX_VALUE
	val min = availableBtn.find{ it > 0 }
	var maxValue = 0
	for (m in 0 until n.toString().length + 1) {
		maxValue *= 10
		maxValue += min
	}
	for (num in n..maxValue) {
		val str = num.toString()
		var valid = false
		for (i in 0 until str.length) {
			if (str[i] - '0' !in availableBtn) break
			if (i == str.length - 1) valid = true
		}
		if (valid) return str.length + Math.abs(num - n)
	}
	return Int.MAX_VALUE
}

fun case3(n: Int): Int {
	if (availableBtn.isEmpty()) return Int.MAX_VALUE
	for (num in n downTo 0) {
		val str = num.toString()
		var valid = false
		for (i in 0 until str.length) {
			if (str[i] - '0' !in availableBtn) break
			if (i == str.length - 1) valid = true
		}
		if (valid) return str.length + Math.abs(n - num)
	}
	return Int.MAX_VALUE
}

fun case4(n: Int): Int {
	return Math.abs(n - 100)
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val m = reader.readLine().toInt()
	if (m > 0) {
		val token = StringTokenizer(reader.readLine())
		brokenBtn = IntArray(m)
		for(i in 0 until m) {
			brokenBtn[i] = token.nextToken().toInt()
		}
		brokenBtn.sorted()
		availableBtn = availableBtn.filter{ it !in brokenBtn }.toIntArray()
	}
	val ret = intArrayOf(case1(n), case2(n), case3(n), case4(n)).minOrNull()
	writer.write("$ret\n")
	writer.flush()
}

main()
