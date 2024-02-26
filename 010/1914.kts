// https://www.acmicpc.net/problem/1914

import java.math.BigInteger

val writer = System.out.bufferedWriter()

fun hanoi(n: Int, from: Int, to: Int) {
	if (n == 1) {
		writer.write("$from ${to}\n")
		return
	}

	hanoi(n - 1, from, 6 - from - to)
	writer.write("$from ${to}\n")
	hanoi(n - 1, 6 - from - to, to)
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val result = BigInteger("2").pow(n).minus(BigInteger.ONE)

	writer.write("${result}\n")

	if (n < 21) {
		hanoi(n, 1, 3)
	}
	writer.flush()
}

main()
