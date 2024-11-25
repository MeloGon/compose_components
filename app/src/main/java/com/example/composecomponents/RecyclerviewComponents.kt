package com.example.composecomponents

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecomponents.data.SuperHero
import kotlinx.coroutines.launch

@Composable
fun SuperHeroView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) {
            ItemHero(it) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superHero) }) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )
        }
    }
}

fun getSuperheroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}

@Composable
fun SuperHeroGridView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(vertical = 4.dp, horizontal = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 6.dp),
        verticalArrangement = Arrangement.spacedBy(space = 6.dp),
        content = {
            items(getSuperheroes()) {
                ItemHero(it) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    )

}

@Composable
fun SuperHeroWithEspecialControls(modifier: Modifier = Modifier) {
    val rvState = rememberLazyListState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperheroes()) {
                ItemHero(it) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        // muestra el boton despues de haber pasado el primer item
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if (showButton) {
            Button(onClick = {
                //lleva al primer item
                coroutineScope.launch {
                    rvState.animateScrollToItem(0);
                }

            }) {
                Text(text = "Soy un boton")
            }
        }


    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val superHero: Map<String, List<SuperHero>> = getSuperheroes().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        superHero.forEach { (publisher, mySuperHero) ->
            stickyHeader {
                Text(text = publisher)
            }
            items(mySuperHero) {
                ItemHero(it) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}