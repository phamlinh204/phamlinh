<!DOCTYPE html>
<html>
<head>
    <title>Thuật toán Kruskal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        button {
            margin: 10px 0;
            padding: 10px 20px;
            font-size: 16px;
        }
        pre {
            border: 1px solid #ddd;
            padding: 10px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <button onclick="showResult()">Hiển thị kết quả</button>
    <pre id="result"></pre>

    <script>
        // Class UnionFind: quản lý các tập hợp không giao nhau
        class UnionFind {
            constructor(elements) {
                // Khởi tạo mỗi phần tử là một tập hợp riêng biệt
                this.parent = {};
                elements.forEach(e => (this.parent[e] = e));
            }

            // Hợp nhất hai tập hợp
            union(a, b) {
                this.parent[this.find(a)] = this.find(b);
            }

            // Tìm tập hợp chứa phần tử a
            find(a) {
                while (this.parent[a] !== a) {
                    a = this.parent[a];
                }
                return a;
            }

            // Kiểm tra xem hai phần tử có cùng tập hợp không
            connected(a, b) {
                return this.find(a) === this.find(b);
            }
        }

        // Thuật toán Kruskal để tìm cây khung nhỏ nhất
        function kruskal(graph) {
            // Sắp xếp các cạnh theo trọng số tăng dần
            graph.sort((a, b) => a.weight - b.weight);

            // Khởi tạo tập hợp các đỉnh
            const nodes = new Set(graph.map(e => [e.source, e.destination]).flat());
            const unionFind = new UnionFind(nodes);

            // Khởi tạo cây khung nhỏ nhất
            const mst = [];

            // Duyệt qua từng cạnh của đồ thị
            for (let edge of graph) {
                // Nếu hai đỉnh của cạnh không cùng tập hợp, thêm cạnh vào cây khung và hợp nhất hai tập hợp
                if (!unionFind.connected(edge.source, edge.destination)) {
                    unionFind.union(edge.source, edge.destination);
                    mst.push(edge);
                }
            }

            // Trả về cây khung nhỏ nhất
            return mst;
        }

        // Hàm hiển thị kết quả
        function showResult() {
            // Khởi tạo đồ thị
            const graph = [
                { source: 'A', destination: 'B', weight: 1 },
                { source: 'A', destination: 'C', weight: 3 },
                { source: 'B', destination: 'C', weight: 2 },
                { source: 'B', destination: 'D', weight: 5 },
                { source: 'C', destination: 'D', weight: 4 },
                { source: 'C', destination: 'E', weight: 6 },
                { source: 'D', destination: 'E', weight: 7 },
            ];

            // Tìm cây khung nhỏ nhất và hiển thị kết quả
            const result = kruskal(graph);
            document.getElementById('result').textContent = JSON.stringify(result, null, 2);
        }
    </script>
</body>
</html>