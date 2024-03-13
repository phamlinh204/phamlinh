<!DOCTYPE html>
<html>
<head>
    <title>Thuật toán DFS</title>
</head>
<body>
    <button onclick="showResult()">Hiển thị kết quả</button>
    <pre id="result"></pre>

    <script>
        // Class Graph: biểu diễn đồ thị
        class Graph {
            constructor() {
                // edges: mảng chứa các cạnh của đồ thị
                this.edges = {};
            }

            // Thêm một đỉnh vào đồ thị
            addNode(node) {
                this.edges[node] = [];
            }

            // Thêm một cạnh vào đồ thị
            addEdge(node1, node2) {
                this.edges[node1].push(node2);
                this.edges[node2].push(node1);
            }

            // Thuật toán DFS để duyệt đồ thị
            dfs(startNode) {
                const stack = [startNode];
                const visited = { [startNode]: true };
                const result = [];  // Mảng lưu các đỉnh đã duyệt

                while (stack.length > 0) {
                    const currentNode = stack.pop();
                    result.push(currentNode);  // Thêm đỉnh vào kết quả

                    const neighbors = this.edges[currentNode];
                    for (let neighbor of neighbors) {
                        if (!visited[neighbor]) {
                            stack.push(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }

                return result;  // Trả về kết quả
            }
        }

        // Hàm hiển thị kết quả
        function showResult() {
            const graph = new Graph();
            // Thêm các đỉnh vào đồ thị
            graph.addNode('A');
            graph.addNode('B');
            graph.addNode('C');
            graph.addNode('D');
            // Thêm các cạnh vào đồ thị
            graph.addEdge('A', 'B');
            graph.addEdge('A', 'C');
            graph.addEdge('B', 'C');
            graph.addEdge('C', 'D');
            // Duyệt đồ thị bắt đầu từ đỉnh 'A' và hiển thị kết quả
            const result = graph.dfs('A');
            document.getElementById('result').textContent = JSON.stringify(result, null, 2);
        }
    </script>
</body>
</html>