package acuario

import kotlin.math.PI

// Clase base
open class Acuario(open var largo: Int = 100, open var ancho: Int = 20, open var alto: Int = 40) {

    // Constructor secundario
    constructor(numeroDePeces: Int) : this() {
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }

    // Propiedad volumen con getter y setter
    open var volumen: Int
        get() = ancho * alto * largo / 1000
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }

    // Propiedades adicionales
    open val forma = "rectángulo"

    open var agua: Double = 0.0
        get() = volumen * 0.9

    // Método
    fun imprimirTamano() {
        println("Forma: $forma")
        println("Ancho: $ancho cm Largo: $largo cm Alto: $alto cm")
        println("Volumen: $volumen l")
        println("Agua: $agua l (${agua / volumen * 100} % lleno)")
    }
}

// Subclase (Herencia)
class TanqueTorre(override var alto: Int, var diametro: Int) :
    Acuario(alto = alto, ancho = diametro, largo = diametro) {

    override var volumen: Int
        get() = (ancho / 2 * largo / 2 * alto / 1000 * PI).toInt()
        set(valor) {
            alto = ((valor * 1000 / PI) / (ancho / 2 * largo / 2)).toInt()
        }

    override var agua = volumen * 0.8
    override val forma = "cilindro"
}
