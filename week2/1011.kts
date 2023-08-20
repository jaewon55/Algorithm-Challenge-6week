// https://www.acmicpc.net/problem/1011

import java.util.StringTokenizer

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val t = reader.readLine().toInt()
	var token : StringTokenizer
	var x = 0L
	var y = 0L
	var len = 0L

	for (i in 0 until t) {
		token = StringTokenizer(reader.readLine())
		x = token.nextToken().toLong()
		y = token.nextToken().toLong()
		len = y - x
		if (len < 2) {
			writer.write("1\n")
		} else if (len < 3) {
			writer.write("2\n")
		} else if (len < 5) {
			writer.write("3\n")
		} else {
			var count = 2L
			len -= 2
			var half = len / 2
			var biggest = 2L
			var plusNum = 2L
			while (plusNum + biggest + 1 <= half) {
				biggest += 1
				plusNum += biggest
			}
			var remain = len - (plusNum * 2)
			if (remain > biggest + 1) {
				count += 2
			} else if (remain > 0L) {
				count += 1
			}
			count += (biggest - 1) * 2
			writer.write("$count\n")
		}
	}
	writer.flush()
}

main()

/*
0 6		4
0 7		5
0 8		5
0 9		5
0 10	6
0 11	6
0 12	6
0 13	6
0 14	7
0 15	7
 */
