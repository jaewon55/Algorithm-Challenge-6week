// https://www.acmicpc.net/problem/10807

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine()
	val list = reader.readLine().split(" ").map{ it.toInt() }
	val v = reader.readLine().toInt()

	writer.write("${list.count{ it == v }}\n")
	writer.flush()
}

main()
