function createWarehouseCar(){
    var carVin = document.getElementById("floatingVIN").value;
    var carAlterVin = document.getElementById("floatingAlterVin").value;
    var carDateRelease = document.getElementById("floatingDateRelease").value;
    var carDateArrival = document.getElementById("floatingDateArrival").value;
    var createDatePosition = new Date();

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/warehouse_car/addNewCar");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"vin":carVin, "alter_vin":carAlterVin, "date_release":carDateRelease, 
    "date_arrival":carDateArrival, "create_date_position":createDatePosition}));
    
    xmlhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            clearForm(); 
        }
    };
    
    
};
function clearForm(){
    document.getElementById("floatingVIN").value = "";
    document.getElementById("floatingAlterVin").value = "";
    document.getElementById("floatingDateRelease").value = "";
    document.getElementById("floatingDateArrival").value = "";
}



