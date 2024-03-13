<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Chọn Áo và Quần</title>
</head>
<body>
<h3>Số cách chọn áo và quần</h3>
<button onclick="calculate()">Tính toán</button> <!-- Khi nhấn nút, gọi hàm tính toán -->
<div id="result"></div> <!-- Phần tử HTML để hiển thị kết quả -->
<style>
body {
font-family: Arial, sans-serif;
background-color: #f0f0f0;
padding: 20px;
}
h3 {
color: #333;
text-align: center;
}
button {
display: block;
width: 200px;
height: 40px;
margin: 20px auto;
background-color: #007BFF;
color: #fff;
border: none;
border-radius: 5px;
cursor: pointer;
}
button:hover {
background-color: #0056b3;
}
#result {
width: 80%;
margin: 0 auto;
padding: 20px;
background-color: #fff;
border-radius: 5px;
box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
text-align: center;
font-size: 20px;
color: #333;
}
</style>
<script>
// Hàm tính số cách chọn áo và quần
function calculate() {
var numShirts = 5; // Số màu áo
var numPants = 4; // Số màu quần
var total = numShirts * numPants; // Tính tổng số cách chọn
var resultDiv = document.getElementById('result'); // Lấy phần tử HTML để hiển thị kết quả
resultDiv.innerHTML = 'Có ' + total + ' cách chọn áo và quần.'; // Hiển thị kết quả
}
</script>
</body>
</html>