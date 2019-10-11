function validaQueEsteLleno(){
    var retorno;
    var miRetorno = true;

    retorno = validaQueElNombreEsteCompleto()
    if(retorno == false){
        miRetorno =false;
    }
    
    else{return miRetorno;}
}



function validaQueElNombreEsteCompleto(){
valor = document.getElementById("mail").value;
    if(valor == null || valor.length ==0 ){
        
        alert("El mail es un campo obligatorio");
        return false;
    }else{return true;}
    }