// https://www.acmicpc.net/problem/25314

fun main() {
	val n = readln().toInt()
	val longStr = "long"
	val longCount = n / 4

	for (i in 0 until longCount) {
		print(longStr + " ")
	}
	println("int")
}

main()
