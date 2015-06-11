

(function ($) {

    $(function ($) {

        $('#dataNameTable').on('click', '.close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: 'http://localhost:8082/service/name/delete/'+$(this).data('id'),
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

        $('#dataValueTable').on('click', '.close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: 'http://localhost:8082/service/value/delete/'+$(this).data('id'),
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


