// https://www.acmicpc.net/problem/10951

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var line: String?
	while (reader.readLine().also{ line = it } != null) {
		val token = StringTokenizer(line)
		writer.write("${token.nextToken().toInt() + token.nextToken().toInt()}\n")
	}
	writer.flush()
}

main()
