// https://www.acmicpc.net/problem/16922

val reader = System.`in`.bufferedReader()
val n = reader.readLine().toInt()
val numbers = intArrayOf(1, 5, 10, 50)
val visit = BooleanArray(1001)
var result = 0

fun dfs(depth: Int, sum: Int, prev: Int) {
	if (depth == n) {
		if (!visit[sum]) {
			++result
			visit[sum] = true
		}
		return
	}

	for (i in prev until 4) {
		dfs(depth + 1, sum + numbers[i], i)
	}
}

fun main() {
	dfs(0, 0, 0)
	println(result)
}

main()
