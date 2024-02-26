// https://www.acmicpc.net/problem/16937

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val h = token.nextToken().toInt()
	val w = token.nextToken().toInt()
	val n = reader.readLine().toInt()
	val sticker = Array(n) {
		token = StringTokenizer(reader.readLine())
		IntArray(2) { token.nextToken().toInt() }
	}
	var result = 0

	fun isValid(s1: IntArray, s2: IntArray): Boolean {
		for (i in 0 until 2) {
			for (j in 0 until 2) {
				if (s1[i] + s2[j] <= w && maxOf(s1[(i + 1) % 2], s2[(j + 1) % 2]) <= h) return true
				if (s1[i] + s2[j] <= h && maxOf(s1[(i + 1) % 2], s2[(j + 1) % 2]) <= w) return true
			}
		}
		return false
	}

	for (i in 0 until n) {
		for (j in i until n) {
			if (isValid(sticker[i], sticker[j])) {
				result = maxOf(result, sticker[i][0] * sticker[i][1] + sticker[j][0] * sticker[j][1])
			}
		}
	}

	println(result)
}

main()
