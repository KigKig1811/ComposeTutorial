// ...
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.ui.theme.ComposeTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(horizontal = 18.dp)) {
        GreetingText()
        Spacer(modifier = Modifier.height(20.dp))
        MultipleStyleText()
    }
}

@Composable
fun GreetingText() {
    Text(
        text = stringResource(id = R.string.text_test),
        color = Color.Blue,
        fontSize = 30.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Justify,
        fontFamily = FontFamily.Cursive,
        textDecoration = TextDecoration.LineThrough,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun MultipleStyleText() {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(
            textAlign = TextAlign.End
        )) {
            append("H")
        }
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("H")
        }
        withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
            append("ello")
        }
        withStyle(style = SpanStyle(color = Color.Red)) {
            append("X")
        }
        append("T")
    })
}

val customStyle: TextStyle
    get() = TextStyle(
        color = Color.Red
    )

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        HomeScreen()
    }
}

  