

var host="http://46.137.108.187";
//http://localhost:8082
(function ($) {


    $(function ($) {

        $('#dataStudiesTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: host+'/service/study/delete/'+$(this).data('id'),
                type: 'POST',
                data: {
                    'id': $(this).data('id')
                },
                success: function () {
                }
            });
        });



        //$('.add').live('click', function(){
        //    var $this = $(this),
        //        $parentTR = $this.closest('tr');
        //
        //    $parentTR.clone().insertAfter($parentTR);
        //});


    });





})(jQuery);


