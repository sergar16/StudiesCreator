/*$("#autoCompInput").bind("keypress", {}, keypressInBox);

function keypressInBox(e) {
    var code = (e.keyCode ? e.keyCode : e.which);
    if (code == 13) { //Enter keycode
        e.preventDefault();

        $("yourFormId").submit();
    }
};*/
function addRow(tableID) {
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    var colCount = table.rows[0].cells.length;
    for (var i = 0; i < colCount; i++) {
        /*  var newcell = row.insertCell(i);
         newcell.innerHTML = table.rows[0].cells[i].innerHTML;
         switch (newcell.childNodes[0].type) {
         case"text":
         newcell.childNodes[0].value = "";
         break;
         case"checkbox":
         newcell.childNodes[0].checked = false;
         break;
         case"select-one":
         newcell.childNodes[0].selectedIndex = 0;
         break;
         }*/


        row.innerHTML = '<tr><td align="left"><input type="text" value="new key"></td>' +
            '<td allign="left"><input type="checkbox" name="delete" value=""></td>' +
            ' <td allign="left"><input type="button" value="edit" name=""></td></tr>';

    }
}
function deleteRow(tableID) {
    try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        for (var i = 0; i < rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if (null != chkbox && true == chkbox.checked) {
                if (rowCount <= 1) {
                    alert("Cannot delete all the rows.");
                    break;
                }
                table.deleteRow(i);
                rowCount--;
                i--;
            }
        }
    } catch (e) {
        alert(e);
    }
}