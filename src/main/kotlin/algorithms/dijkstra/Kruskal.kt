package algorithns.kruskal

import model.Edge
import model.Graph

object Kruskal {
    fun findMinSpanningTree(graph: Graph): List<Edge> {
        val sortedEdges = graph.edges.sortedBy{ it.weight}
        val parent = mutableMapOf<Node, Node>()
        val rank = mutableMapOf<Node, Int>()
        val result = mutableListOf<Edge>()

        graph.Node.forEach { node ->
            parent[node] = node
            rank[node] = 0
        }

        for (edge in sortedEdges) {
            val rootX = find(parent, edge.form)
            val rootY = find(parent, edge.to)

            if (rootX != rootY) {
                result.add(edge)
                union(parent, rank, rootX, rootY)
            }
        }

        return emptyList()
    }

    private fun fing(parent: mutableMap<Node, Node>, node: Node): Node {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]!!)
        }
        return node
    }

    private fun union(parent: mutableMap<Node, Node>, rank: mutableMap<Node, Int>, x: Node, y: Node) {
        val rootX = find(parent, x)
        val rootY = find(parent, y)

        when {
            rank[rootX]!! > rank[rootY]!! -> parent[rootY] = rootX
            rank[rootX]!! < rank[rootY]!! -> parent[rootX] = rootY
            else -> {
                parent[rootY] = rootX
                rank[rootX] = rank[rootX]!! + 1
            }
        }
    }
}