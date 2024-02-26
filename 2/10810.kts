// https://www.acmicpc.net/problem/10810

import java.util.StringTokenizer

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val arr = IntArray(n)
	var i: Int
	var j: Int
	var k: Int
	for (a in 0 until m) {
		token = StringTokenizer(reader.readLine())
		i = token.nextToken().toInt() - 1
		j = token.nextToken().toInt() - 1
		k = token.nextToken().toInt()
		for (b in i..j) {
			arr[b] = k
		}
	}
	for (a in 0 until arr.size) {
		if (a != 0) writer.write(" ")
		writer.write("${arr[a]}")
	}
	writer.write("\n")
	writer.flush()
}

main()
