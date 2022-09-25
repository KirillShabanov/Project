let popup_updateMultibrandCar = document.getElementById('popup_updateMultibrandCar')
let button_updateMultibrandCar = document.getElementById('button_updateMultibrandCar')


function updateMultibrandCarFromBase(id){
    popup_updateMultibrandCar.className = ('popup open')
    popup_searchMultibrandBase.className = ('popup close')
    
    fetch(`http://localhost:8080/automobile_card_multibrand/findByIdCarMultibrand/${id}`, {
        method: 'GET', 
        redirect: 'follow'
        })
        .then(response => response.json())
        .then(result => {
            $("#popup_updateMultibrandCar #floatingIdCarMultibrandBaseAdd").val(result.id);
            $("#popup_updateMultibrandCar #floatingVINCarMultibrandBaseAdd").val(result.vin);
            $("#popup_updateMultibrandCar #floatingRegNumCarMultibrandBaseAdd").val(result.reg_num);
            $("#popup_updateMultibrandCar #floatingDateReleaseCarMultibrandBaseAdd").val(result.date_release);
            $("#popup_updateMultibrandCar #floatingDateArrivalCarMultibrandBaseAdd").val(result.date_sale);
        }).catch(error => console.log('error', error));
}

$(document).on("click", '#popup_updateMultibrandCar #button_updateMultibrandCar', async function() {
    let id = $("#popup_updateMultibrandCar #floatingIdCarMultibrandBaseAdd").val();
    let vin = $("#popup_updateMultibrandCar #floatingVINCarMultibrandBaseAdd").val();
    let regNum = $("#popup_updateMultibrandCar #floatingRegNumCarMultibrandBaseAdd").val();
    let dateRelease = $("#popup_updateMultibrandCar #floatingDateReleaseCarMultibrandBaseAdd").val();
    let dateSale = $("#popup_updateMultibrandCar #floatingDateArrivalCarMultibrandBaseAdd").val();
    

    const res = await fetch(`http://localhost:8080/automobile_card_multibrand/${id}`, {
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

