// https://www.acmicpc.net/problem/16967

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val h = token.nextToken().toInt()
	val w = token.nextToken().toInt()
	val x = token.nextToken().toInt()
	val y = token.nextToken().toInt()
	val b = Array(h + x) {
		token = StringTokenizer(reader.readLine())
		IntArray(w + y) { token.nextToken().toInt() }
	}
	val a = Array(h) { IntArray(w) }

	for (i in 0 until h) {
		for (j in 0 until w) {
			val minusValue = if (0 <= i - x && 0 <= j - y) a[i - x][j - y] else 0
			a[i][j] = b[i][j] - minusValue
			writer.write("${a[i][j]} ")
		}
		writer.write("\n")
	}
	writer.close()
}

main()
