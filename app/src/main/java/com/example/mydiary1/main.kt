package com.example.mydiary1

fun main() {
    // Generate a random 4-digit number without repeating digits
    val number = (0..9).shuffled().take(4).joinToString("")

    // Prompt the user to guess the number
    print("Guess the 4-digit number without repeating digits: ")
    val guess = readLine()!!

    // Compare the guess to the number and give result
    val (n, m) = getPair(number, guess)
    println("Correct Digits: N :$n")
    println("Correct Digits at the right place: M :$m")
    println("Number: $number")
}

fun getPair(number: String, guess: String): Pair<Int, Int> {
    //correct digits
    var n = 0
    //correct digits on right place
    var m = 0
    //go though every digits
    for (i in 0 until 4) {
        //store the guessed digit in digit
        val digit = guess[i]
        //compare it to the digit at the same spot on the number
        if (digit == number[i]) {
            m++
        }
        //compare it with every digit in the number
        if (digit in number) {
            n++
        }
    }
    //if there were some digits at the same place, we have to deduct them from n to not double count them
    n -= m
    //return the m and n values
    return Pair(n, m)
}
