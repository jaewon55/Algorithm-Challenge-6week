// https://www.acmicpc.net/problem/15686

val BLANK = 0
val HOUSE = 1
val CHICKEN = 2

fun main() {
	val reader = System.`in`.bufferedReader()
	val input = reader.readLine().split(" ")
	val n = input[0].toInt()
	val m = input[1].toInt()
	val map = Array(n) {
		reader.readLine().split(" ").map { it.toInt() }
	}
	val houseList = mutableListOf<Pair<Int,Int>>()
	val chikenList = mutableListOf<Pair<Int,Int>>()
	var result = Int.MAX_VALUE

	for (r in 0 until n) {
		for (c in 0 until n) {
			when(map[r][c]) {
				HOUSE -> houseList.add(r to c)
				CHICKEN -> chikenList.add(r to c)
			}
		}
	}

	fun recurv(depth: Int, start: Int, selectList: MutableList<Pair<Int,Int>>) {
		if (depth == m) {
			var sum = 0
			for (hp in houseList) {
				var chikenDistance = Int.MAX_VALUE
				for (cp in selectList) {
					val dist = Math.abs(hp.first - cp.first) + Math.abs(hp.second - cp.second)
					chikenDistance = minOf(chikenDistance, dist)
				}
				sum += chikenDistance
			}
			result = minOf(sum, result)
			return
		}

		for (i in start until chikenList.size) {
			selectList.add(chikenList[i])
			recurv(depth + 1, i + 1, selectList)
			selectList.removeLast()
		}
	}

	recurv(0, 0, mutableListOf())
	println(result)
}

main()
