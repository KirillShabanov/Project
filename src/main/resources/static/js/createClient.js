function createClient(){
    var fullName = document.getElementById("fullNameForSearchClientBase").value;
    var city = document.getElementById("cityForSearchClientBase").value;
    var address = document.getElementById("addressForSearchClientBase").value;
    var phone = document.getElementById("phoneForSearchClientBase").value;
    var birthday = document.getElementById("birthdayForSearchClientBase").value;
    console.log(birthday)

    if (fullName.length > 0 && city.length > 0 && address.length > 0 && phone.length > 0 ) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/clients_card/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({"client_full_name":fullName, "city":city,
    "address":address, "phone":phone, "birthday":birthday}));

        ppopup_ok.className = ('popup open');
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
    
};

function clear(){
    document.getElementById("fullNameForSearchClientBase").value = "";
    document.getElementById("cityForSearchClientBase").value = "";
    document.getElementById("addressForSearchClientBase").value = "";
    document.getElementById("phoneForSearchClientBase").value = "";
    document.getElementById("birthdayNameForSearchClientBase").value = "";
}