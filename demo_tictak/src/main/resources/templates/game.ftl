<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div id="turn_taker"></div>
<div class="tictak_container">
    <table id='tictak_table'>
    </table>
</div>
<form class="start_form" id="new_game" action="/game">
    <input type="submit" value="new game"/>
</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/tictak-game.js"></script>
</html>