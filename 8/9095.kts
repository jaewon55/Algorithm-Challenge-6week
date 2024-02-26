// https://www.acmicpc.net/problem/9095

fun main() {
	val reader = System.`in`.bufferedReader()
	var t = reader.readLine().toInt()
	val arr = Array(11) { 0 }
	var count = 0


	fun recur(max: Int, sum: Int) {
		if (max == sum) {
			++count
			return
		}

		for (i in 1..3) {
			if (sum + i <= max) recur(max, sum + i)
		}
	}

	for (i in 0 until t) {
		val case = reader.readLine().toInt()
		recur(case, 0)
		println(count)
		count = 0
	}
}

main()
