// https://www.acmicpc.net/problem/2422

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val comb = Array(201) { BooleanArray(201) }
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	var result = 0

	for (i in 0 until m) {
		token = StringTokenizer(reader.readLine())
		val a = token.nextToken().toInt()
		val b = token.nextToken().toInt()
		comb[a][b] = true
		comb[b][a] = true
	}

	for (i in 1 .. n) {
		for (j in i + 1 .. n) {
			if (comb[i][j]) continue
			for (k in j + 1 .. n) {
				if (comb[i][k] || comb[j][k]) continue
				++result
			}
		}
	}
	println(result)
}

main()
