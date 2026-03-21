package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181945
fun main(args: Array<String>) {
    val s1 = readLine()!!

    // (1)
    repeat(s1.length) {
        println(s1[it])
    }

    // (2)
    s1.map(::println)
}