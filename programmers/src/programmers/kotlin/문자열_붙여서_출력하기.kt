package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181946
fun main(args: Array<String>) {
    val input = readLine()!!.split(' ')

    // (1)
    println(input.joinToString(""))

    val s1 = input[0]
    val s2 = input[1]

    // (2)
    println(s1 + s2)

    // (3)
    print("$s1$s2")

    // (4)
    val input2 = readln()
    println(input2.replace(" ", ""))
}