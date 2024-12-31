package com.devspacecomposeinit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devspacecomposeinit.model.Artist
import com.devspacecomposeinit.ui.theme.ComposeInitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeInitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val leonardo = Artist(
                        name = "Leonardo da Vinci",
                        lastSeeOnline = "3 minutes ago",
                        imageAutor = R.drawable.ic_leonardo_da_vinci,
                        imagePicture = R.drawable.ic_mona_lisa
                    )
                    val picasso = Artist(
                        name = "Pablo Picasso",
                        lastSeeOnline = "5 minutes ago",
                        imageAutor = R.drawable.ic_pablo_picasso,
                        imagePicture = R.drawable.ic_beijo
                    )
                    val salvador = Artist(
                        name = "Salvador Dali",
                        lastSeeOnline = "7 minutes ago",
                        imageAutor = R.drawable.ic_salvador_dali,
                        imagePicture = R.drawable.ic_persistence_of_memory
                    )
                    val vanGogh = Artist(
                        name = "Vincent Van Gogh",
                        lastSeeOnline = "10 minutes ago",
                        imageAutor = R.drawable.ic_vincent_van_gogh,
                        imagePicture = R.drawable.ic_starry_night
                    )
                    val listaArtists = listOf(leonardo,picasso,salvador,vanGogh)
                    LazyColumn {
                        items(listaArtists){
                            ArtistCardColumn(artist = it, onItemClick = {
                                Toast.makeText(this@MainActivity, "Pintura de ${it.name}", Toast.LENGTH_SHORT).show()
                            } )
                        }
                    }

                }
            }
        }
    }
}



@Composable
fun ArtistCardColumn(artist: Artist, onItemClick: () -> Unit ) {
    Column(
        Modifier
            .padding(8.dp)
            .clickable(onClick = onItemClick)
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                painter = painterResource(id = artist.imageAutor),
                contentScale = ContentScale.FillWidth,
                contentDescription = "ImageArtist")
            Spacer(Modifier.size(16.dp))
            Column {
                Text(artist.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                    )
                Text(artist.lastSeeOnline,
                    color = Color.Gray
                    )
            }
        }
        Card(
            modifier = Modifier.padding(top = 16.dp),
            elevation = CardDefaults.elevatedCardElevation(3.dp)
            ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(artist.imagePicture), contentDescription =  "Artist" )
        }
    }
}



