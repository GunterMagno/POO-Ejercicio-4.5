class Tiempo(
    var hora :Int,
    var minutos :Int,
    var segundos :Int)
{
    init {
        validar()
        ajustar()
        require(hora in 0..24){"La hora tiene que ser entre 0 y 24."}
    }

    private fun validar(){
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
        if(minutos > 59){
            while(minutos > 59)
                minutos -= 60
            hora ++
        }
    }

    constructor(hora :Int,minutos: Int): this(hora,minutos, 0)

    constructor(hora: Int): this(hora, 0, 0)


    fun incrementar(t :Tiempo) :Boolean{
        hora += t.hora
        minutos += t.minutos
        segundos += t.segundos
        return (hora <= 23)
    }

    fun decrementar(t :Tiempo) :Boolean{
        hora -= t.hora
        minutos -= t.minutos
        segundos -= t.segundos
        return (hora >= 0)
    }


    override fun toString(): String {
        return ("El tiempo es: ${hora}h ${minutos}m ${segundos}s")
    }



}