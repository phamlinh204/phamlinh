<!DOCTYPE html>
<html>
<head>
    <title>Dijkstra's Algorithm</title>
</head>
<body>
    <button onclick="showResult()">Hiển thị kết quả</button>
    <pre id="result"></pre>

    <script>
        // Class PriorityQueue: hàng đợi ưu tiên để quản lý các đỉnh
        class PriorityQueue {
            constructor() {
                this.items = [];  // Mảng chứa các đỉnh
            }

            // Thêm một đỉnh vào hàng đợi với mức độ ưu tiên tương ứng
            enqueue(item, priority) {
                this.items.push({ item, priority });
                this.items.sort((a, b) => a.priority - b.priority);
            }

            // Lấy ra đỉnh có mức độ ưu tiên cao nhất
            dequeue() {
                return this.items.shift().item;
            }

            // Kiểm tra xem hàng đợi có rỗng không
            isEmpty() {
                return this.items.length === 0;
            }
        }

        // Class Graph: biểu diễn đồ thị
        class Graph {
            constructor() {
                this.nodes = new Map();  // Mảng chứa các đỉnh của đồ thị
            }

            // Thêm một đỉnh vào đồ thị
            addNode(node) {
                this.nodes.set(node, []);
            }

            // Thêm một cạnh vào đồ thị
            addEdge(node1, node2, weight) {
                this.nodes.get(node1).push({ node: node2, weight });
                this.nodes.get(node2).push({ node: node1, weight });
            }

            // Thuật toán Dijkstra để tìm đường đi ngắn nhất từ startNode đến endNode
            dijkstra(startNode, endNode) {
                const distances = new Map();
                const previous = new Map();
                const priorityQueue = new PriorityQueue();

                for (const node of this.nodes.keys()) {
                    distances.set(node, node === startNode ? 0 : Infinity);
                    priorityQueue.enqueue(node, distances.get(node));
                    previous.set(node, null);
                }

                while (!priorityQueue.isEmpty()) {
                    const currentNode = priorityQueue.dequeue();

                    if (currentNode === endNode) {
                        const path = [];
                        let current = endNode;

                        while (current !== null) {
                            path.unshift(current);
                            current = previous.get(current);
                        }

                        return path;
                    }

                    const neighbors = this.nodes.get(currentNode);

                    for (const neighbor of neighbors) {
                        const newDistance = distances.get(currentNode) + neighbor.weight;

                        if (newDistance < distances.get(neighbor.node)) {
                            distances.set(neighbor.node, newDistance);
                            previous.set(neighbor.node, currentNode);
                            priorityQueue.enqueue(neighbor.node, newDistance);
                        }
                    }
                }

                return null;  // Không tìm thấy đường đi
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
            graph.addNode('E');

            // Thêm các cạnh vào đồ thị
            graph.addEdge('A', 'B', 1);
            graph.addEdge('A', 'C', 3);
            graph.addEdge('B', 'C', 1);
            graph.addEdge('B', 'D', 3);
            graph.addEdge('C', 'D', 1);
            graph.addEdge('C', 'E', 2);
            graph.addEdge('D', 'E', 3);

            const result = graph.dijkstra('A', 'E');
            document.getElementById('result').textContent = JSON.stringify(result, null, 2);
        }
    </script>
</body>
</html>