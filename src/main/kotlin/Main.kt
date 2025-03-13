import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.remember
import model.Graph
import model.Node
import ui.components.GraphCanvas

fun main() = Window {
    val graph = remember {
        Graph().apply {
            val nodeA = Node("A", 100f, 100f)
            val nodeB = Node("B", 300f, 100f)
            val nodeC = Node("C", 200f, 300f)

            addNode(nodeA)
            addNode(nodeB)
            addNode(nodeC)

            addEdge(nodeA, nodeB, 5.0)
            addEdge(nodeB, nodeC, 3.0)
            addEdge(nodeA, nodeC, 10.0)
        }
    }
    MatieralTheme {
        Surface {
            GraphCanvas(graph)
        }
    }
}