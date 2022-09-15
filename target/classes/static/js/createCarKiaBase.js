let popup_noOk = document.getElementById("popup_noOk");
let popup_ok = document.getElementById("popup_ok");

function clearForm(){
    document.getElementById("floatingVINCarKiaBase").value = "";
    document.getElementById("floatingAlterVinCarKiaBase").value = "";
    document.getElementById("floatingRegNumCarKiaBase").value = "";
    document.getElementById("floatingDateReleaseCarKiaBase").value = "";
    document.getElementById("floatingDateArrivalCarKiaBase").value = "";
}

function createCarKiaBase(){
    var carKiaVin = document.getElementById("floatingVINCarKiaBaseAdd").value;
    var carKiaAlterVin = document.getElementById("floatingAlterVinCarKiaBaseAdd").value;
    var carKiaRegNum = document.getElementById("floatingRegNumCarKiaBaseAdd").value;
    var carKiaDateRelease = document.getElementById("floatingDateReleaseCarKiaBaseAdd").value;
    var carKiaDateSale = document.getElementById("floatingDateArrivalCarKiaBaseAdd").value;
    
   
    if (carKiaVin.length == 17){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/automobile_card_kia/automobileCardKia");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"vin":carKiaVin, "alter_vin":carKiaAlterVin, "reg_num":carKiaRegNum, "date_release":carKiaDateRelease, 
    "date_sale":carKiaDateSale}));

        popup_ok.className = ('popup open');
        setTimeout(function(){
        popup_ok.className = ('popup close');
    }, 2000);    

    } else {
        popup_noOk.className = ('popup open');
        setTimeout(function(){
            popup_noOk.className = ('popup close');
        }, 2000);
    }

    xmlhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            clearForm(); //Очистка формы                   
        }
    };
  
};