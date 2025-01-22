fun main(){
    val hora = 14
        when{
            hora < 12 ->{
                print("Bom dia")
            }
            hora > 12 && hora < 18 ->{
                print("Boa Tarde")
            }
            else -> {print("Boa Noite")}
        }
}