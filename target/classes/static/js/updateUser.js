
let popup_updateUsers = document.getElementById('popup_updateUsers')
let button_updateUser = document.getElementById('button_updateUsers')

function updateUser(id){
    popup_updateUsers.className = ('popup open')
    popup_users.className = ('popup close')
      
    
    fetch(`http://localhost:8080/users/findById/${id}`, {
        method: 'GET', 
        redirect: 'follow'
        })
        .then(response => response.json())
        .then(result => {
            $("#popup_updateUsers #floatingId").val(result.id);
            $("#popup_updateUsers #floatingName").val(result.name);
            $("#popup_updateUsers #floatingSurname").val(result.surname);
            $("#popup_updateUsers #floatingLogin").val(result.login);
            $("#popup_updateUsers #floatingPass").val(result.password);
            $("#popup_updateUsers #floatingLevelAccess").val(result.level_access);
            //console.log(result);
            //console.log(id);
        })
                .catch(error => console.log('error', error));
};

$(document).on("click", '#popup_updateUsers #button_updateUsers', async function() {
    let id = $("#popup_updateUsers #floatingId").val();
    let userName = $("#popup_updateUsers #floatingName").val();
    let userSurname = $("#popup_updateUsers #floatingSurname").val();
    let userLogin = $("#popup_updateUsers #floatingLogin").val();
    let userPass = $("#popup_updateUsers #floatingPass").val();
    let userLevel_access = $("#popup_updateUsers #floatingLevelAccess").val();

    const res = await fetch(`http://localhost:8080/users/${id}`, {
        
        method: 'PUT',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify({"name":userName, "surname":userSurname,
        "login":userLogin, "password":userPass, "level_access":userLevel_access})
    });

    showUser();
    popup_updateUsers.className = ('popup close');
    popup_users.className = ('popup open');
    
});





