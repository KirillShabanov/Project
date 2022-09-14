document.getElementById('checkedFileWarehouseCar').addEventListener('change', handleFileSelect, false);
document.getElementById('downloadCheckedCar_btn').addEventListener('click',  function(){
  console.log("Жмяк!!!");
});

class ExcelToJSON {
  constructor() {
    this.parseExcel = function (file) {
      var reader = new FileReader();

      reader.onload = function (e) {
        var data = e.target.result;
        var workbook = XLSX.read(data, {
          type: 'binary'
        });
        workbook.SheetNames.forEach(function (sheetName) {
          // Здесь сам объект
          var XL_row_object = XLSX.utils.sheet_to_row_object_array(workbook.Sheets[sheetName]);
          var json_object = JSON.stringify(XL_row_object);
          //console.log(JSON.parse(json_object));
          //jQuery('#xlx_json').val(json_object);

          //Создал JSON с нужными файлами
          var JSONtoServer = [];

          //Парсим таблицу
          var checkedCar = JSON.parse(json_object);
          var ckedeCarTable = '<tr>\n' +
          '<td>VIN</td>\n' +
          '</tr>\n';
          for (let i = 0; i < checkedCar.length; i++) {
            var checkedsCar = checkedCar[i];
            
            if (checkedsCar['Inspection Type'] == "Storage" && checkedsCar.Period == "Delivery Inspection"){
              var insp_deliv = checkedsCar['Inspection Date(Local)'];
              var pdi = "";
              var insp_proof = "";
              var insp_30day = "";
              var insp_60day = "";
              var insp_90day = "";
              var insp_120day = "";
            };
             if (checkedsCar['Inspection Type'] == "PDI"){
                insp_deliv = "";
                pdi = checkedsCar['Inspection Date(Local)'];
                insp_proof = "";
                insp_30day = "";
                insp_60day = "";
                insp_90day = "";
                insp_120day = "";
            }; 
             if (checkedsCar['Inspection Type'] == "Storage" && checkedsCar.Period == "Proof of Departure") {
                insp_deliv = "";
                pdi = "";
                insp_proof = checkedsCar['Inspection Date(Local)'];
                insp_30day = "";
                insp_60day = "";
                insp_90day = "";
                insp_120day = "";
            }; 
             if (checkedsCar['Inspection Type'] == "Storage" && checkedsCar.Period == "30"){
                insp_deliv = "";
                pdi = "";
                insp_proof = "";
                insp_30day = checkedsCar['Inspection Date(Local)'];
                insp_60day = "";
                insp_90day = "";
                insp_120day = "";
            };
             if (checkedsCar['Inspection Type'] == "Storage" && checkedsCar.Period == "60"){
                insp_deliv = "";
                pdi = "";
                insp_proof = "";
                insp_30day = "";
                insp_60day = checkedsCar['Inspection Date(Local)'];
                insp_90day = "";
                insp_120day = "";
            }; 
             if (checkedsCar['Inspection Type'] == "Storage" && checkedsCar.Period == "90"){
                insp_deliv = "";
                pdi = "";
                insp_proof = "";
                insp_30day = "";
                insp_60day = "";
                insp_90day = checkedsCar['Inspection Date(Local)'];
                insp_120day = "";
            }; 
             if (checkedsCar['Inspection Type'] == "Storage" && checkedsCar.Period == "120"){
                insp_deliv = "";
                pdi = "";
                insp_proof = "";
                insp_30day = "";
                insp_60day = "";
                insp_90day = "";
                insp_120day = checkedsCar['Inspection Date(Local)'];
            }

            ckedeCarTable = ckedeCarTable + '\n' +
            '<tr><td>'+checkedsCar.Vin+'</td></tr>';
            
            //Вот тут создаюданные для JSON
             JSONtoServer.push({
              "vin":checkedsCar.Vin,
              "insp_deliv":insp_deliv,
              "PDI":pdi,
              "insp_proof":insp_proof,
              "insp_30day":insp_30day,
              "insp_60day":insp_60day,
              "insp_90day":insp_90day,
              "insp_120day":insp_120day
            });

            document.getElementById('ckedeCarTableTable').innerHTML = ckedeCarTable;
          }
          
          console.log(JSONtoServer);

        });
      };

      reader.onerror = function (ex) {
        console.log(ex);
      };
      reader.readAsBinaryString(file);
    };
  }
}

function handleFileSelect(evt) {
  var files = evt.target.files; // FileList object
  var xl2json = new ExcelToJSON();
  xl2json.parseExcel(files[0]);
}

