import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp

@Composable
fun GraphCanvas( 
    graph: Graph
    modifer: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        graph.edges.forEach { edge ->
            drawLine(
                color = if (edge.isShortest) Color.Red else Color.Black,
                start = Offset(edge.from.x.toFloat(), edge.from.y.toFloat()),
                end = Offset(edge.x.toFloat(), edge.y.toFloat()),
                strokeWidth = 2.dp.toPx()
            )
        }

        graph.nodes.forEach { node ->
            drawCircle(
                color = Color.Blue,
                radius = 20f,
                center = Offset(node.x.toFloat(), node.y.toFloat())
            )
        }
    }
}