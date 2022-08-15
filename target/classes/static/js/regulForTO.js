
function regulForTO(){
    
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var reguls = JSON.parse(this.responseText);

            for (let i=0; i<reguls.length; i++){
                var regulations = reguls[i];
                regulForTO = regulations.number_TO;
                //console.log(regulForTO)
            }
        
            let select = document.createElement('select');
            

            for (let i=0; i<reguls.length; i++) {
                var regulations = reguls[i];
                regulForTO = regulations.number_TO;
                let option = document.createElement('option');
                option.value     = i+1;
                option.innerText = regulForTO;
                select.appendChild(option);
                
            }
            select.id = ('selectTO');
            document.getElementById('container2').appendChild(select);
            select.selectedIndex = -1;
        };
    }
    xhttp.open("GET", "http://localhost:8080/regulations/findAll", true);
    xhttp.send();
}
regulForTO();