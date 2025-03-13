import model.Edge
import model.Graph
import model.Node
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DijkstraTest {
    @Test
    fun testShortestPath() {
        val graph = Graph()
        val nodeA = Node("A", 0f, 0f)
        val nodeB = Node("B", 0f, 0f)
        val nodeC = Node("C", 0f, 0f)

        graph.addNode(nodeA)
        graph.addNode(nodeB)
        graph.addNode(nodeC)

        graph.addEdge(Edge(nodeA, nodeB, 5.0))
        graph.addEdge(Edge(nodeB, nodeC, 3.0))
        graph.addEdge(Edge(nodeA, nodeC, 10.0))

        val distances = Dijkstra.findShortestPath(graph, nodeA)

        assertEquals(0.0, distances[nodeA])
        assertEquals(5.0, distances[nodeB])
        assertEquals(8.0, distances[nodeC])
    }
}

