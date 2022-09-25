// Поиск автомобиля при добавлении
let searchCardHavalBaseInput = document.querySelector('floatingVINCarHavalBaseAdd');
let searchCardHavalBaseNotUnique = document.getElementById('searchCardHavalBaseNotUnique');
let searchCardHavalBaseNotUniqueButton = document.getElementById('searchCardHavalBaseNotUniqueButton');

floatingVINCarHavalBaseAdd.oninput = function(){
    searchCardHavalBaseInput = floatingVINCarHavalBaseAdd.value;
    
    
    if(searchCardHavalBaseInput !== "" && searchCardHavalBaseInput.length > 16){
        searchCardHavalBase();
        
    } else if (searchCardHavalBaseInput === "" || searchCardHavalBaseInput.length < 17){
        searchCardHavalBaseNotUnique.style.visibility = 'hidden';
        searchCardHavalBaseNotUniqueButton.style.visibility = 'visible';
    }

};

function searchCardHavalBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinFromHavalBase = JSON.parse(this.responseText);
            for (i=0 ; i<vinFromHavalBase.length; i++){
                var vinFromHavalBaseChecked = vinFromHavalBase[i];
                
                if (searchCardHavalBaseInput === vinFromHavalBaseChecked.vin){
                    console.log("Есть в базе");
                    searchCardHavalBaseNotUnique.style.visibility = 'visible';
                    searchCardHavalBaseNotUniqueButton.style.visibility = 'hidden';
                } 
                        
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_haval/${searchCardHavalBaseInput}`, true);
    xhttp.send();
}


//Поиск автомобиля в базе
let floatingVINForSearchHavalBase = document.getElementById('floatingVINForSearchHavalBase');

floatingVINForSearchHavalBase.oninput = function(){
    searchCardHavalBaseInput = floatingVINForSearchHavalBase.value;
    if(searchCardHavalBaseInput !== "" ){
        vinForSearchHavalBase();
    } else if (searchCardHavalBaseInput === ""){
        vinForSearchHavalBaseEmpty();
    }
};

function vinForSearchHavalBaseEmpty(){
    document.getElementById("searchHavalBaseList").innerHTML = '<tr>\n' +
                '<td>VIN</td>\n' +
                '<td>Госс.номер</td>\n' +
                '<td>Изменить</td>\n' +
                '</tr>\n';
}

function vinForSearchHavalBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinForHavalBase = JSON.parse(this.responseText);
            var searchHavalBase = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Госс.номер</td>\n' +
            '<td>Изменить</td>\n' +
            '</tr>\n';
            if (vinForHavalBase.length === 0){
                vinForSearchHavalBaseEmpty();
            }
            if (vinForHavalBase.length !== 0){
                for (i=0 ; i<vinForHavalBase.length; i++){
                    var findHavalFromBase = vinForHavalBase[i];
                    searchHavalBase = searchHavalBase + '\n' +
                    '<tr><td>'+findHavalFromBase.vin+'</td>\n' +
                    '<td>'+findHavalFromBase.reg_num+'</td>\n' +
                    '<td><a class="button" style="margin: 5px" onclick="updateHavalCarFromBase('+findHavalFromBase.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></td></tr>';  
                    
                    document.getElementById("searchHavalBaseList").innerHTML = searchHavalBase;
                }
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_haval/${searchCardHavalBaseInput}`, true);
    xhttp.send();
}

