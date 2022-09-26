popup_noOk = document.getElementById("popup_noOk");
popup_ok = document.getElementById("popup_ok");

function clearForm(){
    document.getElementById("floatingVINCarFordBase").value = "";
    document.getElementById("floatingRegNumCarFordBase").value = "";
    document.getElementById("floatingDateReleaseCarFordBase").value = "";
    document.getElementById("floatingDateArrivalCarFordBase").value = "";
}

function createCarFordBase(){
    var carFordVin = document.getElementById("floatingVINCarFordBaseAdd").value;
    var carFordRegNum = document.getElementById("floatingRegNumCarFordBaseAdd").value;
    var carFordDateRelease = document.getElementById("floatingDateReleaseCarFordBaseAdd").value;
    var carFordDateSale = document.getElementById("floatingDateArrivalCarFordBaseAdd").value;
    
   
    if (carFordVin.length == 17){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/automobile_card_ford/automobileCardFord");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"vin":carFordVin, "reg_num":carFordRegNum, "date_release":carFordDateRelease, 
    "date_sale":carFordDateSale}));

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