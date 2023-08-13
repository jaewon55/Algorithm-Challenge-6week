// https://www.acmicpc.net/problem/2438

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	for (i in 1..n) {
		for (j in 1..i) {
			writer.write("*")
		}
		writer.write("\n")
	}
	writer.flush()
}

main()
