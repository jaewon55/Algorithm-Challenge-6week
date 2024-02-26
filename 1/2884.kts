import java.util.Scanner

fun main() {
	val sc = Scanner(System.`in`)
	val h = sc.nextInt()
	val m = sc.nextInt()
	var printM = m - 45
	var printH = h
	if (printM < 0) {
		--printH
		printM += 60
	}
	if (printH < 0) {
		printH += 24
	}
	println("$printH $printM")
}

main()