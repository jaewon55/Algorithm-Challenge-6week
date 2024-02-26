import java.util.Scanner

fun main() {
	val sc = Scanner(System.`in`)
	val a = sc.nextInt()
	val b = sc.nextInt()
	val ret = if (a == b) {
		"=="
	} else if (a > b) {
		">"
	} else {
		"<"
	}
	println(ret)
}

main()