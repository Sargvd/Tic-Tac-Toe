fun main() {
    var c1 = readLine()!!.split(" ").toTypedArray()
    var c2 = readLine()!!.split(" ").toTypedArray()
    
    var b1 = c1.map {it.toInt()}.toIntArray()
    b1.sort()
    var b2 = c2.map {it.toInt()}.toIntArray()
    b2.sort()

    if (b1[0] == b2[0] && b1[1] == b2[1] && b1[2] == b2[2]) println("Box 1 = Box 2")
    else if (b1[0] >= b2[0] && b1[1] >= b2[1] && b1[2] >= b2[2]) println("Box 1 > Box 2")
    else if  (b1[0] <= b2[0] && b1[1] <= b2[1] && b1[2] <= b2[2]) println("Box 1 < Box 2")
    else println("Incomparable")
}
