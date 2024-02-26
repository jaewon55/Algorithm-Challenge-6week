// https://www.acmicpc.net/problem/14888

import java.util.*

var max = Int.MIN_VALUE
var min = Int.MAX_VALUE
lateinit var nums: IntArray
lateinit var operators: IntArray

fun calculate(arr: IntArray) {
	var ret = nums[0]
	for (i in 0 until arr.size) {
		when(arr[i]) {
			0 -> ret += nums[i + 1] 
			1 -> ret -= nums[i + 1]
			2 -> ret *= nums[i + 1]
			else -> ret /= nums[i + 1]
		}
	}
	if (ret > max) max = ret
	if (ret < min) min = ret
}

fun recur(depth: Int, n: Int, arr: IntArray) {
	if (depth == n - 1) return calculate(arr)
	for (i in 0 until 4) {
		if (operators[i] == 0) continue;
		operators[i] -= 1
		arr[depth] = i
		recur(depth + 1, n, arr)
		operators[i] += 1
	}
}

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	var token = StringTokenizer(reader.readLine())
	nums = IntArray(n){ token.nextToken().toInt() }
	token = StringTokenizer(reader.readLine())
	operators = IntArray(4){ token.nextToken().toInt() }
	recur(0, n, IntArray(n - 1))
	writer.write("$max\n$min\n")
	writer.flush()
}

main()
