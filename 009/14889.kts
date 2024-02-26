// https://www.acmicpc.net/problem/14889

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	var token: StringTokenizer
	val s = Array(n) {
		token = StringTokenizer(reader.readLine())
		IntArray(n) { token.nextToken().toInt() }
	}
	val startTeam = BooleanArray(n) { false }
	var result = Int.MAX_VALUE

	fun recur(depth: Int, start: Int) {
		if (depth == n / 2) {
			var synergyOfStart = 0
			var synergyOfLink = 0
			for (i in 0 until n) {
				for (j in i + 1 until n) {
					if (startTeam[i] != startTeam[j]) continue
					if (startTeam[i]) {
						synergyOfStart += s[i][j] + s[j][i]
					} else {
						synergyOfLink += s[i][j] + s[j][i]
					}
				}
			}
			val abs = Math.abs(synergyOfStart - synergyOfLink)
			if (abs < result) result = abs
			return
		}

		for (i in start until n) {
			startTeam[i] = true
			recur(depth + 1, i + 1)
			startTeam[i] = false
			if (depth == 0) break
		}
	}
	recur(0, 0)
	writer.write("${result}\n")
	writer.flush()
}

main()
