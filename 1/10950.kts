// https://www.acmicpc.net/problem/10950

fun main() {
	val t = readln().toInt()
	val numberList = mutableListOf<Int>()
	for (i in 0 until t) {
		val ab = readln().split(" ").map{ it.toInt() }
		numberList.addAll(ab)
	}
	for (i in 0 until numberList.size - 1 step 2) {
		println(numberList[i] + numberList[i + 1])
	}
}

main()
