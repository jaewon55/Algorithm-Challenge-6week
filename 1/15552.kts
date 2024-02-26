// https://www.acmicpc.net/problem/15552

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	for (i in 0 until t) {
		val sum = reader.readLine()
			.split(" ")
			.map( {it.toInt()} )
			.let{ it[0] + it[1] }
		writer.write(sum.toString())
		writer.newLine()
	}
	reader.close()
	writer.close()
}

main()
