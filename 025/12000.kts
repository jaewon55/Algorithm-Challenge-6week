// https://www.acmicpc.net/problem/12000

fun main() {
	var reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val cows = IntArray(n) { reader.readLine().toInt() }
	var minDistance = Int.MAX_VALUE

	for (enterDoor in 0 until n) {
		var total = 0
		for (room in 0 until n) {
			val distance = (n + (room - enterDoor)) % n
			total += cows[room] * distance
		}
		minDistance = minOf(minDistance, total)
	}
	println(minDistance)
}

main()
