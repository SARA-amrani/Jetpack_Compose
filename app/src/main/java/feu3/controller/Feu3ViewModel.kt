package feu3.controller

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import feu3.state.Feu3State
import feu3.state.Feu3StateV2

class Feu3ViewModel:ViewModel(){
    //singleton contenant l'état, observable mais privé
    private val _state = mutableStateOf(Feu3State())
    //getter pour consulter cet état à l'extérieur de cette classe, mais setter privé
    var state
        get()=_state.value //_state.value = instance de Feu3State
        private set(newstate){
            _state.value=newstate //remplace l'état par le nouveau
    }
    init{
        reset()
    }
    ///méthodes pour modifier les données
    fun reset(){
        state = Feu3State(couleur = Feu3StateV2.ROUGE)
    }
    fun suivant() {
        state = when (state.couleur) {
            Feu3StateV2.ROUGE -> state.copyChangeCouleur(Feu3StateV2.ORANGE)
            Feu3StateV2.ORANGE -> state.copyChangeCouleur(Feu3StateV2.VERT)
            Feu3StateV2.VERT -> state.copyChangeCouleur(Feu3StateV2.ROUGE)
        }
    }
}