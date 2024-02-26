// https://www.acmicpc.net/problem/2667

val reader = System.`in`.bufferedReader()
val writer = System.out.bufferedWriter()
val n = reader.readLine().toInt()
val arr = Array(n) {
	val line = reader.readLine()
	BooleanArray(n) { line[it] == '1' }
}
val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)
var count = 0

fun bfs(s: Pair<Int, Int>): Int {
	var houseCount = 0
	val deque = ArrayList<Pair<Int, Int>>()
	deque.add(s)
	arr[s.first][s.second] = false
	++houseCount

	while (!deque.isEmpty()) {
		val p = deque.removeAt(0)
		for (i in 0 until 4) {
			val y = p.first + dy[i]
			val x = p.second + dx[i]
			if (y < 0 || n <= y || x < 0 || n <= x) continue
			if (!arr[y][x]) continue
			deque.add(y to x)
			arr[y][x] = false
			++houseCount
		}
	}
	return houseCount
}

fun main() {
	val houseCountList = ArrayList<Int>()
	for (y in 0 until n) {
		for (x in 0 until n) {
			if (!arr[y][x]) continue
			houseCountList.add(bfs(y to x))
			++count
		}
	}
	writer.write("$count\n")
	houseCountList.sort()
	houseCountList.forEach{ writer.write("$it\n") }
	writer.flush()
}

main()
