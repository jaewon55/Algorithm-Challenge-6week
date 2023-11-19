// https://www.acmicpc.net/problem/10972

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	var num = 0
	for (i in 0 until n) {
		num *= 10
		num += token.nextToken().toInt()
	}
	var isSame = false
	var isNext = false
	val visit = Array(n + 1) { false }
	val result = Array(n) { 0 }

	fun recur(depth: Int, ret: Int) {
		if (depth == n) {
			if (isSame && !isNext) {
				println(result.joinToString(" "))
				isNext = true
			} else if (ret == num) {
				isSame = true
			}
			return
		}

		for (i in 1..n) {
			if (isNext) break
			if (visit[i]) continue
			visit[i] = true
			result[depth] = i
			recur(depth + 1, (ret * 10) + i)
			visit[i] = false
		}
	}
	recur(0, 0)
	if (!isNext) println("-1")
}

main()
