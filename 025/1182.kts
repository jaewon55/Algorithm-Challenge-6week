// https://www.acmicpc.net/problem/1182

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val s = token.nextToken().toInt()
	val numbers = IntArray(n)
	var result = 0

	token = StringTokenizer(reader.readLine())
	for (i in 0 until n) {
		numbers[i] = token.nextToken().toInt()
	}

	fun recurv(depth: Int, start: Int, sum: Int) {
		if (depth == n) return

		for (i in start until n) {
			if (sum + numbers[i] == s) ++result
			recurv(depth + 1, i + 1, sum + numbers[i])
		}
	}

	recurv(0, 0, 0)

	println(result)
}

main()
