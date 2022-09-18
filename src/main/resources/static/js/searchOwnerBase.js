//Поиск карточки владельца
let vinOwner = document.querySelector('vinForSearchOwner');

vinForSearchOwner.oninput = function(){
    vinForSearchKiaBaseInput = vinForSearchOwner.value;
    if (vinForSearchKiaBaseInput.length > 0){
        vinOwnerAll();
    } else if (vinForSearchKiaBaseInput.length === 0){
        isEmptyInput();
    }
}

function isEmptyInput(){
    document.getElementById("searchOwnerBaseList").innerHTML = '<tr>\n' +
    '<td>VIN</td>\n' +
    '<td>Госс. номер</td>\n' +
    '<td>ФИО</td>\n' +
    '<td>Телефон</td>\n' +
    '<td>Действия</td>\n' +
    '</tr>\n';
}

function vinOwnerAll(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var vinBase = JSON.parse(this.responseText);
            var findTable = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Госс. номер</td>\n' +
            '<td>ФИО</td>\n' +
            '<td>Телефон</td>\n' +
            '<td>Действия</td>\n' +
            '</tr>\n';
            for (let i=0; i<vinBase.length; i++){
                var findVin = vinBase[i];
                findTable = findTable + '\n' +
                '<tr><td>'+findVin.vin+'</td>\n' +
                '<td>'+findVin.reg_num+'</td>\n' +
                '<td>'+findVin.client_full_name+'</td>\n' +
                '<td>'+findVin.phone+'</td>\n' +
                '<td><a class="button" style="margin: 5px" onclick="updateOwnerCard('+findVin.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></td></tr>';
                
                document.getElementById("searchOwnerBaseList").innerHTML = findTable;
            }
        }
    }
    xhttp.open("GET",` http://localhost:8080/car_owner/${vinForSearchKiaBaseInput}`, true);
    xhttp.send();
};