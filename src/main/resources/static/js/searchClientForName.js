let fullNameForSearchClient =document.getElementById('fullNameForSearchClient');

fullNameForSearchClient.oninput = function() {
    searchFullName = fullNameForSearchClient.value;
    if (searchFullName !== ""){
        searchFullNameInBase();
    } else if (searchFullName === ""){
        searchFullNameInBaseIsEmpty();
    }
};

function searchFullNameInBaseIsEmpty(){
            document.getElementById("searchClientBaseList").innerHTML = '<tr>\n' +
            '<td>ФИО владельца</td>\n' +
            '<td>Город</td>\n' +
            '<td>Номер телефона</td>\n' +
            '</tr>\n';
}

function searchFullNameInBase(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            var searchFullNameJSON = JSON.parse(this.responseText);
            var searchFullNameTable = '<tr>\n' +
            '<td>ФИО владельца</td>\n' +
            '<td>Город</td>\n' +
            '<td>Номер телефона</td>\n' +
            '<td>Действия</td>\n' +
            '</tr>\n';
            if (searchFullNameJSON.length === 0){
                searchFullNameInBaseIsEmpty();
            }
            if (searchFullNameJSON.length !== 0){
                for(i = 0; i < searchFullNameJSON.length; i++){
                    var searchImportJSON = searchFullNameJSON[i];
                    searchFullNameTable = searchFullNameTable + '\n' +
                    '<tr><td>'+searchImportJSON.client_full_name+'</td>\n' +
                    '<td>'+searchImportJSON.city+'</td>\n' +
                    '<td>'+searchImportJSON.phone+'</td>\n' +
                    '<td><a class="button" style="margin: 5px" onclick="updateClientForName('+searchImportJSON.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></td></tr>';

                    document.getElementById("searchClientBaseList").innerHTML = searchFullNameTable;
                }
            }
        }
    };
    xhttp.open("GET", `http://localhost:8080/clients_card/fullName/${searchFullName}`, true);
    xhttp.send();
};