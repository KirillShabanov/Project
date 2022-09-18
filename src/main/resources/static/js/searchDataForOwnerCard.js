let searchVIN = document.querySelector('searchVin'); 
let searchCLIENT = document.querySelector('searchClient'); 
let notUniqueFlag = document.getElementById('notUnique');
let uniqueFlag = document.getElementById('Unique');
let notUniqueFlag1 = document.getElementById('notUnique1');
let uniqueFlag1 = document.getElementById('Unique1');
let notUniqueButtonFlag = document.getElementById('notUniqueButton');

searchVin.oninput = function(){
    searchCardKiaBaseInput = searchVin.value;
    if (searchCardKiaBaseInput.length > 1){
        serchVinBase(); 
    } 
};

searchClient.oninput = function(){
    searchFullName = searchClient.value;
    if (searchFullName.length > 1){
        searchClientBase();
    }
};



function searchBrand(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var brand = JSON.parse(this.responseText);

            for (let i=0; i<brand.length; i++){
                var brands = brand[i];
                brandName = brands.car_brands;
            }

            let select = document.createElement('select');
            let option = document.createElement('option');
            
            for (let i=0; i<brand.length; i++) {
                var brands = brand[i];
                brandName = brands.car_brands;
                let option = document.createElement('option');
                option.value = i + 1;
                option.innerText = brandName;
                select.appendChild(option);
            }
            select.id = ('selectBrand')
            document.getElementById('container').appendChild(select);
            select.selectedIndex = -1;
        };
        
    }
    xhttp.open("GET", "http://localhost:8080/car_brand/findAll", true);
    xhttp.send();
};
searchBrand();

function serchVinBase(){
    var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function(){
            if (this.readyState === 4 && this.status === 200) {
                var serchVinBaseNow = JSON.parse(this.responseText);
                for (let i = 0; i < serchVinBaseNow.length; i++){
                    var check = serchVinBaseNow[i];
                    
                    
                    if(searchCardKiaBaseInput === check.vin) {
                        uniqueFlag.style.visibility = 'visible';
                        uniqueFlag.style.color = 'green';
                        notUniqueFlag.style.visibility = 'hidden';
                        notUniqueButtonFlag.style.visibility = 'visible';
                        FK_vin = check.id;
                        document.getElementById('idCar').value = FK_vin;
                        
                    } 
                    if (searchCardKiaBaseInput !== check.vin || searchCardKiaBaseInput.length < 17) {
                        notUniqueFlag.style.color = 'red';
                        notUniqueFlag.style.visibility = 'visible';
                        uniqueFlag.style.visibility = 'hidden';
                        notUniqueButtonFlag.style.visibility = 'hidden'; 
                    } 
                } 
            }
        };
    xhttp.open("GET", `http://localhost:8080/automobile_card_kia/${searchCardKiaBaseInput}`, true);
    xhttp.send();       
};



function searchClientBase(){
    var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function(){
            if (this.readyState === 4 && this.status === 200) {
                var serchClientBaseNow = JSON.parse(this.responseText);
                for (let i = 0; i < serchClientBaseNow.length; i++){
                    var checks = serchClientBaseNow[i];
                    
                    if(searchFullName === checks.client_full_name) {
                        uniqueFlag1.style.visibility = 'visible';
                        uniqueFlag1.style.color = 'green';
                        notUniqueFlag1.style.visibility = 'hidden';
                        notUniqueButtonFlag.style.visibility = 'visible';
                        FK_owner = checks.id;
                        document.getElementById('idClient').value = FK_owner;
                        showJSON();
                    } 
                    if (searchFullName.length !== checks['client_full_name'].length) {
                        notUniqueFlag1.style.color = 'red';
                        notUniqueFlag1.style.visibility = 'visible';
                        uniqueFlag1.style.visibility = 'hidden';
                        notUniqueButtonFlag.style.visibility = 'hidden'; 
                    } 
                } 
            }
        };
    xhttp.open("GET", `http://localhost:8080/clients_card/findAllClients`, true);
    xhttp.send();
};
 

   
function showJSON(){ 
    var FK_brand = selectBrand.value;
    document.getElementById('idBrand').value = FK_brand;
    var createDatePosition = new Date();
    
    var FKowner = document.getElementById("idClient").value;
    var FKvin = document.getElementById("idCar").value;
    var FKbrand = document.getElementById("idBrand").value;

console.log(JSON.stringify({"FK_owner":FKowner, "FK_vin":FKvin, "FK_brand":FKbrand, "create_date_position":createDatePosition}));
};