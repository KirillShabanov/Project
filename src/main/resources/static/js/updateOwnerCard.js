let popup_updateOwnerCard = document.getElementById('popup_updateOwnerCard')
let button_updateOwnerCard = document.getElementById('button_updateOwnerCard')

function updateOwnerCard(id){
    popup_updateOwnerCard.className = ('popup open')
    popup_searchAllCarBase.className = ('popup close')
    document.getElementById("IdForClientBase").innerHTML = id;
    
    fetch(`http://localhost:8080/car_owner/findById/${id}`, {
        method: 'GET', 
        redirect: 'follow'
        })
        .then(response => response.json())
        .then(result => {
            
            console.log(result);
            console.log(id);
        })
                .catch(error => console.log('error', error));           
}