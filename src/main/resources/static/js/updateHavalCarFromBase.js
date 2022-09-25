let popup_updateHavalCar = document.getElementById('popup_updateHavalCar')
let button_updateHavalCar = document.getElementById('button_updateHavalCar')


function updateHavalCarFromBase(id){
    popup_updateHavalCar.className = ('popup open')
    popup_searchHavalBase.className = ('popup close')
    
    fetch(`http://localhost:8080/automobile_card_haval/findByIdCarHaval/${id}`, {
        method: 'GET', 
        redirect: 'follow'
        })
        .then(response => response.json())
        .then(result => {
            $("#popup_updateHavalCar #floatingIdCarHavalBaseAdd").val(result.id);
            $("#popup_updateHavalCar #floatingVINCarHavalBaseAdd").val(result.vin);
            $("#popup_updateHavalCar #floatingRegNumCarHavalBaseAdd").val(result.reg_num);
            $("#popup_updateHavalCar #floatingDateReleaseCarHavalBaseAdd").val(result.date_release);
            $("#popup_updateHavalCar #floatingDateArrivalCarHavalBaseAdd").val(result.date_sale);
        }).catch(error => console.log('error', error));
}

$(document).on("click", '#popup_updateHavalCar #button_updateHavalCar', async function() {
    let id = $("#popup_updateHavalCar #floatingIdCarHavalBaseAdd").val();
    let vin = $("#popup_updateHavalCar #floatingVINCarHavalBaseAdd").val();
    let regNum = $("#popup_updateHavalCar #floatingRegNumCarHavalBaseAdd").val();
    let dateRelease = $("#popup_updateHavalCar #floatingDateReleaseCarHavalBaseAdd").val();
    let dateSale = $("#popup_updateHavalCar #floatingDateArrivalCarHavalBaseAdd").val();
    

    const res = await fetch(`http://localhost:8080/automobile_card_haval/${id}`, {
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

