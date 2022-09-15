let popup_updateKiaCar = document.getElementById('popup_updateKiaCar')
let button_updateKiaCar = document.getElementById('button_updateKiaCar')


function updateKiaCarFromBase(id){
    popup_updateKiaCar.className = ('popup open')
    popup_searchKiaBase.className = ('popup close')
    
    fetch(`http://localhost:8080/automobile_card_kia/findByIdCarKia/${id}`, {
        method: 'GET', 
        redirect: 'follow'
        })
        .then(response => response.json())
        .then(result => {
            $("#popup_updateKiaCar #floatingIdCarKiaBaseAdd").val(result.id);
            $("#popup_updateKiaCar #floatingVINCarKiaBaseAdd").val(result.vin);
            $("#popup_updateKiaCar #floatingAlterVinCarKiaBaseAdd").val(result.alter_vin);
            $("#popup_updateKiaCar #floatingRegNumCarKiaBaseAdd").val(result.reg_num);
            $("#popup_updateKiaCar #floatingDateReleaseCarKiaBaseAdd").val(result.date_release);
            $("#popup_updateKiaCar #floatingDateArrivalCarKiaBaseAdd").val(result.date_sale);
        }).catch(error => console.log('error', error));
}

$(document).on("click", '#popup_updateKiaCar #button_updateKiaCar', async function() {
    let id = $("#popup_updateKiaCar #floatingIdCarKiaBaseAdd").val();
    let vin = $("#popup_updateKiaCar #floatingVINCarKiaBaseAdd").val();
    let alterVin = $("#popup_updateKiaCar #floatingAlterVinCarKiaBaseAdd").val();
    let regNum = $("#popup_updateKiaCar #floatingRegNumCarKiaBaseAdd").val();
    let dateRelease = $("#popup_updateKiaCar #floatingDateReleaseCarKiaBaseAdd").val();
    let dateSale = $("#popup_updateKiaCar #floatingDateArrivalCarKiaBaseAdd").val();
    

    const res = await fetch(`http://localhost:8080/automobile_card_kia/${id}`, {
        method: 'PUT',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify({"id":id, "vin":vin, "alter_vin":alterVin,
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

