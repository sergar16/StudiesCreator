
function addRow(tableID) {
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    var colCount = table.rows[rowCount - 1].cells.length;
    row.innerHTML = table.rows[rowCount - 1].innerHTML;
    console.log(row.childElementCount);
    row.id=rowCount;
    for (var i = 0; i < row.childElementCount; i++) {
        var item = row.children[i].children[0];
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
            case"select":
                item.selectedIndex = 0;
                break;

        }
    }
}


