var host = "http://localhost:8082";
//http://46.137.108.187
(function ($) {

    $(function ($) {

        $('#dataKeyTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            if ($('#dataKeyTable tbody tr').length > 2) {
            $(this).closest('tr').remove();
            $.ajax({
                url: host+'/service/key/delete/'+$(this).data('id'),
                type: 'POST',
                data: {
                    'id': $(this).data('id')
                },
                success: function () {
                }
            });}
        });


    })
    $(function ($) {

        $('#dataSourceTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            if ($('#dataSourceTable tbody tr').length > 2) {
            $(this).closest('tr').remove();
            $.ajax({
                url: host+'/service/source/delete/'+$(this).data('id'),
                type: 'POST',
                data: {
                    'id': $(this).data('id')
                },
                success: function () {
                }
            });}
        });


    });
    $(function ($) {

        $('#dataSamplingPeriodsTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            if ($('#dataSamplingPeriodsTable tbody tr').length > 2) {
            $(this).closest('tr').remove();
            $.ajax({
                url: host+'/service/samplingPeriod/delete/'+$(this).data('id'),
                type: 'POST',
                data: {
                    'id': $(this).data('id')
                },
                success: function () {
                }
            });}
        });


    });

    ///Key
    $(function ($) {
        var keyList=[];
        $('#save').click(function () {

            $('#dataKeyTable tbody tr:not(:first-child)').each(function () {
                console.log(this.cells[this.cells.length-1]);
                console.log(this);
                var id = this.id;
                console.log(id);
                var value = this.cells[0].firstChild.value;
                console.log(value);
                var data = {id:id,value:value};
                keyList.push(data);
            });
            console.log(keyList);
            $.ajax({
                url: host + '/service/key/updateAll/' + JSON.stringify(keyList),
                type: 'POST',
                data: {

                },
                success: function () {
                }
            });
        });


    })
    ///Source

    $(function ($) {
        var valueList=[];
        $('#save').click(function () {

            $('#dataSourceTable tbody tr:not(:first-child)').each(function () {
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
                url: host + '/service/source/updateAll/' + JSON.stringify(valueList),
                type: 'POST',
                data: {

                },
                success: function () {
                }
            });
        });


    })
    
    ///Sampling period
    var valueList=[];
    $('#save').click(function () {

        $('#dataSamplingPeriodsTable tbody tr:not(:first-child)').each(function () {
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
            url: host + '/service/samplingPeriod/updateAll/' + JSON.stringify(valueList),
            type: 'POST',
            data: {

            },
            success: function () {
            }
        });
    });


цц


})(jQuery);

