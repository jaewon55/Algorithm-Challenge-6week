// https://www.acmicpc.net/problem/2437

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val arr = IntArray(n){token.nextToken().toInt()}
	arr.sort()

	var sum = 0
	for (e in arr) {
		if (sum + 1 < e) break;
		sum += e
	}
	writer.write("${sum + 1}\n")
	writer.flush()
}

main()
