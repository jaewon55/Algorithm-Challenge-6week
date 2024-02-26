// https://www.acmicpc.net/problem/1026

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	var token = StringTokenizer(reader.readLine())
	val a = IntArray(n){ token.nextToken().toInt() }.sorted()
	token = StringTokenizer(reader.readLine())
	val b = IntArray(n){ token.nextToken().toInt() }.sortedDescending()
	var s = 0
	for (i in 0 until n) {
		s += a[i] * b[i]
	}
	writer.write("$s")
	writer.flush()
}

main()
