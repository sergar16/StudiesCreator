

(function ($) {


    $(function ($) {

        $('#dataStudiesTable').on('click', '.close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: 'http://localhost:8082/service/study/delete/'+$(this).data('id'),
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


