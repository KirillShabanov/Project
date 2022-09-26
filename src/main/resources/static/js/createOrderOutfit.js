let orderOutFitVIN = document.querySelector('orderOutFitVin');


orderOutFitVin.oninput = function(){
    vinForSearchBaseInput = orderOutFitVin.value;
    if (vinForSearchBaseInput.length === 17){
        serchVinBase();
        showCategory();
    }
}


function showBrand(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200){
            var brands = JSON.parse(this.responseText);
            for (let i=0; i<brands.length; i++){
                var brand = brands[i];
                var brandView = brand.car_brands;
            }
            let select = document.createElement('select');

            for (let i=0; i<brands.length; i++){
                var brand = brands[i];
                var brandView = brand.car_brands;
                let option = document.createElement('option');
                option.value     = i+1;
                option.innerText = brandView;
                select.appendChild(option);
            }
            select.id = ('showBrands');
            document.getElementById('containerBrand').appendChild(select);
            select.selectedIndex = -1;
        }
    };
    xhttp.open("GET", "http://localhost:8080/car_brand/findAll", true);
    xhttp.send();
};
showBrand();

function showCategory(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200){
            var categories = JSON.parse(this.responseText);
            for (let i=0; i<categories.length; i++){
                var category = categories[i];
                var categoryView = category.category;
            }
            let select = document.createElement('select');

            for (let i=0; i<categories.length; i++){
                var category = categories[i];
                var categoryView = category.category;
                let option = document.createElement('option');
                option.value     = i+1;
                option.innerText = categoryView;
                select.appendChild(option);
            }
            select.id = ('showCategorys');
            document.getElementById('containerCategory').appendChild(select);
            select.selectedIndex = -1;
        }
    };
    var categoryRepair = $("#containerBrand").find(":selected").text();
    xhttp.open("GET", `http://localhost:8080/category/${categoryRepair}`, true);
    xhttp.send();
};


function showUser(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200){
            var mastersReceiver = JSON.parse(this.responseText);
            for (let i=0; i<mastersReceiver.length; i++){
                var masterReceiver = mastersReceiver[i];
                var masterReceiverView = masterReceiver.name + masterReceiver.surname;
            }
            let select = document.createElement('select');

            for (let i=0; i<mastersReceiver.length; i++){
                var masterReceiver = mastersReceiver[i];
                var masterReceiverView = masterReceiver.name + " " + masterReceiver.surname;
                let option = document.createElement('option');
                option.value = i+1;
                option.innerText = masterReceiverView;
                select.appendChild(option);
            }
            select.id = ('showUsers');
            document.getElementById('containerUsers').appendChild(select);
            select.selectedIndex = -1;
        }
    };
    xhttp.open("GET", "http://localhost:8080/users/findAll", true);
    xhttp.send();
};
showUser();

function serchVinBase(){
    var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function(){
            if (this.readyState === 4 && this.status === 200) {
                var serchVinBaseNow = JSON.parse(this.responseText);
                for (let i = 0; i < serchVinBaseNow.length; i++){
                    var check = serchVinBaseNow[i];
                    
                    if(vinForSearchBaseInput === check.vin) {
                        var regNum = check.reg_num;
                        var clientName = check.client_full_name;
                        var phone = check.phone;

                        document.getElementById('regNum').innerText = regNum;
                        document.getElementById('fullNameClient').innerText = clientName; 
                        document.getElementById('phone').innerText = phone;
                    } 
                } 
            }
        };
    var brands = $("#containerBrand").find(":selected").text();

    if (brands == "KIA"){
        xhttp.open("GET", `http://localhost:8080/car_owner/${vinForSearchBaseInput}`, true);
        xhttp.send();
    } else if (brands == "Skoda"){
        xhttp.open("GET", `http://localhost:8080/car_owner_skoda/${vinForSearchBaseInput}`, true);
        xhttp.send();    
    } else if (brands == "Haval"){
        xhttp.open("GET", `http://localhost:8080/car_owner_haval/${vinForSearchBaseInput}`, true);
        xhttp.send();    
    } else if (brands == "Chery"){
        xhttp.open("GET", `http://localhost:8080/car_owner_chery/${vinForSearchBaseInput}`, true);
        xhttp.send();    
    } else if (brands == "Ford"){
        xhttp.open("GET", `http://localhost:8080/car_owner_ford/${vinForSearchBaseInput}`, true);
        xhttp.send();    
    } else if (brands == "Multibrand"){
        xhttp.open("GET", `http://localhost:8080/car_owner_multibrand/${vinForSearchBaseInput}`, true);
        xhttp.send();    
    }      
};

function createOrderOutfit(){
    
    var numOrder = document.getElementById('orderOutFitNum').value;
    var dateRepair = document.getElementById('orderOutFitDate').value;
    var vin = document.getElementById('orderOutFitVin').value;
    var mileage = document.getElementById('orderOutFitMileage').value;
    var regNum = document.getElementById('regNum').innerHTML;
    var fullNameClient = document.getElementById('fullNameClient').innerHTML;
    var phone = document.getElementById('phone').innerHTML;
    var brand = $("#containerBrand").find(":selected").text();
    var masterName = $("#containerUsers").find(":selected").text();
    var categoryRep = $("#showCategorys").find(":selected").text();
    var createDate = new Date();
    var status1 = 'not call';
    var status2 = status1;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/order_outfit/addOrderOutfit");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"num_order":numOrder, "date_order":dateRepair, "category":categoryRep, "phone":phone,
                                "vin":vin, "mileage":mileage, "reg_num":regNum, "client_name":fullNameClient, "brand":brand,
                                "master_receiver_name":masterName, "create_date_position":createDate,
                                "status_1":status1, "status_2":status2}));

};