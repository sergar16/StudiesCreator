

var host="http://46.137.108.187";
//http://localhost:8082
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

        $('#dataSamplingPeriodsTable').on('click', '.close', function (e) {
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