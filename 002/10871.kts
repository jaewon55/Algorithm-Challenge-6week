// https://www.acmicpc.net/problem/10871

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val x = token.nextToken().toInt()
	token = StringTokenizer(reader.readLine())
	var count = 0;
	for (i in 0 until n) {
		val num = token.nextToken().toInt()
		if (num < x) {
			if (count != 0) writer.write(" ")
			writer.write("$num")
			++count
		}
	}
	writer.write("\n")
	writer.flush()
}

main()
