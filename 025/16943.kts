// https://www.acmicpc.net/problem/16943

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val aByString = token.nextToken()
	val b = token.nextToken().toInt()
	val a = IntArray(aByString.length) { aByString[it].toInt() - '0'.toInt() }
	val visit = BooleanArray(a.size)
	var result = 0

	fun recurv(depth: Int, sum: Int) {
		if (depth == a.size) {
			result = maxOf(result, sum)
			return
		}

		for (i in 0 until a.size) {
			if (visit[i]) continue
			val num = sum * 10 + a[i]
			if (b < num || num == 0) continue
			visit[i] = true
			recurv(depth + 1, num)
			visit[i] = false
		}
	}

	recurv(0, 0)
	if (result == 0) --result
	println(result)
}

main()
