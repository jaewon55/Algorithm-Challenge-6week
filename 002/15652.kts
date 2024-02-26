// https://www.acmicpc.net/problem/15652

import java.util.StringTokenizer

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val m = token.nextToken().toInt()
	val arr = IntArray(m)
	var chagnedIdx: Int

	for (i in 0 until m) {
		arr[i] = 1
	}

	while (true) {
		for (i in 0 until m) {
			if (i != 0) writer.write(" ")
			writer.write("${arr[i]}")
		}
		writer.write("\n")
		if (arr[0] == n) break

		arr[arr.lastIndex] = arr[arr.lastIndex] + 1
		if (arr[arr.lastIndex] > n) {
			chagnedIdx = arr.lastIndex
			for (i in arr.lastIndex - 1 downTo 0) {
				if (arr[i] < n) {
					chagnedIdx = i
					break
				}
			}
			arr[chagnedIdx] = arr[chagnedIdx] + 1
			for (i in chagnedIdx until m) {
				arr[i] = arr[chagnedIdx]
			}
		}
	}
	writer.flush()
}

main()
