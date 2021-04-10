fun main() {
    var r = readLine()!!.toInt()
    print("$r ")
    while (r != 1) {
        if (r%2 == 0) r = r/2
        else r = r*3 +1
        print("$r ")
    }
}
