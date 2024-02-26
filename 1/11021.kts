// https://www.acmicpc.net/problem/11021
import java.io.*
import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	for (i in 1..t) {
		val token = StringTokenizer(reader.readLine())
		val sum = token.nextToken().toInt() + token.nextToken().toInt()
		writer.write("Case #$i: $sum\n")
	}
	writer.flush()
}

main()
