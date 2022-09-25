// Поиск автомобиля при добавлении
let searchCardCheryBaseInput = document.querySelector('floatingVINCarCheryBaseAdd');
let searchCardCheryBaseNotUnique = document.getElementById('searchCardCheryBaseNotUnique');
let searchCardCheryBaseNotUniqueButton = document.getElementById('searchCardCheryBaseNotUniqueButton');

floatingVINCarCheryBaseAdd.oninput = function(){
    searchCardCheryBaseInput = floatingVINCarCheryBaseAdd.value;
    
    
    if(searchCardCheryBaseInput !== "" && searchCardCheryBaseInput.length > 16){
        searchCardCheryBase();
        
    } else if (searchCardCheryBaseInput === "" || searchCardCheryBaseInput.length < 17){
        searchCardCheryBaseNotUnique.style.visibility = 'hidden';
        searchCardCheryBaseNotUniqueButton.style.visibility = 'visible';
    }

};

function searchCardCheryBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinFromCheryBase = JSON.parse(this.responseText);
            for (i=0 ; i<vinFromCheryBase.length; i++){
                var vinFromCheryBaseChecked = vinFromCheryBase[i];
                
                if (searchCardCheryBaseInput === vinFromCheryBaseChecked.vin){
                    console.log("Есть в базе");
                    searchCardCheryBaseNotUnique.style.visibility = 'visible';
                    searchCardCheryBaseNotUniqueButton.style.visibility = 'hidden';
                } 
                        
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_chery/${searchCardCheryBaseInput}`, true);
    xhttp.send();
}


//Поиск автомобиля в базе
let floatingVINForSearchCheryBase = document.getElementById('floatingVINForSearchCheryBase');

floatingVINForSearchCheryBase.oninput = function(){
    searchCardCheryBaseInput = floatingVINForSearchCheryBase.value;
    if(searchCardCheryBaseInput !== "" ){
        vinForSearchCheryBase();
    } else if (searchCardCheryBaseInput === ""){
        vinForSearchCheryBaseEmpty();
    }
};

function vinForSearchCheryBaseEmpty(){
    document.getElementById("searchCheryBaseList").innerHTML = '<tr>\n' +
                '<td>VIN</td>\n' +
                '<td>Госс.номер</td>\n' +
                '<td>Изменить</td>\n' +
                '</tr>\n';
}

function vinForSearchCheryBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinForCheryBase = JSON.parse(this.responseText);
            var searchCheryBase = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Госс.номер</td>\n' +
            '<td>Изменить</td>\n' +
            '</tr>\n';
            if (vinForCheryBase.length === 0){
                vinForSearchCheryBaseEmpty();
            }
            if (vinForCheryBase.length !== 0){
                for (i=0 ; i<vinForCheryBase.length; i++){
                    var findCheryFromBase = vinForCheryBase[i];
                    searchCheryBase = searchCheryBase + '\n' +
                    '<tr><td>'+findCheryFromBase.vin+'</td>\n' +
                    '<td>'+findCheryFromBase.reg_num+'</td>\n' +
                    '<td><a class="button" style="margin: 5px" onclick="updateCheryCarFromBase('+findCheryFromBase.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></td></tr>';  
                    
                    document.getElementById("searchCheryBaseList").innerHTML = searchCheryBase;
                }
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_chery/${searchCardCheryBaseInput}`, true);
    xhttp.send();
}

