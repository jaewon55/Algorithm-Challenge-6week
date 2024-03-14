// https://www.acmicpc.net/problem/10655

import java.util.*

fun getDistance(x1: Int, y1: Int, x2: Int, y2: Int): Long {
	return (Math.abs(x1 - x2) + Math.abs(y1 - y2)).toLong()
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val px = IntArray(n)
	val py = IntArray(n)
	var dist = 0L
	var minus = 0L
	var prevDist = 0L
	var nextDist = 0L

	for (i in 0 until n) {
		val token = StringTokenizer(reader.readLine())
		px[i] = token.nextToken().toInt()
		py[i] = token.nextToken().toInt()
	}

	dist = getDistance(px[0], py[0], px[1], py[1])
	prevDist = dist

	for (i in 1 until n - 1) {
		val skipDist = getDistance(px[i - 1], py[i - 1], px[i + 1], py[i + 1])
		nextDist = getDistance(px[i], py[i], px[i + 1], py[i + 1])
		minus = maxOf(minus, prevDist + nextDist - skipDist)
		prevDist = nextDist
		dist += nextDist
	}
	println(dist - minus)
}

main()
