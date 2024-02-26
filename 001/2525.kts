import java.util.Scanner

fun main() {
	val sc = Scanner(System.`in`)
	var h = sc.nextInt()
	var m = sc.nextInt()
	var t = sc.nextInt()
	h += t / 60
	t %= 60
	if (m + t > 59) {
		++h
		m += t - 60
	} else {
		m += t
	}
	if (h > 23) h -= 24
	println("$h $m")
}

main()