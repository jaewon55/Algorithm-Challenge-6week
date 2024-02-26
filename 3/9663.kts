// https://www.acmicpc.net/problem/9663

fun checkSpace(arr: Array<BooleanArray>, x: Int, y: Int, n: Int): Boolean {
	for (i in 0 until y) {
		if (arr[i][x]) return false
	}
	var i = y
	var j = x
	while (0 <= --i && 0 <= --j) {
		if (arr[i][j]) return false
	}
	i = y
	j = x
	while (0 <= --i && ++j < n) {
		if (arr[i][j]) return false
	}
	return true
}

fun recur(depth: Int, arr: Array<BooleanArray>, n: Int): Int {
	if (depth == n) return 1
	var count = 0

	for (i in 0 until n) {
		if (!checkSpace(arr, i, depth, n)) continue
		arr[depth][i] = true
		count += recur(depth + 1, arr, n)
		arr[depth][i] = false
	}
	return count;
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val arr = Array(n) {
		BooleanArray(n) { false }
	}
	val count = recur(0, arr, n)
	writer.write("$count\n")
	writer.flush()
}

main()
