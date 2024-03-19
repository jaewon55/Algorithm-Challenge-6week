// https://www.acmicpc.net/problem/9881

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val hills = IntArray(n) { reader.readLine().toInt() }
	var min = 0
	var result = Int.MAX_VALUE

	hills.sort()
	min = hills[0]

	while (min + 17 <= hills[n - 1]) {
		var sum = 0
		for (i in 0 until n) {
			if (hills[i] < min) {
				val x = min - hills[i]
				sum += x * x
			}
			if (min + 17 < hills[i]) {
				val x = hills[i] - (min + 17)
				sum += x * x
			}
		}
		result = minOf(result, sum)
		++min
	}
	println(result)
}

main()
