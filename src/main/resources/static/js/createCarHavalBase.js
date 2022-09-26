popup_noOk = document.getElementById("popup_noOk");
popup_ok = document.getElementById("popup_ok");

function clearForm(){
    document.getElementById("floatingVINCarHavalBase").value = "";
    document.getElementById("floatingRegNumCarHavalBase").value = "";
    document.getElementById("floatingDateReleaseCarHavalBase").value = "";
    document.getElementById("floatingDateArrivalCarHavalBase").value = "";
}

function createCarHavalBase(){
    var carHavalVin = document.getElementById("floatingVINCarHavalBaseAdd").value;
    var carHavalRegNum = document.getElementById("floatingRegNumCarHavalBaseAdd").value;
    var carHavalDateRelease = document.getElementById("floatingDateReleaseCarHavalBaseAdd").value;
    var carHavalDateSale = document.getElementById("floatingDateArrivalCarHavalBaseAdd").value;
    
   
    if (carHavalVin.length == 17){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/automobile_card_haval/automobileCardHaval");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"vin":carHavalVin, "reg_num":carHavalRegNum, "date_release":carHavalDateRelease, 
    "date_sale":carHavalDateSale}));

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