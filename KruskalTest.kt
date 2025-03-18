package algorithm.kruskal

import model.Edge
import model.Graph
import model.Node
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KruskalTest {
    @Test
    fun testMinimumSpanningTree() {
        val graph = Graph()
        val nodeA = Node("A", 0f, 0f)
        val nodeB = Node("B", 0f, 0f)
        val nodeC = Node("C", 0f, 0f)

        graph.addNode(nodeA)
        graph.addNode(nodeB)
        graph.addNode(nodeC)

        graph.addEdge(Edge(nodeA, nodeB, 1.0))
        graph.addEdge(Edge(nodeB, nodeC, 2.0))
        graph.addEdge(Edge(nodeA, nodeC, 3.0))

        val result = Kruskal.findMinimumSpanningTree(graph)

        assertEquals(2, result.size)
        assertEquals(1.0, result[0].weight)
        assertEquals(2.0, result[1].weight)
    }
}