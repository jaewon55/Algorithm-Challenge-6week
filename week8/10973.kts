// https://www.acmicpc.net/problem/10973

import java.util.*

fun Array<Int>.swap(i: Int, j: Int) {
	val temp = this[i]
	this[i] = this[j]
	this[j] = temp
}

fun prevPermutation(perm: Array<Int>, n: Int) {
	var i = n - 1
	var j = n - 1

	while (0 < i && perm[i - 1] < perm[i]) {
		--i
	}

	if (i == 0) {
		println("-1")
		return
	}

	while (i < j && perm[i - 1] < perm[j]) {
		--j
	}

	perm.swap(i - 1, j)
	perm.sortDescending(i, n)
	println(perm.joinToString(" "))
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val token = StringTokenizer(reader.readLine())
	val perm = Array(n) {
		token.nextToken().toInt()
	}
	prevPermutation(perm, n)
}

main()
