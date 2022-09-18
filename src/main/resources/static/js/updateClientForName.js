let popup_updateClientForName = document.getElementById('popup_updateClientForName')
let button_updateClientForName = document.getElementById('button_updateClientForName')

function updateClientForName(id){
    popup_updateClientForName.className = ('popup open')
    popup_searchClientBase.className = ('popup close')

    fetch(`http://localhost:8080/clients_card/findById/${id}`, {
        method: 'GET',
        redirect: 'follow'
    })
    .then(response => response.json())
    .then(result => {
        $("#popup_updateClientForName #IdForSearchClientBase").val(result.id);
        $("#popup_updateClientForName #fullNameForSearchClientBase").val(result.client_full_name);
        $("#popup_updateClientForName #cityForSearchClientBase").val(result.city);
        $("#popup_updateClientForName #addressForSearchClientBase").val(result.address);
        $("#popup_updateClientForName #phoneForSearchClientBase").val(result.phone);
        $("#popup_updateClientForName #birthdayForSearchClientBase").val(result.birthday);
    }).catch(error => console.log('error', error));
    
}

$(document).on("click", '#popup_updateClientForName #button_updateClientForName', async function(){
    let id = $("#popup_updateClientForName #IdForSearchClientBase").val();
    let clientFullName = $("#popup_updateClientForName #fullNameForSearchClientBase").val();
    let city = $("#popup_updateClientForName #cityForSearchClientBase").val();
    let address = $("#popup_updateClientForName #addressForSearchClientBase").val();
    let phone = $("#popup_updateClientForName #phoneForSearchClientBase").val();
    let birthday = $("#popup_updateClientForName #birthdayForSearchClientBase").val();

    const res = await fetch(`http://localhost:8080/clients_card/${id}`, {
        method: 'PUT',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify({"id":id, "client_full_name":clientFullName,
                                "city":city, "address":address, "phone":phone, "birthday":birthday})
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