// https://www.acmicpc.net/problem/2562

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var max = -1
	var idx = -1
	for (i in 1..9) {
		val num = reader.readLine().toInt()
		if (max < num) {
			max = num
			idx = i
		}
	}
	writer.write("$max\n$idx\n")
	writer.flush()
}

main()
