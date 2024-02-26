// https://www.acmicpc.net/problem/10819

import java.util.*

fun calculate(arr: IntArray): Int {
	var result = 0

	for(i in 0 until arr.size - 1) {
		result += Math.abs(arr[i] - arr[i + 1])
	}
	return result
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val arr = IntArray(n) {
		token.nextToken().toInt()
	}
	val permutation = IntArray(n)
	val visit = Array(n) { false }
	var result = 0

	fun recur(depth: Int) {
		if (depth == n) {
			val compare = calculate(permutation)
			if (result < compare) result = compare
			return
		}

		for (i in 0 until n) {
			if (visit[i]) continue
			visit[i] = true
			permutation[depth] = arr[i]
			recur(depth + 1)
			visit[i] = false
		}
	}
	recur(0)
	println(result)
}

main()
