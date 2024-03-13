<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Knapsack Problem Solver</title>
</head>
<body>

<h1>Knapsack Problem Solver</h1>

<form id="knapsackForm">
    <label for="capacity">Capacity of Knapsack:</label>
    <input type="number" id="capacity" name="capacity" required><br><br>
    
    <label for="weights">Weights of Items (comma-separated):</label>
    <input type="text" id="weights" name="weights" required><br><br>
    
    <label for="values">Values of Items (comma-separated):</label>
    <input type="text" id="values" name="values" required><br><br>
    
    <input type="submit" value="Solve">
</form>

<div id="result"></div>

<script>
document.getElementById("knapsackForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    // Lấy dữ liệu từ form
    var capacity = parseInt(document.getElementById("capacity").value);
    var weights = document.getElementById("weights").value.split(",").map(Number);
    var values = document.getElementById("values").value.split(",").map(Number);
    
    // Gọi hàm giải quyết bài toán cái túi và hiển thị kết quả
    var maxValue = knapsack(capacity, weights, values);
    document.getElementById("result").innerHTML = "<p>Maximum value that can be achieved: " + maxValue + "</p>";
});

function knapsack(capacity, weights, values) {
    var n = weights.length;
    var table = new Array(n + 1).fill(null).map(() => new Array(capacity + 1).fill(0));

    for (var i = 1; i <= n; i++) {
        for (var j = 1; j <= capacity; j++) {
            if (weights[i - 1] <= j) {
                table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weights[i - 1]] + values[i - 1]);
            } else {
                table[i][j] = table[i - 1][j];
            }
        }
    }

    return table[n][capacity];
}
</script>

</body>
</html>
