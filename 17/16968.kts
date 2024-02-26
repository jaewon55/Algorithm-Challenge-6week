// https://www.acmicpc.net/problem/16968

val SIZE_OF_NUMBERS = 10
val SIZE_OF_CHARS = 26

fun main() {
	val reader = System.`in`.bufferedReader()
	val format = reader.readLine()
	var result = if (format[0] == 'd') SIZE_OF_NUMBERS else SIZE_OF_CHARS

	for (i in 1 until format.size) {
		result *= when {
			format[i] == 'c' && format[i - 1] == 'c' -> SIZE_OF_CHARS - 1
			format[i] == 'c' && foramt[i - 1] == 'd' -> SIZE_OF_CHARS
			format[i] == 'd' && foramt[i - 1] == 'c' -> SIZE_OF_NUMBERS
			else -> SIZE_OF_NUMBERS - 1
		}
	}
	println(result)
}

main()
