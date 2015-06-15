var host = "http://localhost:8082";
//http://46.137.108.187
(function ($) {

    $(function ($) {

        $('#dataNameTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: host + '/service/name/delete/' + $(this).data('id'),
                type: 'POST',
                data: {
                    'id': $(this).data('id')
                },
                success: function () {
                }
            });
        });


    })
    $(function ($) {

        $('#dataValueTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: host + '/service/value/delete/' + $(this).data('id'),
                type: 'POST',
                data: {
                    'id': $(this).data('id')
                },
                success: function () {
                }
            });
        });
    });

    $(function ($) {
        var nameList=[];
        $('#savename').click(function () {

            $('#dataNameTable tbody tr:not(:first-child)').each(function () {
                console.log(this.cells[this.cells.length-1]);
                console.log(this);
                var id = this.id;
                console.log(id);
                var value = this.cells[0].firstChild.value;
                console.log(value);
                var data = {id:id,value:value};
                nameList.push(data);
            });
            console.log(nameList);
            $.ajax({
                url: host + '/service/name/updateAll/' +JSON.stringify(nameList),
                type: 'POST',
                data: {

                },
                success: function () {
                }
            });
        });





    })

    $(function ($) {
        var valueList=[];
        $('#savevalue').click(function () {

            $('#dataValueTable tbody tr:not(:first-child)').each(function () {
                console.log(this.cells[this.cells.length-1]);
                console.log(this);
                var id = this.id;
                console.log(id);
                var value = this.cells[0].firstChild.value;
                console.log(value);
                var data = {id:id,value:value};
                valueList.push(data);
            });
            console.log(valueList);
            $.ajax({
                url: host + '/service/value/updateAll/' + JSON.stringify(valueList),
                type: 'POST',
                data: {

                },
                success: function () {
                }
            });
        });


    })
})(jQuery);


