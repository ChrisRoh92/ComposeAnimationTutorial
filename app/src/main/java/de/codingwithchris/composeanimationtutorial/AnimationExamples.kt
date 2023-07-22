package de.codingwithchris.composeanimationtutorial

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp


// Slide-In Animation Code Snippet
@Composable
fun SlideInAnimation(
    modifier: Modifier = Modifier
) {
    var isVisible by remember { mutableStateOf(false) }

    val slideInOffset = animateDpAsState(
        targetValue = if (isVisible) 0.dp else 200.dp,
        animationSpec = tween(durationMillis = 500)
    ).value

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { isVisible = !isVisible },
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = if (isVisible) "Hide" else "Show")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .offset(x = slideInOffset)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Slide In Content", color = Color.White)
        }
    }
}


@Composable
fun PulsatingAnimation(modifier: Modifier = Modifier)
{
    var isPulsating by remember { mutableStateOf(false) }

    val pulseAnimation = animateFloatAsState(
        targetValue = if (isPulsating) 1.2f else 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    ).value

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { isPulsating = !isPulsating },
            shape = CircleShape,
            modifier = Modifier
                .size(100.dp)
                .graphicsLayer(scaleX = pulseAnimation, scaleY = pulseAnimation)
        ) {
            Text(text = "Tap me")
        }
    }

}

@Composable
fun CrossFadeAnimation(modifier: Modifier = Modifier)
{
    var isToggled by remember { mutableStateOf(false) }

    val fadeInOutAlpha = animateFloatAsState(
        targetValue = if (isToggled) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    ).value

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { isToggled = !isToggled },
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = "Toggle")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(1f - fadeInOutAlpha),
                shape = RoundedCornerShape(16.dp),
            ) {
                // Content of the first view
                Text(
                    text = "View 1",
                    modifier = Modifier.padding(16.dp)
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(fadeInOutAlpha),

                shape = RoundedCornerShape(16.dp),
            ) {
                // Content of the second view
                Text(
                    text = "View 2",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun ExpandAndCollapseAnimation(modifier: Modifier = Modifier)
{
    // TODO: Implement!
}
