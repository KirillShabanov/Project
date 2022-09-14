// Поиск автомобиля при добавлении
let searchCardKiaBaseInput = document.querySelector('floatingVINCarKiaBase');
let searchCardKiaBaseNotUnique = document.getElementById('searchCardKiaBaseNotUnique');
let searchCardKiaBaseNotUniqueButton = document.getElementById('searchCardKiaBaseNotUniqueButton');

let floatingVINCarKiaBase;
floatingVINCarKiaBase.oninput = function(){
    searchCardKiaBaseInput = floatingVINCarKiaBase.value;
    
    if(searchCardKiaBaseInput !== "" && searchCardKiaBaseInput.length > 16){
        searchCardKiaBase();
        
    } else if (searchCardKiaBaseInput === "" || searchCardKiaBaseInput.length < 17){
        searchCardKiaBaseNotUnique.style.visibility = 'hidden';
        searchCardKiaBaseNotUniqueButton.style.visibility = 'visible';
    }

};

function searchCardKiaBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinFromKiaBase = JSON.parse(this.responseText);
            for (i=0 ; i<vinFromKiaBase.length; i++){
                var vinFromKiaBaseChecked = vinFromKiaBase[i];
                
                if (searchCardKiaBaseInput === vinFromKiaBaseChecked.vin){
                    console.log("Есть в базе");
                    searchCardKiaBaseNotUnique.style.visibility = 'visible';
                    searchCardKiaBaseNotUniqueButton.style.visibility = 'hidden';
                } 
                        
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_kia/${searchCardKiaBaseInput}`, true);
    xhttp.send();
}


//Поиск автомобиля в базе
let floatingVINForSearchKiaBase = document.getElementById('floatingVINForSearchKiaBase');

floatingVINForSearchKiaBase.oninput = function(){
    vinForSearchKiaBaseInput = floatingVINForSearchKiaBase.value;
    if(vinForSearchKiaBaseInput !== "" ){
        vinForSearchKiaBase();
    } else if (vinForSearchKiaBaseInput === ""){
        vinForSearchKiaBaseEmpty();
    }
};

function vinForSearchKiaBaseEmpty(){
    document.getElementById("searchKiaBaseList").innerHTML = '<tr>\n' +
                '<td>VIN</td>\n' +
                '<td>Госс.номер</td>\n' +
                '<td>ФИО владельца</td>\n' +
                '<td>Номер телефона</td>\n' +
                '<td>Действия</td>\n' +
                '</tr>\n';
}

function vinForSearchKiaBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinForKiaBase = JSON.parse(this.responseText);
            var searchKiaBase = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Госс.номер</td>\n' +
            '<td>ФИО владельца</td>\n' +
            '<td>Номер телефона</td>\n' +
            '<td>Действия</td>\n' +
            '</tr>\n';
            if (vinForKiaBase.length === 0){
                vinForSearchKiaBaseEmpty();
            }
            if (vinForKiaBase.length !== 0){
                for (i=0 ; i<vinForKiaBase.length; i++){
                    var findKiaFromBase = vinForKiaBase[i];
                    searchKiaBase = searchKiaBase + '\n' +
                    '<tr><td>'+findKiaFromBase.vin+'</td>\n' +
                    '<td>'+findKiaFromBase.reg_num+'</td>\n' +
                    '<td>'+findKiaFromBase.client_full_name+'</td>\n' +
                    '<td>'+findKiaFromBase.phone+'</td>\n' +
                    '<td><a class="button" style="margin: 5px" onclick="updateUser('+findKiaFromBase.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></td></tr>';  
                    
                    document.getElementById("searchKiaBaseList").innerHTML = searchKiaBase;
                }
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/car_owner/${vinForSearchKiaBaseInput}`, true);
    xhttp.send();
}

