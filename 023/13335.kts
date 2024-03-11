// https://www.acmicpc.net/problem/13335

import java.util.*

fun main() {
	val reader = System.`in`.bufferedReader()
	var token = StringTokenizer(reader.readLine())
	val n = token.nextToken().toInt()
	val w = token.nextToken().toInt()
	val l = token.nextToken().toInt()
	val waitTruck = LinkedList<Truck>()
	val bridge = LinkedList<Truck>()
	var time = 0
	var weightSum = 0

	token = StringTokenizer(reader.readLine())
	for (i in 0 until n) {
		waitTruck.offer(Truck(token.nextToken().toInt(), 1))
	}

	while (waitTruck.isNotEmpty()) {
		for (truck in bridge) {
			truck.position = truck.position + 1
		}

		if (bridge.isNotEmpty() &&  w < bridge.peek().position) {
			weightSum -= bridge.poll().weight
		}
		if (weightSum + waitTruck.peek().weight <= l) {
			weightSum += waitTruck.peek().weight
			bridge.offer(waitTruck.poll())
		}
		++time
	}
	println(time + w)
}

data class Truck(val weight: Int, var position: Int)

main()
