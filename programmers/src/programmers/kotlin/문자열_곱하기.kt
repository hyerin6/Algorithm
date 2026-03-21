package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181940
class S181940 {
    fun solution(myString: String, k: Int): String {
        var answer: String = ""

        for (i in 0 until k) {
            answer += myString
        }

        return answer
    }

    fun solution2(myString: String, k: Int): String {
        return myString.repeat(k)
    }
}

fun main() {
    val solution = S181940()

    val result1 = solution.solution("string", 3)
    println(result1)

    val result2 = solution.solution2("string", 3)
    println(result2)
}