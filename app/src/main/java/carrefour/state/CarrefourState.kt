package carrefour.state

import feu3.state.Feu3State
import feu3.state.Feu3StateV2

@Suppress("ArrayInDataClass")
data class CarrefourState(
    val courant: Int = 0, // feu courant (vert ou orange, les autres rouges)
    val feux: Array<Feu3State> = arrayOf(
        Feu3State(), Feu3State(), Feu3State(), Feu3State()  // 4 feux au départ
    )
) {
    // Retourne le Feu3State courant
    val feuCourant get() = feux[courant]

    // Méthode pour modifier la couleur du feu courant
    fun copyChangeCouleurCourant(couleur: Feu3StateV2): CarrefourState {
        val newFeux = feux.copyOf() // Créer une copie du tableau
        newFeux[courant] = newFeux[courant].copy(couleur = couleur) // Changer la couleur du feu courant
        return copy(feux = newFeux)
    }

    // Méthode pour changer le feu courant (passage au feu suivant)
    fun copyChangeCourant(num: Int): CarrefourState {
        return copy(courant = num) // Changer l'indice du feu courant
    }
}