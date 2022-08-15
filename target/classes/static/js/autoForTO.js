
function autoForTO(){
    
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var autos = JSON.parse(this.responseText);

            for (let i=0; i<autos.length; i++){
                var auto = autos[i];
                autoForTO = auto.automobile + auto.modification;
                //console.log(autoForTO)
            }
        
            let select = document.createElement('select');
            let option = document.createElement('option');
            

            for (let i=0; i<autos.length; i++) {
                var auto = autos[i];
                autoForTO = auto.automobile + auto.modification;
                let option = document.createElement('option');
                option.value     = i+1;
                option.innerText = autoForTO;
                select.appendChild(option);
                
            }
            select.id = ('selectAuto')
            document.getElementById('container').appendChild(select);
            select.selectedIndex = -1;
        };
    }
    xhttp.open("GET", "http://localhost:8080/auto/findAll", true);
    xhttp.send();
}
autoForTO();
