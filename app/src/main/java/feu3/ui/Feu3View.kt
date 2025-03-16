package feu3.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import feu3.controller.Feu3ViewModel
import feu3.state.Feu3State

// Fonction principale composable qui gère l'affichage de l'UI
@Composable
fun MainActivityFeu3View(viewmodel: Feu3ViewModel = viewModel()) {
    // On récupère l'état actuel du feu à partir du ViewModel
    val state = viewmodel.state

    // Structure de mise en page (une colonne) pour centrer le contenu
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        //modifier = Modifier.fillMaxSize() // Remplir tout l'écran
    ) {
        // Affichage de l'état du feu (version 1)
        Feu3ViewV1(state, modifier = Modifier.padding(16.dp))

        // bouton,
        Button(
            onClick={
                viewmodel.suivant() //modif par le contrôleur
            },
            modifier=Modifier.fillMaxWidth().padding(32.dp)
        ){
            Text(text="état suivant")
        }

        // Affichage de la deuxième et troisième vue
       // Feu3ViewV2(state, modifier = Modifier.padding(16.dp))
       // Feu3ViewV3(state, modifier = Modifier.padding(16.dp))
    }

}



// Fonction composable pour afficher l'état actuel du feu (couleur)
@Composable
fun Feu3ViewV1(state: Feu3State, modifier: Modifier = Modifier) {
    // Affichage du nom de la couleur actuelle du feu
    Text(
        text = "Feu ${state.nomCouleur}",
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
    )
}

// une deuxsième visualisation
/*@Composable
fun Feu3ViewV2(state:Feu3State,modifier:Modifier=Modifier){
    Column(
        modifier.wrapContentSize()
    ){
        //feu rouge
        Row(Modifier.align(Alignment.Start).padding(horizontal=16.dp)){
            RadioButton(
                selected=state.rouge,
                onClick= { viewModel.state = state.copyChangeCouleur(FeuCouleur.ROUGE) }  //non réactif
            )
            Text(
                text="Rouge",
                modifier=Modifier.padding(start=16.dp)
            )
        }
        //feu vert
        Row(Modifier.align(Alignment.Start).padding(horizontal=16.dp)){
            RadioButton(
                selected=state.orange,
                onClick= { state = state.copyChangeCouleur(FeuCouleur.ORANGE) }  //non réactif
            )
            Text(
                text="Orange",
                modifier=Modifier.padding(start=16.dp)
            )
        }
        //feu orange
        Row(Modifier.align(Alignment.Start).padding(horizontal=16.dp)){
            RadioButton(
                selected=state.vert,
                onClick= {  state = state.copyChangeCouleur(FeuCouleur.VERT)} //non réactif
            )
            Text(
                text="VERT",
                modifier=Modifier.padding(start=16.dp)
            )
        }

    }
}
// une troisième visualisation
@Composable
fun Feu3ViewV3(state: Feu3State, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .wrapContentSize(Alignment.Center)) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp, 128.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.DarkGray)
        ){
            Column {
                Feu(Color.Red,
                    state.rouge)
                Feu(Color.Green, state.vert)
                Feu(Color.Orange, state.orange)
            }
        }
    }
}
/**
 *dessine un disque coloré ou gris selon isOn
 */
@Composable
fun Feu(color: Color, isOn: Boolean, modifier: Modifier = Modifier) {
    Canvas(
        modifier = Modifier.size(40.dp).padding(4.dp),
        onDraw = {
            drawCircle(color = if (isOn) color else Color.Gray)
        }
    )
}
// définit la couleur Color.Orange par une extension de la classe Color
private val Color.Companion.Orange: Color
    get() = hsv(33.0f, 1.0f, 1.0f)

@Preview(showBackground = true)
@Composable
fun Feu3ViewV3Preview() {
    // une seule des deux lignes suivantes, soit V1, soit V2 (voir § état second)
    Feu3ViewV3(state = Feu3State(false, true, false))  // pour la V1

//Feu3ViewV3(state = Feu3State(FeuCouleur.ORANGE)) // pour la V2
} */