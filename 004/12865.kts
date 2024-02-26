// https://www.acmicpc.net/problem/12865

import java.util.*

data class Item(val w: Int, val v: Int)

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val k = token.nextToken().toInt()
	val items = Array<Item>(n) {
		token = StringTokenizer(reader.readLine())
		Item(token.nextToken().toInt(), token.nextToken().toInt())
	}

	val dp = Array(n + 1) { IntArray(k + 1) }

    for (i in 1..n) {
        val w = items[i - 1].w
		val v = items[i - 1].v
        for (j in 0..k) {
            dp[i][j] = dp[i - 1][j]
            if (j >= w) {
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j - w] + v)
            }
        }
    }
	writer.write("${dp[n][k]}")
	writer.flush()
}

main()
