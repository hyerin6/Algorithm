package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181944
fun main(args: Array<String>) {
    val a = readln().toInt()

    if (a % 2 == 1) {
        println("$a is odd")
    } else {
        println("$a is even")
    }

}