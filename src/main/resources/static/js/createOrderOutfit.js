let orderOutFitVIN = document.querySelector('orderOutFitVin');


orderOutFitVin.oninput = function(){
    vinForSearchKiaBaseInput = orderOutFitVin.value;
    if (vinForSearchKiaBaseInput.length === 17){
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
                    
                    if(vinForSearchKiaBaseInput === check.vin) {
                        var regNum = check.reg_num;
                        var clientName = check.client_full_name;

                        document.getElementById('regNum').innerText = regNum;
                        document.getElementById('fullNameClient').innerText = clientName; 
                    } 
                } 
            }
        };
    xhttp.open("GET", `http://localhost:8080/car_owner/${vinForSearchKiaBaseInput}`, true);
    xhttp.send();       
};

function createOrderOutfit(){
    
    var numOrder = document.getElementById('orderOutFitNum').value;
    var dateRepair = document.getElementById('orderOutFitDate').value;
    var vin = document.getElementById('orderOutFitVin').value;
    var mileage = document.getElementById('orderOutFitMileage').value;
    var regNum = document.getElementById('regNum').innerHTML;
    var fullNameClient = document.getElementById('fullNameClient').innerHTML;
    var brand = $("#containerBrand").find(":selected").text();
    var masterName = $("#containerUsers").find(":selected").text();
    var categoryRep = $("#showCategorys").find(":selected").text();
    var createDate = new Date();

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/order_outfit/addOrderOutfit");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"num_order":numOrder, "date_order":dateRepair, "category":categoryRep,
                                "vin":vin, "mileage":mileage, "reg_num":regNum, "client_name":fullNameClient, "brand":brand,
                                "master_receiver_name":masterName, "create_date_position":createDate}));

};