// https://www.acmicpc.net/problem/10952

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	while(true) {
		val token = StringTokenizer(reader.readLine())
		val a = token.nextToken().toInt()
		val b = token.nextToken().toInt()
		if (a == 0 && b == 0) break
		writer.write("${a + b}\n")
	}
	writer.flush()
}

main()
