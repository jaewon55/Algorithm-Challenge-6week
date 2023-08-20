// https://www.acmicpc.net/problem/10818

import java.util.StringTokenizer

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	var min = token.nextToken().toInt()
	var max = min
	for (i in 1 until n) {
		val num = token.nextToken().toInt()
		if (num < min) min = num
		if (num > max) max = num
	}
	writer.write("$min $max\n")
	writer.flush()
}

main()
