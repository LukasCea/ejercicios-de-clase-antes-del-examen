import java.time.LocalDate
import java.util.Scanner

fun main() {
    val leer: Scanner = Scanner(System.`in`)
    var fechaCorrecta: Boolean = false
    var diaMax = 31
    var dataIntroducida: String
    var fecha: List<Int> = mutableListOf()


    do {
        do {
            var valoresCorrectos: Boolean = false
            println("Introduce tu data de nacimiento (Separalo con \"/\"):")
            dataIntroducida = leer.nextLine()  //hay un fallo en el que si pone otro tipo de formato de fecha sin las "/"
            // buscar un forma en la que lea si hay 3 caracteres "/"

            if (dataIntroducida.count { it == '/' } != 2) {
                dataIntroducida = dataIntroducida.replace('-', '/')
            }


            if (dataIntroducida.count { it == '/' } == 2) {
                fecha = dataIntroducida.split("/").map {it.toInt()}
            }

            println(fecha)
            if (fecha.size != 3) {
                println("Tienes que introducir si o si dia/mes/año")
            } else {
                valoresCorrectos = true
                println("El valor es correcto sales del bucle.") //chivato
            }

        } while (!valoresCorrectos)

        //comprueba de que la fecha sea correcta.
        if (fecha[1].toInt() == 2) { //si mes es 2
            if (fecha[2].toInt() %4 == 0){
                diaMax = 29
            } else {
                diaMax = 28
            }
            if (fecha[0].toInt() in 1..diaMax && fecha[2].toInt() in (LocalDate.now().year - 100)..LocalDate.now().year){
                fechaCorrecta = true
            } else {
                println("ERROR: La fecha introducida esta mal, acuerdate de que el formato es dia/mes/año")
            }

        } else{
            if (fecha[0].toInt() in 1..diaMax && fecha[1].toInt() in 1..12 && fecha[2].toInt() in (LocalDate.now().year - 100)..LocalDate.now().year) {
                fechaCorrecta = true

            } else {
                println("ERROR: La fecha introducida esta mal, acuerdate de que el formato es dia/mes/año")
            }

        }

    } while (!fechaCorrecta)
    when (fecha){

    }

}
