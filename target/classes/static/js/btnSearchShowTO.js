let btn_SearchShowTO = document.getElementById('btn_SearchShowTO')


async function btnSearchShowTO(){

    let selectTO = document.getElementById('selectTO');
    selectTO = selectTO.value;

    let selectAuto = document.getElementById('selectAuto');
    selectAuto = selectAuto.value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            var infoTO = JSON.parse(this.responseText);
            var partTable = '<tr>\n' +
            '<td>Артикул</td>\n' +
            '<td>Название</td>\n' +
            '<td>Количество</td>\n' +
            '<td>Цена за шт.</td>\n' +
            '</tr>\n';
            var jobeTable ='<tr>\n' +
            '<td>Артикул</td>\n' +
            '<td>Название</td>\n' +
            '<td>Норма времени</td>\n' +
            '</tr>\n';

            let summ = 0;
            let sumJ = 0;

            for (let i=0; i<infoTO.length; i++){
                var partsPrice = infoTO[i];
                partTable = partTable + '\n' +
                '<tr><td>'+partsPrice.partNumber+'</td>\n' +
                '<td>'+partsPrice.partName+'</td>\n' +
                '<td>'+partsPrice.amount+'</td>\n' +
                '<td>'+partsPrice.partPrice +'</td>\n' +
                '</tr>';                
                document.getElementById("partTable").innerHTML = partTable; 

                summ = summ + (partsPrice.amount*partsPrice.partPrice);
                let p = summ.toFixed(2);
                document.getElementById("pricePartTO").innerHTML = p;
            };
                
            for (let i=0; i<infoTO.length; i++){
                var jobePrice = infoTO[i];
                let priceHour = 80;    
                if (jobePrice.jobCode != 0) {   
                    jobeTable = jobeTable + '\n' +
                        '<tr><td>'+jobePrice.jobCode+'</td>\n' +
                        '<td>'+jobePrice.jobName+'</td>\n' +
                        '<td>'+jobePrice.jobTime+'</td>\n' +
                        '</tr>';
                    document.getElementById("jobeTable").innerHTML = jobeTable; 
                    sumJ = sumJ + (jobePrice.jobTime*priceHour);    
                    let pr = sumJ.toFixed(2) - 16;
                    document.getElementById("priceJobTO").innerHTML = pr;
                    }
                };        
            let q = document.getElementById("priceJobTO").innerText;
            let w = document.getElementById("pricePartTO").innerText;
            let d = parseFloat(q);
            let b = parseFloat(w);
            let qw = d + b;
            let qz = qw.toFixed(2);
            document.getElementById("fullPriceTO").innerHTML = qz;

        }
    };
    xhttp.open("GET", `http://localhost:8080/to_regulations/${selectTO}&${selectAuto}`, true);
    xhttp.send();
    
};



