gitfunction cpf(doc) {
let doclimpo = doc.replace(/\D+/g, '');
cpfArray = Array.from(doclimpo);
let totalNoveDigitos = 0;
let totalDezDigito = 0;
let multiplicaNoveDigitos = 10;
let multiplicaDezDigitos = 11;
for (let index = 0; index < cpfArray.length-2; index++) {
    let valorCPF = Number(cpfArray[index]);
    //console.log("Digito CPF -> " +valorCPF);
    totalNoveDigitos += valorCPF * multiplicaNoveDigitos;
    //console.log(totalNoveDigitos);
    //console.log("valor da Multiplicação ->"+multiplicaNoveDigitos);
    multiplicaNoveDigitos--;
}
let primeiroDigitoValidado = 11 - (totalNoveDigitos % 11);
if(primeiroDigitoValidado > 9){
    primeiroDigitoValidado = 0;
}
for (let index = 0; index < cpfArray.length-1; index++) {
    let valorCPF = Number(cpfArray[index]);
    //console.log("Digito CPF -> " +valorCPF);
    totalDezDigito += valorCPF * multiplicaDezDigitos;
    //console.log(totalNoveDigitos);
    //console.log("valor da Multiplicação ->"+multiplicaDezDigitos);
    multiplicaDezDigitos--;
}
let segundoDigitoValidado = 11-(totalDezDigito % 11);
if(segundoDigitoValidado > 9){
    segundoDigitoValidado = 0;
}
let digitoCalculado = Number(String(primeiroDigitoValidado)+String(segundoDigitoValidado));
let digitoOriginal = doc.split("-");
if(Number(digitoOriginal[1]) === digitoCalculado){
    return "CPF é Válido";
}else{
    return "CPF é Falso";
}
}
console.log("Retorno da Função-> "+cpf("FFFFF"));