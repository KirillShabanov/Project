popup_noOk = document.getElementById("popup_noOk");
popup_ok = document.getElementById("popup_ok");

function clearForm(){
    document.getElementById("floatingVINCarCheryBase").value = "";
    document.getElementById("floatingRegNumCarCheryBase").value = "";
    document.getElementById("floatingDateReleaseCarCheryBase").value = "";
    document.getElementById("floatingDateArrivalCarCheryBase").value = "";
}

function createCarCheryBase(){
    var carCheryVin = document.getElementById("floatingVINCarCheryBaseAdd").value;
    var carCheryRegNum = document.getElementById("floatingRegNumCarCheryBaseAdd").value;
    var carCheryDateRelease = document.getElementById("floatingDateReleaseCarCheryBaseAdd").value;
    var carCheryDateSale = document.getElementById("floatingDateArrivalCarCheryBaseAdd").value;
    
   
    if (carCheryVin.length == 17){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/automobile_card_chery/automobileCardChery");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"vin":carCheryVin, "reg_num":carCheryRegNum, "date_release":carCheryDateRelease, 
    "date_sale":carCheryDateSale}));

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