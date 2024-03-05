// https://www.acmicpc.net/problem/9012

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	var stackSize = 0

	repeat(t) {
		val line = reader.readLine()
		for (c in line) {
			if (c == '(') {
				++stackSize
			} else {
				--stackSize
			}
			if (stackSize < 0) break
		}
		if (stackSize == 0) writer.write("YES\n") else writer.write("NO\n")
		stackSize = 0
	}
	writer.close()
}

main()
