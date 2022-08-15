let btn_SearchShowTO = document.getElementById('btn_SearchShowTO')


async function btnSearchShowTO(){

    let selectTO = document.getElementById('selectTO');
    selectTO = selectTO.value;
    console.log("ID TO: " + selectTO);

    let selectAuto = document.getElementById('selectAuto');
    selectAuto = selectAuto.value;
    console.log("ID Auto: " + selectAuto);

    fetch(`http://localhost:8080/to_regulations/${selectTO}&${selectAuto}`, {
        method: 'GET',
        redirect: 'follow'
    }) .catch(error => console.log('error', error));

};



