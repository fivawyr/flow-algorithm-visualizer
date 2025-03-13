import java.util.PriorityQueue

object Dijkstra {
    fun findShortestPath(graph: Graph, start: Node): Map<Node, Double> {
        val distance = mutableMapOf<Node, Double>().apply {
            graph.nodes.forEach { node ->
                this[node] = Double.POSITIVE_INFINITY
            }
            this[start] = 0.0
        }

        val priorityQueue = PriorityQueue<Node>(compareBy { distance[it] }).apply {
            add(start)
        }

        while (priorityQueue.isNotEmpty()) {
            val current = priorityQueue.poll()
            graph.getAdjacencyNodes(current).forEach { edge ->
                val neighbor = if (edge.from == current) edge.to else edge.from
                val newDistance = distance[current]!! + edge.weight

                if (newDistance < distance[neighbor]!!) {
                    distance[neighbor] = newDistance
                    priorityQueue.add(neighbor)
                }
            }
        }

        return distance
    }
}