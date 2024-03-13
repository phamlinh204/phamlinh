<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bài Toán Tồn Tại</title>
    <style>
        .board {
            display: grid;
            grid-template-columns: repeat(10, 40px); /* Thay đổi số cột tùy theo kích thước bàn cờ */
            gap: 1px;
            background-color: #ccc;
            margin-top: 20px;
        }
        .square {
            width: 40px; /* Điều chỉnh kích thước ô */
            height: 40px; /* Điều chỉnh kích thước ô */
            background-color: white;
            border: 1px solid black;
            text-align: center;
            line-height: 40px; /* Để căn giữa nội dung */
            font-size: 24px; /* Điều chỉnh kích thước chữ */
        }
    </style>
</head>
<body>
    <h1>Bài Toán Tồn Tại</h1>
    <button onclick="tinhToHopVaHienThi()">Tính và Hiển Thị</button>
    <p id="ketQua"></p>
    <div class="board" id="chessboard"></div>

    <script>
        function solveNQueens(boardSize) {
            const board = Array.from({ length: boardSize }, () => Array(boardSize).fill(0));
            const solutions = [];

            function isSafe(row, col) {
                for (let i = 0; i < row; i++) {
                    if (board[i][col] === 1) {
                        return false;
                    }

                    // Kiểm tra đường chéo trái lên
                    if (col - row + i >= 0 && board[i][col - row + i] === 1) {
                        return false;
                    }

                    // Kiểm tra đường chéo phải lên
                    if (col + row - i < boardSize && board[i][col + row - i] === 1) {
                        return false;
                    }
                }

                return true;
            }

            function solveRow(row) {
                if (row === boardSize) {
                    solutions.push([...board.map(row => [...row])]);
                    return;
                }

                for (let col = 0; col < boardSize; col++) {
                    if (isSafe(row, col)) {
                        board[row][col] = 1;
                        solveRow(row + 1);
                        board[row][col] = 0;
                    }
                }
            }

            solveRow(0);
            return solutions;
        }

        function tinhToHopVaHienThi() {
            const boardSize = 10;
            const solutions = solveNQueens(boardSize);

            const ketQuaElement = document.getElementById("ketQua");
            const chessboardElement = document.getElementById("chessboard");

            if (solutions.length > 0) {
                ketQuaElement.innerHTML = "Một cách xếp quân hậu đã được hiển thị trên bàn cờ.";
                const formattedSolution = solutions[0];

                // Clear chessboard
chessboardElement.innerHTML = '';

                // Populate chessboard with queens
                for (let i = 0; i < boardSize; i++) {
                    const rowElement = document.createElement('div');
                    rowElement.classList.add('board-row');

                    for (let j = 0; j < boardSize; j++) {
                        const square = document.createElement('div');
                        square.classList.add('square');
                        if (formattedSolution[i][j] === 1) {
                            square.innerText = '♛'; // Ký hiệu quân hậu
                        }
                        rowElement.appendChild(square);
                    }

                    chessboardElement.appendChild(rowElement);
                }
            } else {
                ketQuaElement.innerHTML = "Không có cách xếp quân hậu cho bàn cờ " + boardSize + " x " + boardSize;
            }
        }
    </script>
</body>
</html>