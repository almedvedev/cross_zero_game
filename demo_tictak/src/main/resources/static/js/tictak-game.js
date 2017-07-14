var currentGameId;

$(document).ready(function () {
    newGame();
});

function showButtonNewGame() {
    document.getElementById("new_game").style.visibility = "visible";
}

function newGame() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/new_game",
        data: "Start new game",
        cache: false,
        timeout: 60000,
        success: function (data) {
            var game = JSON.parse(data);
            console.log("SUCCESS : ", data);
            currentGameId = game.id;
            drawEmptyBoard();
            setTurnTaker(game.turnTaker.mark);
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
        var postAction = {"postAction": "Make bot turn", "id": currentGameId};
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/make_bot_turn",
            data: JSON.stringify(postAction),
            cache: false,
            timeout: 60000,
            success: function (data) {
                var game = JSON.parse(data);
                console.log(game);
                makeTurn(game.board.cells);
                if (game.status == "GAME_OVER") {
                    clearInterval(botTimer);
                    var gameOverCondition = game.gameOver.gameOverCond;
                    if (gameOverCondition === "NONE" || gameOverCondition === "DRAW") {
                        setTurnTaker("Game ends with a draw");
                    } else {
                        setTurnTaker("Player " +
                            (game.gameOver.winner.mark == "CROSS" ? "x" : "o") +
                            (gameOverCondition == "WON_WITH_HORIZONTAL_LINE" ? " won with horizontal line" :
                                (gameOverCondition == "WON_WITH_VERTICAL_LINE" ? " won with vertical line" :
                                    " won with diagonal line ")));
                    }
                    showButtonNewGame();
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
