// https://www.acmicpc.net/problem/8393

fun main() {
	val n = readln().toInt()
	var sum = 0;
	for (i in 1..n) {
		sum += i
	}
	println(sum)
}

main()