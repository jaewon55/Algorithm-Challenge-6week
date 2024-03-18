// https://www.acmicpc.net/problem/13627

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val r = token.nextToken().toInt()
	val returned = BooleanArray(n + 1)

	if (n == r) {
		writer.write("*")
	} else {
		token = StringTokenizer(reader.readLine())
		repeat(r) {
			returned[token.nextToken().toInt()] = true
		}
		for (i in 1 .. n) {
			if (returned[i]) continue
			writer.write("$i ")
		}
	}
	writer.write("\n")
	writer.close()
}

main()
