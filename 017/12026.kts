// https://www.acmicpc.net/problem/12026

val B = 'B'
val O = 'O'
val J = 'J'

fun main() {
	val reader = System.`in`.bufferedReader()
	val n = reader.readLine().toInt()
	val blocks = reader.readLine()
	val dp = IntArray(n)

	for (i in 0 until n - 1) {
		if (i > 0 && dp[i] == 0) continue
		val nextBlock = when(blocks[i]) {
			B -> O
			O -> J
			else -> B
		}

		for (j in i + 1 until n) {
			if (blocks[j] != nextBlock) continue
			if (dp[j] == 0) {
				dp[j] = dp[i] + (j - i) * (j - i)
			} else {
				dp[j] = minOf(dp[j], dp[i] + (j - i) * (j - i))
			}
		}
	}

	if (n != 1 && dp[n - 1] == 0) {
		println(-1)
	} else {
		println(dp[n - 1])
	}
}

main()
