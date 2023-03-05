package com.example.mydiary1

fun main() {
    // Generate a random 4-digit number without repeating digits
    val number = (0..9).shuffled().take(4).joinToString("")

    // Prompt the user to guess the number
    print("Guess the 4-digit number without repeating digits: ")
    val guess = readLine()!!

    // Compare the guess to the number and give feedback
    val (n, m) = getFeedback(number, guess)
    println("$n:$m")
}

fun getFeedback(number: String, guess: String): Pair<Int, Int> {
    var n = 0
    var m = 0
    for (i in 0 until 4) {
        val digit = guess[i]
        if (digit == number[i]) {
            m++
        }
        if (digit in number) {
            n++
        }
    }
    n -= m
    return Pair(n, m)
}
