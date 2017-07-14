$(document).ready(function () {
    newGame();
});

function newGame() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/new_game",
        data: "Start new game",
        cache: false,
        timeout: 60000,
        success: function (data) {
            console.log("SUCCESS : ", data);
            drawEmptyBoard();
            setTurnTaker(JSON.parse(data).turnTaker.mark);
            startGame();
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}

function setTurnTaker(turnTaker) {
    $("#turn_taker")[0].innerHTML = turnTaker;
}

function startGame() {
    var botTimer = setInterval(function () {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/make_bot_turn",
            data: "Make bot turn",
            cache: false,
            timeout: 60000,
            success: function (data) {
                var game = JSON.parse(data);
                console.log(game);
                makeTurn(game.board.cells);
                if (game.status == "GAME_OVER") {
                    clearInterval(botTimer);
                    setTurnTaker("Winner: " + game.gameOver.winner.mark);
                    return;
                } else {
                    setTurnTaker(game.turnTaker.mark);
                }

            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    }, 2000);

    setTimeout(function () {
        clearInterval(botTimer);
        alert("Game finished");
    }, 19000);
}

function makeTurn(board) {
    for (var i = 0; i < 3; i++) {
        for (var j = 0; j < 3; j++) {

            var rowSelector = "tr[row=" + i + "]";
            var colSelector = "td[col=" + j + "]";
            var cell = $(rowSelector + " " + colSelector)[0];

            if (board[i][j].state != "EMPTY" && cell.innerHTML == "") {
                cell.innerHTML = board[i][j].state == "CROSS" ? "x" : "o";
            }
        }
    }
}

function drawEmptyBoard() {
    var board = '';
    for (var i = 0; i < 3; i++) {
        board += '<tr row="' + i + '">';
        for (var j = 0; j < 3; j++) {
            board += '<td class="tictak_cell" col="' + j + '"></td>';
        }
        board += '</tr>';
    }
    $('#tictak_table').append(board);
}
