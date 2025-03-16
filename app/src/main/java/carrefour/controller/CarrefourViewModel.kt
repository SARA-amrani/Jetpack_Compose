package carrefour.controller

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import carrefour.state.CarrefourState
import feu3.state.Feu3StateV2

class CarrefourViewModel:ViewModel(){
    //singleton contenant l'état,observable mais privé
    private val _state = mutableStateOf(CarrefourState())
    //getter pour consulter cet état à l'extérieur de cette classe,mais setter privé
    var state
        get()=_state.value
        private set(newstate){
            _state.value=newstate
    }
    init{
        state=CarrefourState() //constructeur état initial
    }
    ///méthodes pour modifier les données
    fun suivant(){
        // règles de fonctionnement du carrefour
        val currentState = state
        val currentFeu = currentState.feuCourant

        // Logique de changement de couleur pour le feu courant
        val newState = when (currentFeu.couleur) {
            Feu3StateV2.ROUGE -> {
                currentState.copyChangeCouleurCourant(Feu3StateV2.VERT)
            }
            Feu3StateV2.VERT -> {
                currentState.copyChangeCouleurCourant(Feu3StateV2.ORANGE)
            }
            Feu3StateV2.ORANGE -> {
                val nextFeu = (currentState.courant + 1) % 4 // Passer au feu suivant (cycle des 4 feux)
                currentState.copyChangeCourant(nextFeu)
                    .copyChangeCouleurCourant(Feu3StateV2.ROUGE)
            }
        }
        state = newState

    }
}