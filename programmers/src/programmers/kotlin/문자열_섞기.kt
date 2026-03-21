package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181942
class S181942 {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""

        repeat(str1.length) {
            answer += str1[it]
            answer += str2[it]
        }

        return answer
    }

    fun solution2(str1: String, str2: String): String {
        return str1.zip(str2).joinToString("") { (a, b) -> "$a$b" }
    }
}

fun main() {
    val solution = S181942()

    val result1 = solution.solution("aaaaa", "bbbbb")
    println(result1)

    val result2 = solution.solution2("aaaaa", "bbbbb")
    println(result2)
}