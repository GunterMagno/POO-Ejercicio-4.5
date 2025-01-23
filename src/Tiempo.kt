class Tiempo(
    var hora :Int,
    var minutos :Int,
    var segundos :Int)
{
    init {
        validar()
        ajustar()
    }

    private fun validar(){
        require(hora <= 23){"La hora tiene que ser menor que 24."}
        require(hora >= 0){"La hora tiene que ser igual o mayor que 0."}
        require(minutos >= 0){"Los minutos deben ser igual o mayores que 0."}
        require(segundos >= 0){"Los segundos deben ser igual o mayores que 0."}
    }

    private fun ajustar(){
        if(segundos > 59){
            while(segundos > 59){
                segundos -= 60
                minutos ++
            }
        }
        if(minutos > 59) {
            while (minutos > 59){
                minutos -= 60
                hora++
            }
        }
    }

    constructor(hora :Int,minutos: Int): this(hora,minutos, 0)

    constructor(hora: Int): this(hora, 0, 0)

    fun incrementar(t :Tiempo) :Boolean{
        val copiaTiempo = this.copiar()
        hora += t.hora
        minutos += t.minutos
        segundos += t.segundos
        ajustar()

        if(hora >= 24 || hora < 0){
            println("La hora a pasado de los limites establecidos por lo que no es valida, deshaciendo operacion...")
            hora = copiaTiempo.hora
            minutos = copiaTiempo.minutos
            segundos = copiaTiempo.segundos
            return false
        }

        validar()
        return true
    }

    fun decrementar(t :Tiempo) :Boolean{
        val copiaTiempo = this.copiar()
        hora -= t.hora
        minutos -= t.minutos
        segundos -= t.segundos
        ajustar()

        if(hora >= 24 || hora < 0){
            println("La hora a pasado de los limites establecidos por lo que no es valida, deshaciendo operacion...")
            hora = copiaTiempo.hora
            minutos = copiaTiempo.minutos
            segundos = copiaTiempo.segundos
            return false
        }

        validar()
        return true
    }

    fun copiar() :Tiempo{
        return Tiempo(hora, minutos, segundos)
    }

    override fun toString(): String {
        return ("El tiempo es: ${hora}h ${minutos}m ${segundos}s")
    }

}