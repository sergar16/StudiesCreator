var host = "http://localhost:8082";
//http://46.137.108.187
(function ($) {
    $(document).ready(function () {
        $('#dataNameTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            if ($('#dataNameTable tbody tr').length > 2) {
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
            }
        });


        $('#dataValueTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            if ($('#dataValueTable tbody tr').length > 2) {
                $(this).closest('tr').remove();
            }
        });


        var nameList = [];
        $('#save').click(function () {

            $('#dataNameTable tbody tr:not(:first-child)').each(function () {
                console.log(this.cells[this.cells.length - 1]);
                console.log(this);
                var id = this.id;
                console.log(id);
                var value = this.cells[0].firstChild.value;
                console.log(value);
                var data = {id: id, value: value};
                nameList.push(data);
            });
            console.log(nameList);
            $.ajax({
                url: host + '/service/name/updateAll/' + JSON.stringify(nameList),
                type: 'POST',
                data: {},
                success: function () {
                }
            });
            nameList = [];
            $('#dataValueTable tbody tr:not(:first-child)').each(function () {
                console.log(this.cells[this.cells.length - 1]);
                console.log(this);
                var id = this.id;
                console.log(id);
                var value = this.cells[0].firstChild.value;
                console.log(value);
                var data = {id: id, value: value};
                nameList.push(data);
            });
            console.log(nameList);
            $.ajax({
                url: host + '/service/value/updateAll/'+selectedNameId+'/' + JSON.stringify(nameList),
                type: 'POST',
                data: {},
                success: function () {
                }
            });
        });


        var valueList = [];
        $('.add').click(function () {


        });

        var selectedNameId=1;
        var dataValueTable = $('#dataNameTable');
        dataValueTable.find('tbody tr:nth-child(2)').children('td,th').css('background-color', '');
        dataValueTable.find('tbody tr:nth-child(2)').children('td,th').css('background-color', '#ddd');

        var values = $.getJSON(host + '/service/value/get/1',
            function (data) {
            }
        ).done(function (data) {
                var i = 0;
                $('#dataValueTable tbody tr:not(:first-child)').each(function () {
                    $(this).value = data[i];
                    i++;
                    if (i > data.length) {
                        $(this).remove();
                    }

                });


            });
        console.log('values 1', values);
        // dataValueTable.find('tr:nth-child(2)').style.backgroundColor="red";


        dataValueTable.find('tbody tr').click(function () {
            selectedNameId=this.id;
            console.log(" id -", this.id );
            dataValueTable.find('tbody tr:not(:first-child)').each(function () {
                $(this).children('td,th').css('background-color', '');
                $(this).children('td,th').css('background-color', '#fafafa');
            });
            $(this).children('td,th').css('background-color', '');
            $(this).children('td,th').css('background-color', '#ddd');


            var values = $.getJSON(host + '/service/value/get/' + this.id,
                function (data) {
                }
            ).done(function (data) {
                console.log('DATA', data);
                var $table = $("#dataValueTable");
                var $trList = $table.find('tr').filter(function (index, e) {
                    return $(e).attr('id') !== undefined
                });
                    $trList.remove();

                for(var i = 0; i < data.length; i++){
                    $table.append("<tr id='"+ data[i].value +"'><td><input type='text' value='"+ data[i].value+"'/></td></tr>");
                }
                });
            });
    });

})(jQuery);


