package programmers.kotlin

import kotlin.math.max

// https://school.programmers.co.kr/learn/courses/30/lessons/181939
class S181939 {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0

        val n1 = "$a$b".toInt()
        val n2 = "$b$a".toInt()

        answer = n2
        if (n1 > n2) {
            answer = n1
        }

        return answer
    }

    fun solution2(a: Int, b: Int): Int {
        return max("$a$b".toInt(), "$b$a".toInt())
    }
}

fun main() {
    val solution = S181939()

    val result1 = solution.solution(9, 91)
    println(result1)

    val result2 = solution.solution2(9, 91)
    println(result2)
}