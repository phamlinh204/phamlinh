<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Permutations of "BOOK"</title>
<script>
// Hàm để hoán vị các ký tự trong từ
function permute(str, prefix = '', results = []) {
    if (str.length === 0) {
        results.push(prefix);
    } else {
        for (let i = 0; i < str.length; i++) {
            let char = str[i];
            let rest = str.substring(0, i) + str.substring(i + 1);
            permute(rest, prefix + char, results);
        }
    }
    return results;
}

// Hàm xử lý khi nhấn nút "Liệt kê hoán vị"
function handlePermutations() {
    const word = "BOOK";
    const permutations = permute(word);
    const output = document.getElementById('output');
    output.innerHTML = "Các hoán vị của từ 'BOOK':<br>" + permutations.join("<br>");
}
</script>
</head>
<body>
    <h1>Permutations of "BOOK"</h1>
    <button onclick="handlePermutations()">Liệt kê hoán vị</button>
    <div id="output"></div>
</body>
</html>