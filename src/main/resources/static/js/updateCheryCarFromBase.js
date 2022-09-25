let popup_updateCheryCar = document.getElementById('popup_updateCheryCar')
let button_updateCheryCar = document.getElementById('button_updateCheryCar')


function updateCheryCarFromBase(id){
    popup_updateCheryCar.className = ('popup open')
    popup_searchCheryBase.className = ('popup close')
    
    fetch(`http://localhost:8080/automobile_card_chery/findByIdCarChery/${id}`, {
        method: 'GET', 
        redirect: 'follow'
        })
        .then(response => response.json())
        .then(result => {
            $("#popup_updateCheryCar #floatingIdCarCheryBaseAdd").val(result.id);
            $("#popup_updateCheryCar #floatingVINCarCheryBaseAdd").val(result.vin);
            $("#popup_updateCheryCar #floatingRegNumCarCheryBaseAdd").val(result.reg_num);
            $("#popup_updateCheryCar #floatingDateReleaseCarCheryBaseAdd").val(result.date_release);
            $("#popup_updateCheryCar #floatingDateArrivalCarCheryBaseAdd").val(result.date_sale);
        }).catch(error => console.log('error', error));
}

$(document).on("click", '#popup_updateCheryCar #button_updateCheryCar', async function() {
    let id = $("#popup_updateCheryCar #floatingIdCarCheryBaseAdd").val();
    let vin = $("#popup_updateCheryCar #floatingVINCarCheryBaseAdd").val();
    let regNum = $("#popup_updateCheryCar #floatingRegNumCarCheryBaseAdd").val();
    let dateRelease = $("#popup_updateCheryCar #floatingDateReleaseCarCheryBaseAdd").val();
    let dateSale = $("#popup_updateCheryCar #floatingDateArrivalCarCheryBaseAdd").val();
    

    const res = await fetch(`http://localhost:8080/automobile_card_chery/${id}`, {
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

