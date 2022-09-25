let popup_noOk = document.getElementById("popup_noOk");
let popup_ok = document.getElementById("popup_ok");

function clearForm(){
    document.getElementById("floatingVINCarSkodaBase").value = "";
    document.getElementById("floatingRegNumCarSkodaBase").value = "";
    document.getElementById("floatingDateReleaseCarSkodaBase").value = "";
    document.getElementById("floatingDateArrivalCarSkodaBase").value = "";
}

function createCarSkodaBase(){
    var carSkodaVin = document.getElementById("floatingVINCarSkodaBaseAdd").value;
    var carSkodaRegNum = document.getElementById("floatingRegNumCarSkodaBaseAdd").value;
    var carSkodaDateRelease = document.getElementById("floatingDateReleaseCarSkodaBaseAdd").value;
    var carSkodaDateSale = document.getElementById("floatingDateArrivalCarSkodaBaseAdd").value;
    
   
    if (carSkodaVin.length == 17){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/automobile_card_skoda/automobileCardSkoda");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"vin":carSkodaVin, "reg_num":carSkodaRegNum, "date_release":carSkodaDateRelease, 
    "date_sale":carSkodaDateSale}));

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