// https://www.acmicpc.net/problem/2579

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val steps = IntArray(n + 1){ if (it == 0) 0 else reader.readLine().toInt() }
	val arr = IntArray(n + 1)
	arr[0] = 0
	arr[1] = steps[1]
	if (n > 1) arr[2] = steps[1] + steps[2]
	
	for (i in 3..n) {
        arr[i] = maxOf(arr[i - 2] + steps[i], arr[i - 3] + steps[i - 1] + steps[i])
  }
	writer.write("${arr[n]}\n")
	writer.flush()
}

main()
