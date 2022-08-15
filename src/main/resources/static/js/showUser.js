function showUser(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var users = JSON.parse(this.responseText);
            var userTable = '<tr>\n' +
            '<td>id</td>\n' +
            '<td>Имя</td>\n' +
            '<td>Фамилия</td>\n' +
            '<td>Логин</td>\n' +
            '<td>Пароль</td>\n' +
            '<td>Доступ</td>' +
            '<td>Действия</td>' +
            '</tr>\n';
            for (let i=0; i<users.length; i++){
                var user = users[i];
                //console.log(user);
                userTable = userTable + '\n' +
                '<tr><td>'+user.id+'</td>\n' +
                '<td>'+user.name+'</td>\n' +
                '<td>'+user.surname+'</td>\n' +
                '<td>'+user.login+'</td>\n' +
                '<td>'+user.password+'</td>\n' +
                '<td>'+user.level_access+'</td>' +
                '<td><button style="margin: 5px" onclick="updateUser('+user.id+')" type="button" ><i class="fa fa-pencil aria-hidden=true"></i></button>\n' +
                
                '<button style="margin: 5px" onclick="deleteUser('+user.id+')" type="button"><i class="fa fa-trash"></i></button></td></tr>';
                document.getElementById("usersList").innerHTML = userTable;
            }
        }
    };
    xhttp.open("GET", "http://localhost:8080/users/findAll", true);
    xhttp.send();
}
showUser();