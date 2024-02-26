// https://www.acmicpc.net/problem/1263

import java.util.*

data class Work(val t: Int, val s: Int)

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val works = Array<Work>(n) {
		val token = StringTokenizer(reader.readLine())
		Work(token.nextToken().toInt(), token.nextToken().toInt())
	}.sortedByDescending{ it.s }
	var ret = works[0].s - works[0].t

	for (i in 1 until n) {
		if (ret < 0) {
			ret = -1
			break
		}
		val startTime = if (works[i].s < ret) works[i].s - works[i].t else ret - works[i].t
		ret = if (ret <= startTime) {
			ret - works[i].t
		} else {
			startTime
		}
	}
	if (ret < 0) ret = -1
	writer.write("$ret\n")
	writer.flush()
}

main()
