// https://www.acmicpc.net/problem/2798

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val cards = IntArray(n)
	var result = 0

	token = StringTokenizer(reader.readLine())
	for (i in 0 until n) {
		cards[i] = token.nextToken().toInt()
	}
	cards.sort()
	fun recurv(depth: Int, start: Int, sum: Int) {
		if (depth == 3) {
			result = maxOf(result, sum)
			return
		}

		for (i in start until n) {
			if (m < sum + cards[i]) break
			recurv(depth + 1, i + 1, sum + cards[i])
		}
	}

	recurv(0, 0, 0)
	println(result)
}

main()
