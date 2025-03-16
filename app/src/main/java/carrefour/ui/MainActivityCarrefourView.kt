package carrefour.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import carrefour.controller.CarrefourViewModel
import carrefour.state.CarrefourState
import feu3.state.Feu3State
import feu3.state.Feu3StateV2

@Composable
fun MainActivityCarrefourView(viewmodel: CarrefourViewModel = viewModel()) {
    // Récupérer l'état du carrefour depuis le ViewModel
    val state = viewmodel.state

    // Structure de mise en page (une colonne) pour centrer le contenu
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        // Affichage du carrefour
        CarrefourView(state = state, modifier = Modifier.padding(16.dp))

        // Bouton pour passer au feu suivant
        Button(
            onClick = { viewmodel.suivant() }, // Appeler la méthode du ViewModel pour passer au feu suivant
            modifier = Modifier.fillMaxWidth().padding(32.dp)
        ) {
            Text(text = "Feu suivant")
        }
    }
}

@Composable
fun CarrefourView(state: CarrefourState, modifier: Modifier = Modifier, size: Dp = 180.dp) {
    Box(
        modifier.fillMaxWidth().padding(60.dp)
    ) {
        val mod = Modifier.scale(0.5f).align(Alignment.Center)

        // Affichage des 4 feux (chaque feu sera placé avec un offset différent)
        Feu3ViewV3(state = state.feux[0], modifier = mod.offset(y = -size))
        Feu3ViewV3(state = state.feux[1], modifier = mod.offset(x = size))
        Feu3ViewV3(state = state.feux[2], modifier = mod.offset(y = size))
        Feu3ViewV3(state = state.feux[3], modifier = mod.offset(x = -size))
    }
}

@Composable
fun Feu3ViewV1(state: Feu3State, modifier: Modifier = Modifier) {
    Text(
        text = "Feu ${state.nomCouleur}",
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
    )
}

@Composable
fun Feu3ViewV3(state: Feu3State, modifier: Modifier = Modifier) {
    Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp, 128.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.DarkGray)
        ) {
            Column {
                Feu(Color.Red, state.rouge)
                Feu(Color.Green, state.vert)
                Feu(Color(0xFFFFA500), state.orange) // Utilisation de l'orange correctement définie
            }
        }
    }
}
@Composable
fun Feu(color: Color, isOn: Boolean, modifier: Modifier = Modifier) {
    Canvas(
        modifier = Modifier.size(40.dp).padding(4.dp),
        onDraw = {
            drawCircle(color = if (isOn) color else Color.Gray)
        }
    )
}




@Preview(showBackground = true)
@Composable
fun CarrefourPreview() {
    // Exemple d'état initial pour la prévisualisation
    CarrefourView(
        state = CarrefourState(
            courant = 1, // Feu 1 est le courant (vert)
            feux = arrayOf(
                Feu3State(), // Feu 0 rouge
                Feu3State(Feu3StateV2.VERT), // Feu 1 vert
                Feu3State(), // Feu 2 rouge
                Feu3State() // Feu 3 rouge
            )
        )
    )
}
