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

function deleteRow(tableID,index) {
    try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        console.log(rowCount, "  ", index);
        if (rowCount <= 2) {
            alert("Cannot delete all the rows.");

        }
        else {
            table.deleteRow(index);
            rowCount--;
        }


        alert(e);
    }
}

