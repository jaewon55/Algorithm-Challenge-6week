// https://www.acmicpc.net/problem/11723

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val m = reader.readLine().toInt()
	val S = Array(21) { false }
	var token: StringTokenizer
	for (i in 0 until m) {
		token = StringTokenizer(reader.readLine())

		val oper = token.nextToken()
		val x = if (token.hasMoreTokens()) token.nextToken().toInt() else 0
		when(oper) {
			"add" -> S[x] = true
			"remove" -> S[x] = false
			"check" -> if (S[x]) writer.write("1\n") else writer.write("0\n")
			"toggle" -> S[x] = !S[x]
			"all" -> S.fill(true)
			"empty" -> S.fill(false)
		}
	}
	writer.flush()
}

main()
