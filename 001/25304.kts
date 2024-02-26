// https://www.acmicpc.net/problem/25304

fun main() {
	val totalAmount = readln().toInt()
	val count = readln().toInt()
	val amountOfEachItem = mutableListOf<Int>()

	for (i in 0 until count) {
		val amount = readln().split(" ")
		.map{it.toInt()}
		amountOfEachItem.add(amount[0] * amount[1])
	}
	val calculatedAmount = amountOfEachItem.reduce{ total, e ->
		total + e
	}
	if (totalAmount == calculatedAmount) {
		println("Yes")
	} else {
		println("No")
	}
}

main()