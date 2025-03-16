package feu3.state

data class Feu3State(
    var rouge: Boolean = true,
    var orange: Boolean = false,
    var vert: Boolean = false,
) {
    val nomCouleur: String
        get() =
            if (rouge) "rouge" else
                if (orange) "orange" else
                    if (vert) "vert" else "???"
}
