var host = "http://localhost:8082";
//http://46.137.108.187
(function ($) {


    var updateAll = function(){

        console.log('Update All');
        var valueList=[];
        $('#save').click(function () {

            $('#dataStudiesTable tbody tr:not(:first-child)').each(function () {
                var id = this.id;
                console.log(id);
                var value = this.cells[0].firstChild.value;
                console.log(value);
                var data = {id:id,value:value};
                valueList.push(data);
            });
            console.log(valueList);
            try{
                $.ajax({
                    url: host + '/service/study/updateAll/' + JSON.stringify(valueList),
                    type: 'POST',
                    data: {

                    },
                    success: function () {
                        location.reload();
                    }
                });}catch (e){}

        });

    };

    $(function ($) {

        $('#dataStudiesTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            if ($('#dataStudiesTable tbody tr').length > 2) {
            $(this).closest('tr').remove();
          try{
            $.ajax({
                url: host+'/service/study/delete/'+$(this).closest('tr').attr('id'),
                type: 'POST',
                data: {
                },
                success: function () {
                }
            });
          }catch (e){
          //    location.reload();
          }}
        });




    });

    $(function ($) {
        $('#dataStudiesTable').on('click', 'tr td  .add', function (e) {
               console.log($(this).closest('tr').next().attr('id'));
                $.ajax({
                    url: host+'/service/study/createNew/'+$(this).closest('table').find('tr').last().attr('id'),
                    type: 'POST',
                    data: {
                    },
                    success: function () {
                       updateAll();
                    }
                });
          {
             // location.reload();
          }
        });
    });

    updateAll();


})(jQuery);


