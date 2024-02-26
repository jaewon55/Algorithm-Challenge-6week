// https://www.acmicpc.net/problem/6603

import java.util.*

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val s = IntArray(13)
val select = IntArray(6)
var k = 0

fun recur(depth: Int, start: Int) {
	if (depth == 6) {
		for (i in 0 until 5) {
			writer.write("${select[i]} ")
		}
		writer.write("${select[5]}\n")
		return
	}

	for (i in start until k) {
		select[depth] = s[i]
		recur(depth + 1, i + 1)
	}
}

fun main() {
	var token = StringTokenizer(reader.readLine())
	k = token.nextToken().toInt()
	while (true) {
		for (i in 0 until k) {
			s[i] = token.nextToken().toInt()
		}
		s.sort(0, k)
		recur(0, 0)
		token = StringTokenizer(reader.readLine())
		k = token.nextToken().toInt()
		if (6 < k) writer.write("\n") else break
	}
	writer.flush()
}

main()
