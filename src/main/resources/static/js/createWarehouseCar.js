let popup_noOk = document.getElementById("popup_noOk");
let popup_ok = document.getElementById("popup_ok");


function clearForm(){
    document.getElementById("floatingVIN").value = "";
    document.getElementById("floatingAlterVin").value = "";
    document.getElementById("floatingDateRelease").value = "";
    document.getElementById("floatingDateArrival").value = "";
}

async function sendMail(carVin, carDateArrival){
   fetch(`http://localhost:8080/newCar${carVin}&${carDateArrival}`)
}

function createWarehouseCar(){
    var carVin = document.getElementById("floatingVIN").value;
    var carAlterVin = document.getElementById("floatingAlterVin").value;
    var carDateRelease = document.getElementById("floatingDateRelease").value;
    var carDateArrival = document.getElementById("floatingDateArrival").value;
    var createDatePosition = new Date();

    sendMail(carVin, carDateArrival); //Отправка Email уведомления  
   
    if (carVin.length == 17){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/warehouse_car/addNewCar");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"vin":carVin, "alter_vin":carAlterVin, "date_release":carDateRelease, 
    "date_arrival":carDateArrival, "create_date_position":createDatePosition}));
    
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
            clearForm();                 
        }
    };
    
};




