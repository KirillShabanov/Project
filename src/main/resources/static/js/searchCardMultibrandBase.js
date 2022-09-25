// Поиск автомобиля при добавлении
let searchCardMultibrandBaseInput = document.querySelector('floatingVINCarMultibrandBaseAdd');
let searchCardMultibrandBaseNotUnique = document.getElementById('searchCardMultibrandBaseNotUnique');
let searchCardMultibrandBaseNotUniqueButton = document.getElementById('searchCardMultibrandBaseNotUniqueButton');

floatingVINCarMultibrandBaseAdd.oninput = function(){
    searchCardMultibrandBaseInput = floatingVINCarMultibrandBaseAdd.value;
    
    
    if(searchCardMultibrandBaseInput !== "" && searchCardMultibrandBaseInput.length > 16){
        searchCardMultibrandBase();
        
    } else if (searchCardMultibrandBaseInput === "" || searchCardMultibrandBaseInput.length < 17){
        searchCardMultibrandBaseNotUnique.style.visibility = 'hidden';
        searchCardMultibrandBaseNotUniqueButton.style.visibility = 'visible';
    }

};

function searchCardMultibrandBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinFromMultibrandBase = JSON.parse(this.responseText);
            for (i=0 ; i<vinFromMultibrandBase.length; i++){
                var vinFromMultibrandBaseChecked = vinFromMultibrandBase[i];
                
                if (searchCardMultibrandBaseInput === vinFromMultibrandBaseChecked.vin){
                    console.log("Есть в базе");
                    searchCardMultibrandBaseNotUnique.style.visibility = 'visible';
                    searchCardMultibrandBaseNotUniqueButton.style.visibility = 'hidden';
                } 
                        
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_multibrand/${searchCardMultibrandBaseInput}`, true);
    xhttp.send();
}


//Поиск автомобиля в базе
let floatingVINForSearchMultibrandBase = document.getElementById('floatingVINForSearchMultibrandBase');

floatingVINForSearchMultibrandBase.oninput = function(){
    searchCardMultibrandBaseInput = floatingVINForSearchMultibrandBase.value;
    if(searchCardMultibrandBaseInput !== "" ){
        vinForSearchMultibrandBase();
    } else if (searchCardMultibrandBaseInput === ""){
        vinForSearchMultibrandBaseEmpty();
    }
};

function vinForSearchMultibrandBaseEmpty(){
    document.getElementById("searchMultibrandBaseList").innerHTML = '<tr>\n' +
                '<td>VIN</td>\n' +
                '<td>Госс.номер</td>\n' +
                '<td>Изменить</td>\n' +
                '</tr>\n';
}

function vinForSearchMultibrandBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinForMultibrandBase = JSON.parse(this.responseText);
            var searchMultibrandBase = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Госс.номер</td>\n' +
            '<td>Изменить</td>\n' +
            '</tr>\n';
            if (vinForMultibrandBase.length === 0){
                vinForSearchMultibrandBaseEmpty();
            }
            if (vinForMultibrandBase.length !== 0){
                for (i=0 ; i<vinForMultibrandBase.length; i++){
                    var findMultibrandFromBase = vinForMultibrandBase[i];
                    searchMultibrandBase = searchMultibrandBase + '\n' +
                    '<tr><td>'+findMultibrandFromBase.vin+'</td>\n' +
                    '<td>'+findMultibrandFromBase.reg_num+'</td>\n' +
                    '<td><a class="button" style="margin: 5px" onclick="updateMultibrandCarFromBase('+findMultibrandFromBase.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></td></tr>';  
                    
                    document.getElementById("searchMultibrandBaseList").innerHTML = searchMultibrandBase;
                }
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_multibrand/${searchCardMultibrandBaseInput}`, true);
    xhttp.send();
}

