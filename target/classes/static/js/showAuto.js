function showAuto(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var autos = JSON.parse(this.responseText);
            var autoTable = '<tr>\n' +
            '<td>id</td>\n' +
            '<td>Авто</td>\n' +
            '<td>Модификация</td>\n' +
            '</tr>\n';
            for (let i=0; i<autos.length; i++){
                var auto = autos[i];
                //console.log(auto);
                autoTable = autoTable + '\n' +
                '<tr><td>'+auto.id+'</td>\n' +
                '<td>'+auto.automobile+'</td>\n' +
                '<td>'+auto.modification+'</td>\n';
                //document.getElementById("autoList").innerHTML = autoTable;
            }
        }
    };
    xhttp.open("GET", "http://localhost:8080/auto/findAll", true);
    xhttp.send();
}
showAuto();