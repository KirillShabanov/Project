function createOwnerCard(){
    var FKowner = document.getElementById("idClient").value;
    var FKvin = document.getElementById("idCar").value;
    var FKbrand = document.getElementById("idBrand").value;
    var createDatePosition = new Date();

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/car_owner/saveKia");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"fk_owner":FKowner, "fk_vin":FKvin,  
    "fk_brand":FKbrand, "create_date_position":createDatePosition})); 
};
