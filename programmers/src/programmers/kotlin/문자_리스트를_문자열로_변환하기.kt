package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181941
class S181941 {
    fun solution(arr: Array<String>): String {
        return arr.joinToString("")
    }
}

fun main() {
    val solution = S181941()

    val result = solution.solution(arrayOf("a", "b", "c", "d", "e", "f", "g", "h"))
    println(result)
}