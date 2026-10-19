import java.time.LocalDate
import java.util.Scanner

fun main() {
    val leer: Scanner = Scanner(System.`in`)
    var fechaCorrecta: Boolean = false
    var diaMax = 31
    var año: List<String>
    do {
        println("Introduce tu data de nacimiento (Separalo con \"/\"):")
        año = leer.nextLine().split("/") //hay un fallo en el que si pone otro tipo de formato de fecha sin las "/"
        // buscar un forma en la que lea si hay 3 caracteres "/"

        if (año[1].toInt() == 2) { //si mes es 2
            if (año[2].toInt() %4 == 0){
                diaMax = 29
            } else {
                diaMax = 28
            }
            if (año[0].toInt() in 1..diaMax && año[2].toInt() in 1900..LocalDate.now().year){
                fechaCorrecta = true
            } else {
                println("ERROR: La fecha introducida esta mal, acuerdate de que el formato es dia/mes/año")
            }

        } else{
            if (año[0].toInt() in 1..diaMax && año[1].toInt() in 1..12 && año[2].toInt() in 1900..LocalDate.now().year) {
                fechaCorrecta = true

            } else {
                println("ERROR: La fecha introducida esta mal, acuerdate de que el formato es dia/mes/año")
            }

        }

    } while (!fechaCorrecta)
    when (año){

    }

}
