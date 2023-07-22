package de.codingwithchris.composeanimationtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.codingwithchris.composeanimationtutorial.ui.theme.ComposeAnimationTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MainContent()
                }
            }
        }
    }
}

enum class Content
{
    PULSATING_BUTTON,
    CROSS_FADE_ANIMATION,
    EXPAND_COLLAPSE_ANIMATION,
    SLIDE_IN_ANIMATION,
    OTHER_ANIMATION
}

@Composable
fun MainContent()
{
    var selectedAnimation by remember {
        mutableStateOf(Content.SLIDE_IN_ANIMATION)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ButtonBar(onClickListener = {
            selectedAnimation = it
        })

        when(selectedAnimation)
        {
            Content.PULSATING_BUTTON -> PulsatingAnimation(Modifier.weight(1f))
            Content.CROSS_FADE_ANIMATION -> CrossFadeAnimation(Modifier.weight(1f))
            Content.EXPAND_COLLAPSE_ANIMATION -> ExpandAndCollapseAnimation(Modifier.weight(1f))
            Content.SLIDE_IN_ANIMATION -> SlideInAnimation(Modifier.weight(1f))
            else -> Text("Error")
        }
    }
}

@Composable
fun ButtonBar(
    onClickListener: (Content) -> Unit,
    modifier: Modifier = Modifier)
{
    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Button(onClick = {onClickListener(Content.PULSATING_BUTTON)}) {
            Text("PulsatingButton")
        }
        Spacer(Modifier.padding(horizontal = 4.dp))
        Button(onClick = {onClickListener(Content.CROSS_FADE_ANIMATION)}) {
            Text("CrossFadeIn")
        }
        Spacer(Modifier.padding(horizontal = 4.dp))
        Button(onClick = {onClickListener(Content.EXPAND_COLLAPSE_ANIMATION)}) {
            Text("ExpandCollapse")
        }
        Spacer(Modifier.padding(horizontal = 4.dp))
        Button(onClick = {onClickListener(Content.SLIDE_IN_ANIMATION)}) {
            Text("SlideInAnimation")
        }
    }
}
