$(document).ready(function () {
    loadBoard();
});

function loadBoard() {

    var search = "search";

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/board",
        data: search,
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("SUCCESS : ", data);
            drawBoard(JSON.parse(data).boardState);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}

function drawBoard(data) {
    var board = '';
    for (var i = 0; i < 3; i++) {
        board += '<tr row="' + i + '">';
        for (var j = 0; j < 3; j++) {
            board += '<td class="tictak_cell" col="' + j + '">' + data[i][j] + '</td>';
        }
        board += '</tr>';
    }

    $('#tictak_table').append(board);

    $('.tictak_cell').on('click', function (event) {
        event.target.innerText = "o";
    });
}
