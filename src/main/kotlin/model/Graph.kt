class Graph(
    val nodes: MutableList<Node> = mutableListOf(),
    val edges: MutableList<Edge> = mutableListOf()
) {
    fun addNode(node: Node) { 
        nodes.add(node)
     }
    fun addEdge(edge: Edge) { 
        edges.add(edge)
     }
    fun getAdjacencyNodes(node: Node): List<Node> {
        return edges
            .filter { it.from == node }
            .map { it.to }
      }
    fun getEdge(from: Node, to: Node): Edge? {
        return edges.find { it.from == from && it.to == to }
      }
}

