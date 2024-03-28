// https://www.acmicpc.net/problem/1244

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	var token = StringTokenizer(reader.readLine())
	val switch = IntArray(n + 1)

	for (i in 1 .. n) {
		switch[i] = token.nextToken().toInt()
	}

	repeat(reader.readLine().toInt()) {
		token = StringTokenizer(reader.readLine())
		val isBoy = token.nextToken() == "1"
		val num = token.nextToken().toInt()
		if (isBoy) {
			for (i in num .. n step num) {
				switch[i] = (switch[i] + 1) % 2
			}
		} else {
			var s = num
			var e = num
			while (switch[s] == switch[e]) {
				if (s == 1 || e == n) break
				s--
				e++
			}
			if (switch[s] != switch[e]) {
				s++
				e--
			}
			for (i in s .. e) {
				switch[i] = (switch[i] + 1) % 2
			}
		}
	}

	for (i in 1 .. n) {
		writer.write("${switch[i]} ")
		if (i % 20 == 0) writer.write("\n")
	}
	if (n % 20 != 0) writer.write("\n")
	writer.close()
}

main()
