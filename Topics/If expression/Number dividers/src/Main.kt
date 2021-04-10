fun main() {
    val a = readLine()!!.toInt()
    
    if ( a % 6 == 0 ) println("Divided by 6")
    if ( a % 5 == 0 ) println("Divided by 5")
    if ( a % 3 == 0 ) println("Divided by 3")
    if ( a % 2 == 0 ) println("Divided by 2")
}
