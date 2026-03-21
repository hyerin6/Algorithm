package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181943
class S181943 {
    fun solution1(myString: String, overwriteString: String, s: Int): String {
        var answer: String = ""

        for (i in 0 until myString.length) {
            if (i >= s && i < overwriteString.length + s) {
                answer += overwriteString[i - s]
            } else {
                answer += myString[i]
            }
        }

        return answer
    }

    fun solution2(myString: String, overwriteString: String, s: Int): String {
        return myString.replaceRange(s, s + overwriteString.length, overwriteString)
    }

    fun solution3(myString: String, overwriteString: String, s: Int): String {
        return myString.slice(0 until s) +
                overwriteString +
                myString.substring(s + overwriteString.length)
    }

}

fun main() {
    val solution = S181943()

    val result1 = solution.solution1("aaaaaa", "bbb", 3)
    println(result1)

    val result2 = solution.solution2("aaaaaa", "bbb", 3)
    println(result2)

    val result3 = solution.solution3("aaaaaa", "bbb", 3)
    println(result3)
}