// https://www.acmicpc.net/problem/16918

import java.util.*

val BOMB = 0
val EMPTY = 1

fun printGrid(grid: Array<IntArray>, r: Int, c: Int) {
	val writer = System.out.bufferedWriter()

	for (x in 0 until r) {
		for (y in 0 until c) {
			if (grid[x][y] == 0) {
				writer.write("O")
			} else {
				writer.write(".")
			}
		}
		writer.write("\n")
	}
	writer.close()
}

fun printAllBomb(r: Int, c: Int) {
	val writer = System.out.bufferedWriter()

	for (i in 0 until r) {
		for (j in 0 until c) {
			writer.write("O")
		}
		writer.write("\n")
	}
	writer.close()
}

fun getNextGrid(grid: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
	val dx = arrayOf(1, -1, 0, 0)
	val dy = arrayOf(0, 0, 1, -1)
	val other = Array(r) { IntArray(c) }

	for (x in 0 until r) {
		for (y in 0 until c) {
			if (grid[x][y] == EMPTY) continue
			other[x][y] = EMPTY
			for (i in 0 until 4) {
				val nx = x + dx[i]
				val ny = y + dy[i]
				if (nx !in 0 until r || ny !in 0 until c) continue
				other[nx][ny] = EMPTY
			}
		}
	}
	return other
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val token = StringTokenizer(reader.readLine())
	val r = token.nextToken().toInt()
	val c = token.nextToken().toInt()
	val n = token.nextToken().toInt()
	var grid = Array(r) {
		val line = reader.readLine()
		IntArray(c) { i ->
			if (line[i] == 'O') BOMB else EMPTY
		}
	}
	var time = 1

	if (n % 2 == 0) {
		printAllBomb(r, c)
		return
	} else {
		while (time < n) {
			grid = getNextGrid(grid, r, c)
			time += 2
		}
		printGrid(grid, r, c)
	}
}

main()
