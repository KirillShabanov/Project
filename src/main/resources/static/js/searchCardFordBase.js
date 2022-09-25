// Поиск автомобиля при добавлении
let searchCardFordBaseInput = document.querySelector('floatingVINCarFordBaseAdd');
let searchCardFordBaseNotUnique = document.getElementById('searchCardFordBaseNotUnique');
let searchCardFordBaseNotUniqueButton = document.getElementById('searchCardFordBaseNotUniqueButton');

floatingVINCarFordBaseAdd.oninput = function(){
    searchCardFordBaseInput = floatingVINCarFordBaseAdd.value;
    
    
    if(searchCardFordBaseInput !== "" && searchCardFordBaseInput.length > 16){
        searchCardFordBase();
        
    } else if (searchCardFordBaseInput === "" || searchCardFordBaseInput.length < 17){
        searchCardFordBaseNotUnique.style.visibility = 'hidden';
        searchCardFordBaseNotUniqueButton.style.visibility = 'visible';
    }

};

function searchCardFordBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinFromFordBase = JSON.parse(this.responseText);
            for (i=0 ; i<vinFromFordBase.length; i++){
                var vinFromFordBaseChecked = vinFromFordBase[i];
                
                if (searchCardFordBaseInput === vinFromFordBaseChecked.vin){
                    console.log("Есть в базе");
                    searchCardFordBaseNotUnique.style.visibility = 'visible';
                    searchCardFordBaseNotUniqueButton.style.visibility = 'hidden';
                } 
                        
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_ford/${searchCardFordBaseInput}`, true);
    xhttp.send();
}


//Поиск автомобиля в базе
let floatingVINForSearchFordBase = document.getElementById('floatingVINForSearchFordBase');

floatingVINForSearchFordBase.oninput = function(){
    searchCardFordBaseInput = floatingVINForSearchFordBase.value;
    if(searchCardFordBaseInput !== "" ){
        vinForSearchFordBase();
    } else if (searchCardFordBaseInput === ""){
        vinForSearchFordBaseEmpty();
    }
};

function vinForSearchFordBaseEmpty(){
    document.getElementById("searchFordBaseList").innerHTML = '<tr>\n' +
                '<td>VIN</td>\n' +
                '<td>Госс.номер</td>\n' +
                '<td>Изменить</td>\n' +
                '</tr>\n';
}

function vinForSearchFordBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinForFordBase = JSON.parse(this.responseText);
            var searchFordBase = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Госс.номер</td>\n' +
            '<td>Изменить</td>\n' +
            '</tr>\n';
            if (vinForFordBase.length === 0){
                vinForSearchFordBaseEmpty();
            }
            if (vinForFordBase.length !== 0){
                for (i=0 ; i<vinForFordBase.length; i++){
                    var findFordFromBase = vinForFordBase[i];
                    searchFordBase = searchFordBase + '\n' +
                    '<tr><td>'+findFordFromBase.vin+'</td>\n' +
                    '<td>'+findFordFromBase.reg_num+'</td>\n' +
                    '<td><a class="button" style="margin: 5px" onclick="updateFordCarFromBase('+findFordFromBase.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></td></tr>';  
                    
                    document.getElementById("searchFordBaseList").innerHTML = searchFordBase;
                }
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_ford/${searchCardFordBaseInput}`, true);
    xhttp.send();
}

