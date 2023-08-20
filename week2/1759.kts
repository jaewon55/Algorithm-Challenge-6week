// https://www.acmicpc.net/problem/1759

import java.util.StringTokenizer

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	var token = StringTokenizer(reader.readLine())
	val l = token.nextToken().toInt()
	val c = token.nextToken().toInt()
	val idxArray = IntArray(l){ it }
	val inputChar = CharArray(c)
	token = StringTokenizer(reader.readLine())
	for (i in 0 until c) {
		inputChar[i] = token.nextToken()[0]
	}
	inputChar.sort()
	val vowels = "aeiou".filter{ it in inputChar }.toSet()
	val consonants = inputChar.filter{ it !in "aeiou" }.toSet()
	while(true) {
		var str = ""
		for (i in idxArray) {
			str = str + inputChar[i]
		}
		val vowelsCount = str.toCharArray().intersect(vowels).size
		val consonantsCount = str.toCharArray().intersect(consonants).size

		if (vowelsCount > 0 && consonantsCount > 1) {
			writer.write("$str\n")
		}

		if (idxArray[0] == c - l) break;

		if (idxArray.last() == inputChar.lastIndex) {
			var chagnedIdx = idxArray.lastIndex
			for (i in idxArray.lastIndex - 1 downTo 0) {
				if (idxArray[i + 1] - idxArray[i] > 1) {
					chagnedIdx = i
					idxArray[i] = idxArray[i] + 1
					break
				}
			}
			for (i in chagnedIdx + 1..idxArray.lastIndex) {
				idxArray[i] = idxArray[i - 1] + 1
			}
		} else {
			idxArray[idxArray.lastIndex] = idxArray[idxArray.lastIndex] + 1
		}
	}
	writer.flush()
}

main()
