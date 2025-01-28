package com.jubayer_ahamad_tayef.lazy_column_practice_in_jetpack_compose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import com.jubayer_ahamad_tayef.lazy_column_practice_in_jetpack_compose.model.Person

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CustomItem(person: Person) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ), contentAlignment = Alignment.Center
        ) {
            val painter = rememberImagePainter(
                data = person.imageUrl,
                builder = {
                    placeholder(drawableResId = R.drawable.men_image_placeholder)
                    error(drawableResId = R.drawable.ic_info)
                    crossfade(durationMillis = 1000)
                    transformations(
                        CircleCropTransformation(), BlurTransformation(context = LocalContext.current)
                    )
                }
            )

            val painterState = painter.state

            Image(
                painter = painter,
                contentDescription = "Person Icon",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            if (painterState is ImagePainter.State.Loading)
                CircularProgressIndicator(
                    modifier = Modifier.size(40.dp),
                    color = Color.Black,
                    strokeWidth = 5.dp,
                    strokeCap = StrokeCap.Round
                )

        }
        Column {
            Text(
                text = "Name: ${person.firstName} ${person.lastName}",
                color = Color.Black,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Age: ${person.age}",
                color = Color.Black,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    CustomItem(
        person = Person(
            id = 1,
            firstName = "Jubayer",
            lastName = "Ahamad Tayef",
            age = 20,
            imageUrl = ""
        )
    )
}