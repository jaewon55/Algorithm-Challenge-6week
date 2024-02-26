// https://www.acmicpc.net/problem/1759

import java.util.*

fun countVowels(password: Array<String>) =
	password.count{ "aeiou".contains(it) }

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val L = token.nextToken().toInt()
	val C = token.nextToken().toInt()
	token = StringTokenizer(reader.readLine())
	val letters = Array(C) {
		token.nextToken()
	}.sorted()
	val password = Array(L) { "" }

	fun recur(depth: Int, start: Int) {
		if (depth == L) {
			val countOfVowels = countVowels(password)
			if (0 < countOfVowels && 1 < L - countOfVowels) {
				println(password.joinToString(""))
			}
			return
		}

		for (i in start .. C - L + depth) {
			password[depth] = letters[i]
			recur(depth + 1, i + 1)
		}
	}
	recur(0, 0)
}

main()
