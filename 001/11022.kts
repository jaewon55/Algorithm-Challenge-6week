// https://www.acmicpc.net/problem/11022

import java.io.*
import java.util.*

fun genPrintString(x: Int, a: Int, b: Int) = "Case #$x: $a + $b = ${a + b}\n"

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	for (i in 1..t) {
		val token = StringTokenizer(reader.readLine())
		val printString = genPrintString(i, token.nextToken().toInt(), token.nextToken().toInt())
		writer.write(printString)
	}
	writer.flush()
}

main()
