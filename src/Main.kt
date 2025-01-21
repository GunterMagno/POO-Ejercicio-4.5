
fun pedirUsuario(msj :String, cosa :String) : Int {
    try {
        print(msj)
        var entrada = readln().trim().toIntOrNull()
        if (cosa == "Minutos" || cosa == "Segundos")
            if (entrada == null){entrada = 0}
        println("$cosa establecido a $entrada.")
        if (cosa == "Hora"){} //como hago que no me de problema el nullable
        return entrada //?: 0 <- esto sirve?
    }catch (e: NumberFormatException)
    {
        println("\nERROR, formato invalido intenelo de nuevo.\n")
        return pedirUsuario(msj,cosa)
    }
}


fun main(){
    val hora1 = pedirUsuario("Dime la hora: ","Hora")
    val minutos1 = pedirUsuario("Dime los minutos: ","Minutos")
    val segundos1 = pedirUsuario("Dime los segundos: ","Segundos")

    val tiempo1 = try {
        Tiempo(hora1, minutos1, segundos1)
    }catch (e :IllegalArgumentException){e.message}

}