function createOwnerCard(){
    var FKowner = document.getElementById("idClient").value;
    var FKvin = document.getElementById("idCar").value;
    var FKbrand = document.getElementById("idBrand").value;
    var createDatePosition = new Date();
    console.log(FKowner)

    if (FKbrand == 1){
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "http://localhost:8080/car_owner/saveKia");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({"fk_owner":FKowner, "fk_vin":FKvin,  
        "fk_brand":FKbrand, "create_date_position":createDatePosition})); 
    } else if (FKbrand == 2){
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "http://localhost:8080/car_owner_skoda/saveSkoda");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({"fk_owner":FKowner, "fk_vin":FKvin,  
        "fk_brand":FKbrand, "create_date_position":createDatePosition}));
    } else if (FKbrand == 3){
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "http://localhost:8080/car_owner_haval/saveHaval");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({"fk_owner":FKowner, "fk_vin":FKvin,  
        "fk_brand":FKbrand, "create_date_position":createDatePosition}));
    } else if (FKbrand == 4){
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "http://localhost:8080/car_owner_chery/saveChery");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({"fk_owner":FKowner, "fk_vin":FKvin,  
        "fk_brand":FKbrand, "create_date_position":createDatePosition}));
    } else if (FKbrand == 5){
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "http://localhost:8080/car_owner_ford/saveFord");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({"fk_owner":FKowner, "fk_vin":FKvin,  
        "fk_brand":FKbrand, "create_date_position":createDatePosition}));
    } else if (FKbrand == 6){
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "http://localhost:8080/car_owner_multibrand/saveMultibrand");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({"fk_owner":FKowner, "fk_vin":FKvin,  
        "fk_brand":FKbrand, "create_date_position":createDatePosition}));
    }
    
};
