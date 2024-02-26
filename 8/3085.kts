// https://www.acmicpc.net/problem/3085


val reader = System.`in`.bufferedReader()
val n = reader.readLine().toInt()
val arr = Array(n) {
	val line = reader.readLine()
	Array(n) {
		line[it]
	}
}

fun countLeft(i: Int, j: Int): Int {
	var count = 0
	for (k in j - 1 downTo 0) {
		if (arr[i][j] == arr[i][k]) {
			++count
		} else {
			break
		}
	}
	return count
}

fun countRight(i: Int, j: Int): Int {
	var count = 0
	for (k in j + 1 until n) {
		if (arr[i][j] == arr[i][k]) {
			++count
		} else {
			break
		}
	}
	return count
}

fun countUp(i: Int, j: Int): Int {
	var count = 0
	for (k in i - 1 downTo 0) {
		if (arr[i][j] == arr[k][j]) {
			++count
		} else {
			break
		}
	}
	return count
}

fun countDown(i: Int, j: Int): Int {
	var count = 0
	for (k in i + 1 until n) {
		if (arr[i][j] == arr[k][j]) {
			++count
		} else {
			break
		}
	}
	return count
}

fun maxCount(i: Int, j: Int) =
	maxOf(countLeft(i, j) + countRight(i, j), countUp(i, j) + countDown(i, j)) + 1

fun swap(row1: Int, col1: Int, row2: Int, col2: Int) {
	val temp = arr[row1][col1]
	arr[row1][col1] = arr[row2][col2]
	arr[row2][col2] = temp
}



fun main() {
	var result = 1
	for (i in 0 until n) {
		for (j in 0 until n) {
			result = maxOf(maxCount(i, j), result)
			if (j + 1 != n && arr[i][j] != arr[i][j + 1]) {
				/* TODO 오른쪽 변환시 */
				swap(i, j, i, j + 1)
				result = maxOf(maxCount(i, j), maxCount(i, j + 1), result)
				swap(i, j, i, j + 1)
			}
			if (i + 1 != n && arr[i][j] != arr[i + 1][j]) {
				/* TODO 아래 변환시 */
				swap(i, j, i + 1, j)
				result = maxOf(maxCount(i, j), maxCount(i + 1, j), result)
				swap(i, j, i + 1, j)
			}
		}
	}
	println(result)
}

main()
