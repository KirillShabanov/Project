let popup_noOk = document.getElementById("popup_noOk");
let popup_ok = document.getElementById("popup_ok");

function clearForm(){
    document.getElementById("floatingVINCarMultibrandBase").value = "";
    document.getElementById("floatingRegNumCarMultibrandBase").value = "";
    document.getElementById("floatingDateReleaseCarMultibrandBase").value = "";
    document.getElementById("floatingDateArrivalCarMultibrandBase").value = "";
}

function createCarMultibrandBase(){
    var carMultibrandVin = document.getElementById("floatingVINCarMultibrandBaseAdd").value;
    var carMultibrandRegNum = document.getElementById("floatingRegNumCarMultibrandBaseAdd").value;
    var carMultibrandDateRelease = document.getElementById("floatingDateReleaseCarMultibrandBaseAdd").value;
    var carMultibrandDateSale = document.getElementById("floatingDateArrivalCarMultibrandBaseAdd").value;
    
   
    if (carMultibrandVin.length == 17){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/automobile_card_multibrand/automobileCardMultibrand");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"vin":carMultibrandVin, "reg_num":carMultibrandRegNum, "date_release":carMultibrandDateRelease, 
    "date_sale":carMultibrandDateSale}));

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