fun main(){
    println(valorPorExtenso("100.100.100.001,10"))
}
    val nomeiaInteiroSingular = listOf(
        "centavo", "real", "mil", "milhão", "bilhão", "trilhão", "quatrilhão"
    )
    val nomeiaInteiroPlural = listOf(
        "centavos", "reais", "mil", "milhões", "bilhões", "trilhões","quatrilhões"
    )
    val nomeiaInteiroAcimaDeCentenas = listOf(
        "cento", "cem", "duzentos", "trezentos", "quatrocentos","quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"
    )
    val nomeiaInteiroAbaixoDeCentenas = listOf(
        "", "dez", "vinte", "trinta", "quarenta", "cinquenta","sessenta", "setenta", "oitenta", "noventa"
    )
    val nomeiaInteiroAbaixoDeVinte = listOf(
        "dez", "onze", "doze", "treze", "quatorze", "quinze","dezesseis", "dezesete", "dezoito", "dezenove"
    )
    val nomeiaInteiroAbaixoDeDez = listOf(
        "", "um", "dois", "três", "quatro", "cinco", "seis","sete", "oito", "nove"
    )
    
fun valorPorExtenso(valor: String): String{
        val repartindoValor = valor.split(",")
        val centavosValor = repartindoValor[1]
        val cadenalValor = repartindoValor[0]
        val repartindoCardenalValor: List<String> = cadenalValor.split(".")
        var valorEscrito = ""
        var totalDePartesInteira = repartindoCardenalValor.size
         repartindoCardenalValor.forEach{ valores->
           valorEscrito += preparaValorPorExnteso(valores.toList(), totalDePartesInteira)
           totalDePartesInteira--
        }
        
        valorEscrito += preparaValorPorExnteso(centavosValor.toList(), 0)
        return valorEscrito
    }

    fun preparaValorPorExnteso(valorPorCentenas: List<Char>, posicaoPartesInteirasValor: Int): String{
        var recebeValorPorExtenso = ""
         if(valorPorCentenas.size == 3){
                    if(valorPorCentenas[0].digitToInt() == 1 && valorPorCentenas[1].digitToInt() == 0 && valorPorCentenas[2].digitToInt() == 0){
                        recebeValorPorExtenso += nomeiaInteiroAcimaDeCentenas[valorPorCentenas[0].digitToInt()]
                    }else{
                        recebeValorPorExtenso += nomeiaInteiroAcimaDeCentenas[0]
                        if(valorPorCentenas[0].digitToInt() > 0){ recebeValorPorExtenso += " e " }
                    if(valorPorCentenas[1].digitToInt() == 1){
                        recebeValorPorExtenso += nomeiaInteiroAbaixoDeVinte[valorPorCentenas[2].digitToInt()]
                    }else{
                        recebeValorPorExtenso += nomeiaInteiroAbaixoDeCentenas[valorPorCentenas[1].digitToInt()]
                        recebeValorPorExtenso += " e "
                        recebeValorPorExtenso += nomeiaInteiroAbaixoDeDez[valorPorCentenas[2].digitToInt()]
                    }
                }
                }else if(valorPorCentenas.size == 2){
                    if(valorPorCentenas[0].digitToInt() == 1){
                        recebeValorPorExtenso += nomeiaInteiroAbaixoDeVinte[valorPorCentenas[1].digitToInt()]
                    }else{
                        recebeValorPorExtenso += nomeiaInteiroAbaixoDeCentenas[valorPorCentenas[0].digitToInt()]
                        if(valorPorCentenas[0].digitToInt() > 0){ recebeValorPorExtenso += " e " }
                        recebeValorPorExtenso += nomeiaInteiroAbaixoDeDez[valorPorCentenas[1].digitToInt()]
                    }
                }else{
                    recebeValorPorExtenso += nomeiaInteiroAbaixoDeDez[valorPorCentenas[0].digitToInt()]
                }
                if(valorPorCentenas[0].digitToInt() == 0 && valorPorCentenas[1].digitToInt() == 0 && valorPorCentenas[2].digitToInt() == 1){
                        recebeValorPorExtenso += " "+nomeiaInteiroSingular[posicaoPartesInteirasValor]
                    }else{
                        recebeValorPorExtenso += " "+nomeiaInteiroPlural[posicaoPartesInteirasValor]
                    }
                if(valorPorCentenas.size > 2){
                    recebeValorPorExtenso += " e "
                }
                return   recebeValorPorExtenso.toString();     
    }