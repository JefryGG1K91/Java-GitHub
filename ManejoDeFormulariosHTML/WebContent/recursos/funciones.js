/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarForma(form) {
///////////
    var nombre = form.nombreInput;
    if (nombre.value === " " || nombre.lenght < 2) {
        alert("Debe proporcionar un nombre");
        nombre.select();
        nombre.focus();
        return false;
    }
///////////
    var pass = form.passwordInput;
    if (pass.value === " " || pass.lenght < 8) {
        alert("Debe proporcionar una clave mas extensa");
        pass.select();
        pass.focus();
        return false;
    }
///////////
    var ocupacion = form.ocupacion;
    if (ocupacion.value === " ") {
        alert("Debe proporcionar una ocupacion");
        return false;
    }
///////////
    var radio = form.genero;
    var radioSelect = true;

    for (i = 0; i < radio.length; i++) {
        if (radio[i].checked) {
            radioSelect = true;
        }
        if (!radioSelect) {
            alert("Debe seleccionar el Genero");
            return false;
        }
    }
///////////
    var tecnCheck = form.tecnologia;
    var checkSelect = false;

    for (x = 0; x < tecnCheck.length; x++) {
        if (tecnCheck[x].checked) {
            checkSelect = true;
        }
        if (!checkSelect) {
            alert("Debe seleccionar, al menos un lenguaje");
        }
    }
    //Formulario validado 
    //alert("Formulario valido, enviando datos...");
    return true;
}

