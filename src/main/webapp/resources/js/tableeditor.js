function clone(obj) {
    if (null == obj || "object" != typeof obj) return obj;
    var copy = Object.create(obj);
    for (var attr in obj) {
        if (obj.hasOwnProperty(attr)) copy[attr] = obj[attr];
    }
    return copy;
}

function addRow(tableID) {

    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    var colCount = table.rows[rowCount - 1].cells.length;
    row.innerHTML = table.rows[rowCount - 1].innerHTML;
    console.log(row.childElementCount)
    for (var i = 0; i < row.childElementCount; i++) {
        var item = row.children[i].children[0]
        console.log(item.type);
        switch (item.type) {
            case"text":
                item.value = "enter new item";
                break;
            case"checkbox":
                item.checked = false;
                break;
            case"select-one":
                item.selectedIndex = 0;
                break;


        }
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

