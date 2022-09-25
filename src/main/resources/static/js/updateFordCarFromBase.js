let popup_updateFordCar = document.getElementById('popup_updateFordCar')
let button_updateFordCar = document.getElementById('button_updateFordCar')


function updateFordCarFromBase(id){
    popup_updateFordCar.className = ('popup open')
    popup_searchFordBase.className = ('popup close')
    
    fetch(`http://localhost:8080/automobile_card_ford/findByIdCarFord/${id}`, {
        method: 'GET', 
        redirect: 'follow'
        })
        .then(response => response.json())
        .then(result => {
            $("#popup_updateFordCar #floatingIdCarFordBaseAdd").val(result.id);
            $("#popup_updateFordCar #floatingVINCarFordBaseAdd").val(result.vin);
            $("#popup_updateFordCar #floatingRegNumCarFordBaseAdd").val(result.reg_num);
            $("#popup_updateFordCar #floatingDateReleaseCarFordBaseAdd").val(result.date_release);
            $("#popup_updateFordCar #floatingDateArrivalCarFordBaseAdd").val(result.date_sale);
        }).catch(error => console.log('error', error));
}

$(document).on("click", '#popup_updateFordCar #button_updateFordCar', async function() {
    let id = $("#popup_updateFordCar #floatingIdCarFordBaseAdd").val();
    let vin = $("#popup_updateFordCar #floatingVINCarFordBaseAdd").val();
    let regNum = $("#popup_updateFordCar #floatingRegNumCarFordBaseAdd").val();
    let dateRelease = $("#popup_updateFordCar #floatingDateReleaseCarFordBaseAdd").val();
    let dateSale = $("#popup_updateFordCar #floatingDateArrivalCarFordBaseAdd").val();
    

    const res = await fetch(`http://localhost:8080/automobile_card_ford/${id}`, {
        method: 'PUT',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify({"id":id, "vin":vin, 
        "reg_num":regNum, "date_release":dateRelease, "date_sale":dateSale})
    });
    console.log(res);
    popup_ok.className = ('popup open');
    setTimeout(function(){
        popup_ok.className = ('popup close');
    }, 2000);
    
    showUser();
    popup_updateUsers.className = ('popup close');
    popup_users.className = ('popup open');
    
});

