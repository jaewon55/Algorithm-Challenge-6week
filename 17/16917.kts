// https://www.acmicpc.net/problem/16917

import java.util.*

val SAUCE = 0
val FRIED = 1
val HALF = 2

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val price = IntArray(3) { token.nextToken().toInt() }
	val x = token.nextToken().toInt()
	val y = token.nextToken().toInt()
	var result = price[SAUCE] * x + price[FRIED] * y
	val countOfSauce: Int
	val countOfFried: Int
	val countOfHalf: Int


	if (price[HALF] * 2 < price[SAUCE] + price[FRIED]) {
		countOfHalf = minOf(x, y) * 2
		countOfSauce = x - (countOfHalf / 2)
		countOfFried = y - (countOfHalf / 2)
		result = price[SAUCE] * countOfSauce + price[FRIED] * countOfFried + price[HALF] * countOfHalf
		result = minOf(result, maxOf(x, y) * 2 * price[HALF])
	}
	println(result)
}

main()
