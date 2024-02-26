// https://www.acmicpc.net/problem/2163

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	writer.write("${n * m - 1}")
	writer.flush()
}

main()
