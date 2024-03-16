// https://www.acmicpc.net/problem/2138

fun check(bulb: BooleanArray, goal: BooleanArray): Boolean {
	for (i in 0 until bulb.size) {
		if (bulb[i] != goal[i]) return false
	}
	return true
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val bulb = BooleanArray(n)
	val goal = BooleanArray(n)
	val bulbInput = reader.readLine()
	val goalInput = reader.readLine()
	val copy : BooleanArray
	var count = 0

	for (i in 0 until n) {
		bulb[i] = bulbInput[i] == '1'
		goal[i] = goalInput[i] == '1'
	}
	copy = bulb.copyOf()

	for (i in 1 until n) {
		if (copy[i - 1] != goal[i - 1]) {
			++count
			copy[i - 1] = !copy[i - 1]
			copy[i] = !copy[i]
			if (i < n - 1) copy[i + 1] = !copy[i + 1]
		}
	}
	if (check(copy, goal)) {
		println(count)
		return
	}

	count = 1
	bulb[0] = !bulb[0]
	bulb[1] = !bulb[1]
	for (i in 1 until n) {
		if (bulb[i - 1] != goal[i - 1]) {
			++count
			bulb[i - 1] = !bulb[i - 1]
			bulb[i] = !bulb[i]
			if (i < n - 1) bulb[i + 1] = !bulb[i + 1]
		}
	}
	if (!check(bulb, goal)) {
		count = -1
	}
	println(count)
}

main()
