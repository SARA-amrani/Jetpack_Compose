package feu3.state

enum class Feu3StateV2 {
    ROUGE,
    ORANGE,
    VERT
}

data class Feu3State(
    val couleur: Feu3StateV2 = Feu3StateV2.ROUGE
){
    val nomCouleur: String
        get() = couleur.toString()
    val rouge get() = couleur == Feu3StateV2.ROUGE
    val orange get() = couleur == Feu3StateV2.ORANGE
    val vert get() = couleur == Feu3StateV2.VERT

    fun copyChangeCouleur(nouvelle: Feu3StateV2): Feu3State {
        return this.copy(couleur = nouvelle)
    }
}

