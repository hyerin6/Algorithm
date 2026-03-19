package programmers.kotlin

// https://school.programmers.co.kr/learn/courses/30/lessons/181949
fun main(args: Array<String>) {
    val s1 = readLine()!!

    for (i in s1.indices) {
        if (s1[i].isUpperCase()) {
            print(s1[i].lowercase())
        } else {
            print(s1[i].uppercase())
        }
    }
}