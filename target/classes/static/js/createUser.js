function createUser(){
    var userName = document.getElementById("floatingName").value;
    var userSurname = document.getElementById("floatingSurname").value;
    var userLogin = document.getElementById("floatingLogin").value;
    var userPass = document.getElementById("floatingPass").value;
    var userLevel_access = document.getElementById("floatingLevelAccess").value;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/users/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"name":userName, "surname":userSurname,
    "login":userLogin, "password":userPass, "level_access":userLevel_access}));
    
    xmlhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            showUser(); 
        }
    };
    clear();
}
function clear(){
    document.getElementById("floatingName").value = "";
    document.getElementById("floatingSurname").value = "";
    document.getElementById("floatingLogin").value = "";
    document.getElementById("floatingPass").value = "";
    document.getElementById("floatingLevelAccess").value = "";
}