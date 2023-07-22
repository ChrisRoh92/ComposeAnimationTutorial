package de.codingwithchris.composeanimationtutorial

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
    // TODO: Implement!
}

@Composable
fun CrossFadeAnimation(modifier: Modifier = Modifier)
{
    // TODO: Implement!
}

@Composable
fun ExpandAndCollapseAnimation(modifier: Modifier = Modifier)
{
    // TODO: Implement!
}
