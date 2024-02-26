// https://www.acmicpc.net/problem/10813

import java.util.StringTokenizer

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val arr = IntArray(n)
	var a: Int
	var b: Int
	var temp: Int
	for (i in 0 until n) {
		arr[i] = i + 1
	}
	for (i in 0 until m) {
		token = StringTokenizer(reader.readLine())
		a = token.nextToken().toInt() - 1
		b = token.nextToken().toInt() - 1
		temp = arr[b]
		arr[b] = arr[a]
		arr[a] = temp
	}
	for (i in 0 until n) {
		if (i != 0) writer.write(" ")
		writer.write("${arr[i]}")
	}
	writer.write("\n")
	writer.flush()
}

main()
