let searchCardKiaBaseInput = document.querySelector('floatingVINCarKiaBase');
let searchCardKiaBaseNotUnique = document.getElementById('searchCardKiaBaseNotUnique');
let searchCardKiaBaseNotUniqueButton = document.getElementById('searchCardKiaBaseNotUniqueButton');

searchCardKiaBaseNotUniqueButton
floatingVINCarKiaBase.oninput = function(){
    searchCardKiaBaseInput = floatingVINCarKiaBase.value;
    
    if(searchCardKiaBaseInput != "" && searchCardKiaBaseInput.length > 16){
        searchCardKiaBase();
        
    } else if (searchCardKiaBaseInput == "" || searchCardKiaBaseInput.length < 17){
        searchCardKiaBaseNotUnique.style.visibility = 'hidden';
        searchCardKiaBaseNotUniqueButton.style.visibility = 'visible';
    }

};

function searchCardKiaBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var vinFromKiaBase = JSON.parse(this.responseText);
            for (i=0 ; i<vinFromKiaBase.length; i++){
                var vinFromKiaBaseChecked = vinFromKiaBase[i];
                console.log(vinFromKiaBaseChecked.vin);
                
                if (searchCardKiaBaseInput == vinFromKiaBaseChecked.vin){
                    console.log("Есть в базе");
                    searchCardKiaBaseNotUnique.style.visibility = 'visible';
                    searchCardKiaBaseNotUniqueButton.style.visibility = 'hidden';
                } 
                        
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/automobile_card_kia/${searchCardKiaBaseInput}`, true);
    xhttp.send();
};

