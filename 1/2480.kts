import java.util.Scanner

fun main() {
	val sc = Scanner(System.`in`)
	val a = sc.nextInt()
	val b = sc.nextInt()
	val c = sc.nextInt()
	val ret = when {
		a == b && b == c -> 10000 + a * 1000
		a == b || a == c -> 1000 + a * 100
		b == c -> 1000 + b * 100
		else -> maxOf(a, b, c) * 100
	}
	println(ret)
}

main()