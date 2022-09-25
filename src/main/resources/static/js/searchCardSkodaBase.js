// Поиск автомобиля при добавлении
let searchCardSkodaBaseInput = document.querySelector('floatingVINCarSkodaBaseAdd');
let searchCardSkodaBaseNotUnique = document.getElementById('searchCardSkodaBaseNotUnique');
let searchCardSkodaBaseNotUniqueButton = document.getElementById('searchCardSkodaBaseNotUniqueButton');

floatingVINCarSkodaBaseAdd.oninput = function(){
    searchCardSkodaBaseInput = floatingVINCarSkodaBaseAdd.value;
    
    
    if(searchCardSkodaBaseInput !== "" && searchCardSkodaBaseInput.length > 16){
        searchCardSkodaBase();
        
    } else if (searchCardSkodaBaseInput === "" || searchCardSkodaBaseInput.length < 17){
        searchCardSkodaBaseNotUnique.style.visibility = 'hidden';
        searchCardSkodaBaseNotUniqueButton.style.visibility = 'visible';
    }

};

function searchCardSkodaBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinFromSkodaBase = JSON.parse(this.responseText);
            for (i=0 ; i<vinFromSkodaBase.length; i++){
                var vinFromSkodaBaseChecked = vinFromSkodaBase[i];
                
                if (searchCardSkodaBaseInput === vinFromSkodaBaseChecked.vin){
                    console.log("Есть в базе");
                    searchCardSkodaBaseNotUnique.style.visibility = 'visible';
                    searchCardSkodaBaseNotUniqueButton.style.visibility = 'hidden';
                } 
                        
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_skoda/${searchCardSkodaBaseInput}`, true);
    xhttp.send();
}


//Поиск автомобиля в базе
let floatingVINForSearchSkodaBase = document.getElementById('floatingVINForSearchSkodaBase');

floatingVINForSearchSkodaBase.oninput = function(){
    searchCardSkodaBaseInput = floatingVINForSearchSkodaBase.value;
    if(searchCardSkodaBaseInput !== "" ){
        vinForSearchSkodaBase();
    } else if (searchCardSkodaBaseInput === ""){
        vinForSearchSkodaBaseEmpty();
    }
};

function vinForSearchSkodaBaseEmpty(){
    document.getElementById("searchSkodaBaseList").innerHTML = '<tr>\n' +
                '<td>VIN</td>\n' +
                '<td>Госс.номер</td>\n' +
                '<td>Изменить</td>\n' +
                '</tr>\n';
}

function vinForSearchSkodaBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinForSkodaBase = JSON.parse(this.responseText);
            var searchSkodaBase = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Госс.номер</td>\n' +
            '<td>Изменить</td>\n' +
            '</tr>\n';
            if (vinForSkodaBase.length === 0){
                vinForSearchSkodaBaseEmpty();
            }
            if (vinForSkodaBase.length !== 0){
                for (i=0 ; i<vinForSkodaBase.length; i++){
                    var findSkodaFromBase = vinForSkodaBase[i];
                    searchSkodaBase = searchSkodaBase + '\n' +
                    '<tr><td>'+findSkodaFromBase.vin+'</td>\n' +
                    '<td>'+findSkodaFromBase.reg_num+'</td>\n' +
                    '<td><a class="button" style="margin: 5px" onclick="updateSkodaCarFromBase('+findSkodaFromBase.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></td></tr>';  
                    
                    document.getElementById("searchSkodaBaseList").innerHTML = searchSkodaBase;
                }
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_skoda/${searchCardSkodaBaseInput}`, true);
    xhttp.send();
}

