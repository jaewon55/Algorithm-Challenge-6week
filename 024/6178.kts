// https://www.acmicpc.net/problem/6178

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val r = token.nextToken().toInt()
	val c = token.nextToken().toInt()
	val e = token.nextToken().toInt()
	val n = token.nextToken().toInt()
	val map = Array(r + 1) { IntArray(c + 1) }
	var total = 0

	for (i in 1 .. r) {
		token = StringTokenizer(reader.readLine())
		for (j in 1 .. c) {
			map[i][j] = token.nextToken().toInt()
		}
	}

	repeat(n) {
		token = StringTokenizer(reader.readLine())
		val rs = token.nextToken().toInt()
		val cs = token.nextToken().toInt()
		val ds = token.nextToken().toInt()
		var max = 0
		for (i in rs until rs + 3) {
			for (j in cs until cs + 3) {
				max = maxOf(max, map[i][j])
			}
		}
		max -= ds
		if (max < 0) max = 0
		for (i in rs until rs + 3) {
			for (j in cs until cs + 3) {
				map[i][j] = minOf(max, map[i][j])
			}
		}
	}

	for (i in 1 .. r) {
		for (j in 1 .. c) {
			if (map[i][j] < e) {
				total += e - map[i][j]
			}
		}
	}
	println(72 * 72 * total)
}

main()
