const request = obj =>{
    const xhr = new XMLHttpRequest();
    xhr.open(obj.method, obj.url, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(obj.dados);
    xhr.addEventListener('load', ()=> {
        if(xhr.status >= 200 && xhr.status < 308){
         obj.success(xhr.responseText);
        }else{
          obj.error(xhr.statusText);
        }
    });
}
const dados = {
    RadOpcao: 3,
    DATAINI: '08/07/2024',
    ChkMoeda: 61
};
const executa = request({
    method: 'POST',
    url: 'https://ptax.bcb.gov.br/ptax_internet/consultaBoletim.do?method=consultarBoletim',
    dados: 'RadOpcao=3&DATAINI=08/07/2024&ChkMoeda=61'
});