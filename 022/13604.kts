// https://www.acmicpc.net/problem/13604

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val j = token.nextToken().toInt()
	val r = token.nextToken().toInt()
	val point = IntArray(j + 1)
	var winner = 0 to 0

	token = StringTokenizer(reader.readLine())
	repeat(r) {
		for (i in 1..j) {
			point[i] += token.nextToken().toInt()
			if (winner.second <= point[i]) winner = i to point[i]
		}
	}
	println(winner.first)
}

main()
