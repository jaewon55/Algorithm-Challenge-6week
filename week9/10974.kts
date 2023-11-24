// https://www.acmicpc.net/problem/10974

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val arr = IntArray(n)
	val visit = Array(n) { false }

	fun recur(depth: Int) {
		if (depth == n) {
			writer.write("${arr.joinToString(" ")}\n")
			return
		}

		for (i in 1 .. n) {
			if (visit[i - 1]) continue
			visit[i - 1] = true
			arr[depth] = i
			recur(depth + 1)
			visit[i - 1] = false
		}
	}
	recur(0)
	writer.flush()
}

main()
