let popup_updateSkodaCar = document.getElementById('popup_updateSkodaCar')
let button_updateSkodaCar = document.getElementById('button_updateSkodaCar')


function updateSkodaCarFromBase(id){
    popup_updateSkodaCar.className = ('popup open')
    popup_searchSkodaBase.className = ('popup close')
    
    fetch(`http://localhost:8080/automobile_card_skoda/findByIdCarSkoda/${id}`, {
        method: 'GET', 
        redirect: 'follow'
        })
        .then(response => response.json())
        .then(result => {
            $("#popup_updateSkodaCar #floatingIdCarSkodaBaseAdd").val(result.id);
            $("#popup_updateSkodaCar #floatingVINCarSkodaBaseAdd").val(result.vin);
            $("#popup_updateSkodaCar #floatingRegNumCarSkodaBaseAdd").val(result.reg_num);
            $("#popup_updateSkodaCar #floatingDateReleaseCarSkodaBaseAdd").val(result.date_release);
            $("#popup_updateSkodaCar #floatingDateArrivalCarSkodaBaseAdd").val(result.date_sale);
        }).catch(error => console.log('error', error));
}

$(document).on("click", '#popup_updateSkodaCar #button_updateSkodaCar', async function() {
    let id = $("#popup_updateSkodaCar #floatingIdCarSkodaBaseAdd").val();
    let vin = $("#popup_updateSkodaCar #floatingVINCarSkodaBaseAdd").val();
    let regNum = $("#popup_updateSkodaCar #floatingRegNumCarSkodaBaseAdd").val();
    let dateRelease = $("#popup_updateSkodaCar #floatingDateReleaseCarSkodaBaseAdd").val();
    let dateSale = $("#popup_updateSkodaCar #floatingDateArrivalCarSkodaBaseAdd").val();
    

    const res = await fetch(`http://localhost:8080/automobile_card_skoda/${id}`, {
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

