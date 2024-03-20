// https://www.acmicpc.net/problem/15235

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val slicesNeeded = IntArray(n) { token.nextToken().toInt() }
	var timeNeeded = IntArray(n)
	var second = 0
	var numberOfFullPeople = 0

	while (numberOfFullPeople < n) {
		for (i in 0 until n) {
			if (slicesNeeded[i] == 0) continue
			++second
			slicesNeeded[i] -= 1
			if (slicesNeeded[i] == 0) {
				timeNeeded[i] = second
				++numberOfFullPeople
			}
		}
	}
	println(timeNeeded.joinToString(" "))
}

main()
