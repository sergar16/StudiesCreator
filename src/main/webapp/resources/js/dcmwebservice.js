

var host="http://localhost:8082";
//http://46.137.108.187
(function ($) {

    $(function ($) {

        $('#dataKeyTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: host+'/service/key/delete/'+$(this).data('id'),
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

        $('#dataSourceTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: host+'/service/source/delete/'+$(this).data('id'),
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

        $('#dataSamplingPeriodsTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: host+'/service/samplingPeriod/delete/'+$(this).data('id'),
                type: 'POST',
                data: {
                    'id': $(this).data('id')
                },
                success: function () {
                }
            });
        });


    });
    
    ///Key
    $(function ($) {
        var keyList=[];
        $('#saveKey').click(function () {

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
        $('#saveSource').click(function () {

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
    $(function ($) {
        var valueList=[];
        $('#saveSamplingPeriod').click(function () {

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


    })


})(jQuery);


/*
 $('#postButton').on('click', function () {
 event.preventDefault();

 var cookie = JSON.parse($.cookie('helloween'));
 $.ajax({
 data: {},
 headers: {'X-CSRF-TOKEN': cookie.csrf},
 timeout: 1000,
 type: 'POST',
 url: ''

 }).done(function(data, textStatus, jqXHR) {
 console.info("POST succeeded!!!");

 }).fail(function(jqXHR, textStatus, errorThrown) {
 console.error('Problems when posting...');
 });
 });*/