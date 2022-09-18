function showOrderOutfit(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            var orders = JSON.parse(this.responseText);
            var ordersTable = '<tr>\n' +
            '<td>Номер з/н</td>\n' +
            '<td>Дата з/н</td>\n' +
            '<td>VIN</td>\n' +
            '<td>Пробег</td>\n' +
            '<td>ФИО Клиента</td>\n' +
            '<td>Категория работ</td>\n' +
            '<td>ФИ ИПГ</td>\n' +
            '<td>Действия</td>\n' +
            '</tr>\n';
            for (let i=0; i<orders.length; i++){
                var order = orders[i];
                ordersTable = ordersTable + '\n' +
                '<tr><td>'+order.num_order+'</td>\n' +
                '<td>'+order.date_order+'</td>\n' +
                '<td>'+order.vin+'</td>\n' +
                '<td>'+order.mileage+'</td>\n' +
                '<td>'+order.client_name+'</td>\n' +
                '<td>'+order.category+'</td>\n' +
                '<td>'+order.master_receiver_name+'</td>\n' +
                '<td><a class="button" style="margin: 5px" onclick="updateOrderOutfit('+order.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true" style="color: black"></i></a></tr>';
                document.getElementById('orderOutfitList').innerHTML = ordersTable;
            }
        }
    };
    xhttp.open("GET", "http://localhost:8080/order_outfit/showTable", true);
    xhttp.send();
};
showOrderOutfit();