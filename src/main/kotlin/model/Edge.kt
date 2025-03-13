data class Edge(
    val from: Node, 
    val to: Node,
    val weight: Double,
    val isHighlighted: Boolean = false
)