package tictactoe

fun isWin(board: List<CharArray>): Char {
    var whoWin = '_'

    //Check horizontals
    for (i in 0..board.lastIndex) {
        if ( (board[i][0] == board[i][1]) && board[i][1] == board[i][2] ) {
            if (whoWin == '_') whoWin = board[i][0]
            else return 'F'
        }
    }

    //Check verticals
    for (i in 0..board.lastIndex) {
        if ( (board[0][i] == board[1][i]) && board[1][i] == board[2][i] )
            if (whoWin == '_') whoWin=board[0][i]
            else return 'F'
    }

    //Check diagonals
    if ( (board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) ) {
        if (whoWin == '_') whoWin = board[1][1]
        else return 'F'
    }
    if ( (board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) ) {
        if ( whoWin == '_' ) whoWin = board[1][1]
        else return 'F'
    }

    return whoWin
}

fun getMove(board: List<CharArray>): List<Int> {
    while (true) {
        print("Enter the coordinates: ")
        val ls = readLine()!!.split(" ")
        var x: Int
        var y: Int

        if ( ls[0].first().isDigit() && ls[1].first().isDigit()) {
            x = ls[0].toInt() - 1
            y = ls[1].toInt() - 1
        }
        else {
            println("You should enter numbers!")
            continue
        }

        if ( (x !in 0..2) || (y !in 0..2) ) {
            println("Coordinates should be from 1 to 3!")
            continue
        }

        if (board[x][y] != '_') {
            println("This cell is occupied! Chose another one!")
            continue
        }

        return listOf(x,y)
    }
}

fun analyzeParty(board: List<CharArray>): Boolean {
    var result = ""

    var strRep = ""
    for (i in 0..board.lastIndex) {
        for (j in 0..board[i].lastIndex) strRep += board[i][j]
    }

    val c = isWin(board)

    if ( c in charArrayOf('X','O') ) result = "$c wins"
    else if ( '_' !in strRep ) result = "Draw"

    if (result != "") {
        println(result)
        return true
    }
    return false
}

fun renderBoard(board: List<CharArray>) {
    println("---------")

    for (i in 0 until board.size) {
        println("| ${board[i].joinToString(" ")} |")
    }
    println("---------")
}

fun inputInitialState(input: CharArray): List<CharArray> {
//    print("Enter cells: ")
//    val input= readLine()!!.toCharArray()
    val arr = listOf(
            CharArray(3),
            CharArray(3),
            CharArray(3)
    )
    for (i in 0..input.lastIndex) {
        arr[i/3][i%3]=input[i]
    }
    return arr
}

fun main() {
    val board = inputInitialState("_________".toCharArray())
    renderBoard(board)

    var round = 'X'
    while(true) {
        val xy = getMove(board)
        board[xy[0]][xy[1]] = round
        renderBoard(board)
        if (analyzeParty(board)) break
        round = if ( round == 'X' ) 'O' else 'X'
    }
}