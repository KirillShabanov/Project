function createUser(){
    var userName = document.getElementById("floatingName").value;
    var userSurname = document.getElementById("floatingSurname").value;
    var userLogin = document.getElementById("floatingLogin").value;
    var userPass = document.getElementById("floatingPass").value;
    var userLevel_access = document.getElementById("floatingLevelAccess").value;

    if (userName.length > 0 && userSurname.length > 0 && userLogin.length > 0 && userPass.length > 0 && userLevel_access.length > 0) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/users/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"name":userName, "surname":userSurname,
    "login":userLogin, "password":userPass, "level_access":userLevel_access}));

    popup_ok.className = ('popup open');
        setTimeout(function(){
        popup_ok.className = ('popup close');
        }, 2000);
    clear();
    } else {
        popup_noOk.className = ('popup open');
        setTimeout(function(){
        popup_noOk.className = ('popup close');
        }, 2000);
    }

    xmlhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            showUser(); 
        }
    };
    
}
function clear(){
    document.getElementById("floatingName").value = "";
    document.getElementById("floatingSurname").value = "";
    document.getElementById("floatingLogin").value = "";
    document.getElementById("floatingPass").value = "";
    document.getElementById("floatingLevelAccess").value = "";
}