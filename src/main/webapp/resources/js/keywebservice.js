

(function ($) {

    $(function ($) {

        $('#dataKeyTable').on('click', '.close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
            $.ajax({
                url: 'http://localhost:8082/keyOperations/delete/'+$(this).data('id'),
                type: 'POST',
                data: {
                    'id': $(this).data('id')
                },
                success: function () {
                    alert('PUT completed');
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