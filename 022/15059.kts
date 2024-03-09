// https://www.acmicpc.net/problem/15059

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val overRequestedMeal = IntArray(3)
	val availableToken = StringTokenizer(reader.readLine())
	val requestToken = StringTokenizer(reader.readLine())

	for (i in 0 until 3) {
		val diff = availableToken.nextToken().toInt() - requestToken.nextToken().toInt()
		if (diff < 0) overRequestedMeal[i] = -diff
	}
	println(overRequestedMeal.sum())
}

main()
