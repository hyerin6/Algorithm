package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181950
fun main(args: Array<String>) {
    val input = readLine()!!.split(' ')
    val s1 = input[0]
    val a = input[1]!!.toInt()

    // (1)
    repeat(a) {
        print(s1)
    }

    // (2)
    for (i in 1..a) {
        print(s1)
    }

    // (3)
    for (i in 0 until a) {
        print(s1)
    }
}