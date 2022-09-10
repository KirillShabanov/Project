var findAllNotSaleNotNull = document.getElementById('floatingVINForSearchCheckedCar');
console.log(findAllNotSaleNotNull)
findAllNotSaleNotNull = floatingVINForSearchCheckedCar.value;


if (findAllNotSaleNotNull.length === 0) {
    showWarehouseCarIsSearchNull();
} else {
    showWarehouseCarIsSearchNotNull();
};

async function showWarehouseCarIsSearchNull(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var newCarsKia = JSON.parse(this.responseText);
            var newCarsKiaTable = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Приём</td>\n' +
            '<td>pdi</td>\n' +
            '<td>Выдача</td>\n' +
            '<td>30 дней</td>\n' +
            '<td>60 дней</td>' +
            '<td>90 дней</td>' +
            '<td>120 дней</td>' +
            '</tr>\n';
            for (let i=0; i<newCarsKia.length; i++){
                var newCarKia = newCarsKia[i];
                newCarsKiaTable = newCarsKiaTable + '\n' +
                '<tr><td>'+newCarKia.vin+'</td>\n' +
                '<td>'+newCarKia.insp_deliv+'</td>\n' +
                '<td>'+newCarKia.pdi+'</td>\n' +
                '<td>'+newCarKia.insp_proof+'</td>\n' +
                '<td>'+newCarKia.insp_30day+'</td>\n' +
                '<td>'+newCarKia.insp_60day+'</td>\n' +
                '<td>'+newCarKia.insp_90day+'</td>\n' +
                '<td>'+newCarKia.insp_120day+'</td></tr>';
                document.getElementById("warehouseCarList").innerHTML = newCarsKiaTable;
            }
        }
    };
    xhttp.open("GET", "http://localhost:8080/warehouse_car/findAllNotSale", true);
    xhttp.send(); 
};

async function showWarehouseCarIsSearchNotNull(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var newCarsKia = JSON.parse(this.responseText);
            var newCarsKiaTable = '<tr>\n' +
            '<td>VIN</td>\n' +
            '<td>Приём</td>\n' +
            '<td>pdi</td>\n' +
            '<td>Выдача</td>\n' +
            '<td>30 дней</td>\n' +
            '<td>60 дней</td>' +
            '<td>90 дней</td>' +
            '<td>120 дней</td>' +
            '</tr>\n';
            for (let i=0; i<newCarsKia.length; i++){
                var newCarKia = newCarsKia[i];
                newCarsKiaTable = newCarsKiaTable + '\n' +
                '<tr><td>'+newCarKia.vin+'</td>\n' +
                '<td>'+newCarKia.insp_deliv+'</td>\n' +
                '<td>'+newCarKia.pdi+'</td>\n' +
                '<td>'+newCarKia.insp_proof+'</td>\n' +
                '<td>'+newCarKia.insp_30day+'</td>\n' +
                '<td>'+newCarKia.insp_60day+'</td>\n' +
                '<td>'+newCarKia.insp_90day+'</td>\n' +
                '<td>'+newCarKia.insp_120day+'</td></tr>';
                document.getElementById("warehouseCarList").innerHTML = newCarsKiaTable;
            }
        }
    };
    xhttp.open("GET",` http://localhost:8080/warehouse_car/${findAllNotSaleNotNull}`, true);
    xhttp.send(); 
};







