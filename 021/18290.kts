// https://www.acmicpc.net/problem/18290

import java.util.*

val reader = System.`in`.bufferedReader()
var token = StringTokenizer(reader.readLine())
val n = token.nextToken().toInt()
val m = token.nextToken().toInt()
val k = token.nextToken().toInt()
val table = Array(n) { IntArray(m) }
val select = Array(n) { IntArray(m) }
val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)
var result = Int.MIN_VALUE

fun setSelect(r: Int, c: Int, value: Int) {
	select[r][c] += value
	for (i in 0 until 4) {
		val x = r + dx[i]
		val y = c + dy[i]
		if (x !in 0 until n || y !in 0 until m) continue
		select[x][y] += value
	}
}

fun dfs(depth: Int, sum: Int, startR: Int, startC: Int) {
	if (depth == k) {
		result = maxOf(result, sum)
		return
	}

	for (r in startR until n) {
		for (c in 0 until m) {
			if (startR == r && c < startC) continue
			if (0 < select[r][c]) continue
			val nextC = if (c + 2 < m) c + 2 else 0
			val nextR = if (nextC == 0) r + 1 else r
			setSelect(r, c, 1,)
			dfs(depth + 1, sum + table[r][c], nextR, nextC)
			setSelect(r, c, -1)
		}
	}
}

fun main() {
	for (i in 0 until n) {
		token = StringTokenizer(reader.readLine())
		for (j in 0 until m) {
			table[i][j] = token.nextToken().toInt()
		}
	}

	dfs(0, 0, 0, 0)

	println(result)
}

main()
