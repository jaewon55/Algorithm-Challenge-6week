// https://www.acmicpc.net/problem/14719

import java.util.*

val list = mutableListOf<Int>()

fun count(l: Int, r: Int): Int {
	val leftH = list[l]
	val rightH = list[r]
	val width = r - l - 1;
	val height = if (leftH > rightH) rightH else leftH
	val totalSpace = width * height
	var blocks = 0;

	if (width < 1) return 0

	for (i in l + 1 until r) {
		blocks += list[i]
	}
	return totalSpace - blocks
}

fun maxElementIdxOfLeft(m: Int): Int {
	var ret = m - 1;
	var maxElement = list[m - 1]
	for (i in m - 1 downTo 0) {
		if (maxElement <= list[i]) {
			ret = i
			maxElement = list[i]
		}
	}
	return ret
}

fun maxElementIdxOfRight(m: Int): Int {
	var ret = m + 1;
	var maxElement = list[m + 1]
	for (i in m + 1 until list.size) {
		if (maxElement <= list[i]) {
			ret = i
			maxElement = list[i]
		}
	}
	return ret
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val h = token.nextToken().toInt()
	val w = token.nextToken().toInt()
	var highest = 0;
	var highestIdx = 0;
	var ret = 0;

	token = StringTokenizer(reader.readLine())
	for (i in 0 until w) {
		val blocks = token.nextToken().toInt()
		list.add(blocks)
		if (highest < blocks) {
			highest = blocks
			highestIdx = i
		}
	}

	var idx = highestIdx
	while (0 < idx) {
		val nextIdx = maxElementIdxOfLeft(idx)
		if (nextIdx < 0) break
		ret += count(nextIdx, idx)
		idx = nextIdx
	}
	idx = highestIdx
	while (idx < list.lastIndex) {
		val nextIdx = maxElementIdxOfRight(idx)
		if (nextIdx < 0) break
		ret += count(idx, nextIdx)
		idx = nextIdx
	}
	writer.write("$ret\n")
	writer.flush()
}

main()
