
fun pedirUsuario(msj :String, cosa :String) : Int? {
    try {
        print(msj)
        var entrada = readln().trim().toIntOrNull()
        if (cosa == "Minutos" || cosa == "Segundos")
            if (entrada == null){entrada = 0}
        if (cosa == "Hora"){
            if (entrada == null){
                println("Es obligatorio poner una hora!!")
                return pedirUsuario(msj,cosa)
            }
        }
        println("$cosa establecido a $entrada.")
        return entrada

    }catch (e: NumberFormatException)
    {
        println("\nERROR, formato invalido intenelo de nuevo.\n")
        return pedirUsuario(msj,cosa)
    }
}


fun main(){
    /*
    val hora1 = pedirUsuario("Dime la hora: ","Hora")
    val minutos1 = pedirUsuario("Dime los minutos: ","Minutos")
    val segundos1 = pedirUsuario("Dime los segundos: ","Segundos")

    val tiempo1 = try {
        if (hora1 != null && minutos1 != null && segundos1 != null) {
            Tiempo(hora1, minutos1, segundos1)} else {"Patata"}

    }catch (e :IllegalArgumentException){e.message}
    */

    val tiempo2 = Tiempo(23, 5, 67)
    /*se pasa del tiempo*/try {
        tiempo2.incrementar(Tiempo(1, 2, 3))
    }catch (e :IllegalArgumentException){println("ERROR -> ${e.message}")}
    println(tiempo2)
    /*sin hora*/try {
        val tiempo3 = Tiempo(-1,-6,-78484894)

    }catch (e :IllegalArgumentException){println("ERROR -> ${e.message}")}
}