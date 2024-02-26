// https://www.acmicpc.net/problem/1149

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val arr = Array(n) {
		val token = StringTokenizer(reader.readLine())
		IntArray(3) { token.nextToken().toInt() }
	}

	for (i in 1 until n) {
		arr[i][0] += minOf(arr[i - 1][1], arr[i - 1][2])
		arr[i][1] += minOf(arr[i - 1][0], arr[i - 1][2])
		arr[i][2] += minOf(arr[i - 1][1], arr[i - 1][0])
	}
	println(arr[n - 1].min())
}

main()
