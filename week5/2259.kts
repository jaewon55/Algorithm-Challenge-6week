// https://www.acmicpc.net/problem/2259

import java.util.*

data class Mole(val x: Double, val y: Double, val t: Double)

fun canCatch(from: Mole, to: Mole, s: Int): Boolean {
	val distanceX = (from.x - to.x) * (from.x - to.x)
	val distanceY = (from.y - to.y) * (from.y - to.y)
	val time = (to.t - from.t) * (to.t - from.t)
	return distanceX + distanceY <= time * s * s
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val s = token.nextToken().toInt()
	val moles = Array<Mole>(n + 1) {
		if (it == 0) {
			Mole(.0, .0, .0)
		} else {
			token = StringTokenizer(reader.readLine())
			Mole(token.nextToken().toDouble(), token.nextToken().toDouble(), token.nextToken().toDouble())
		}
	}.sortedBy{ it.t }
	val dp = IntArray(n + 1) { if (it == 0) 0 else -1 }

	for (i in 1..n) {
		for (j in 0 until i) {
			if (dp[j] != -1 && canCatch(moles[j], moles[i], s)) {
				dp[i] = maxOf(dp[i], dp[j] + 1)
			}
		}
	}

	writer.write("${dp.max()}")
	writer.flush()
}

main()
