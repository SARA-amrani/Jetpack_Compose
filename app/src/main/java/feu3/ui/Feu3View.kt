package feu3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
