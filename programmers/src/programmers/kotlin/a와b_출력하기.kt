package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181951
fun main(args: Array<String>) {
    val (a, b) = readln().split(' ').map(String::toInt)

    println("a = $a")
    println("b = $b")
}