// https://www.acmicpc.net/problem/1655

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	val writer = System.out.bufferedWriter()
	val n = reader.readLine().toInt()
	val minHeap = PriorityQueue<Int>(compareBy{ -it })
	val maxHeap = PriorityQueue<Int>()

	for (i in 0 until n) {
		val num = reader.readLine().toInt()

		if (maxHeap.size < minHeap.size) {
			maxHeap.offer(num)
		} else {
			minHeap.offer(num)
		}

		if (!maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
			val minTop = minHeap.poll()
			val maxTop = maxHeap.poll()
			minHeap.offer(maxTop)
			maxHeap.offer(minTop)
		}
		writer.write("${minHeap.peek()}\n")
	}
	writer.flush()
}

main()
