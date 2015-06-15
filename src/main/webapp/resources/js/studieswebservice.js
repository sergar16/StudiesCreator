

var host="http://localhost:8082";
//http://46.137.108.187
(function ($) {


    $(function updateAll($) {

        $('#dataStudiesTable').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            $(this).closest('tr').remove();
          try{
            $.ajax({
                url: host+'/service/study/delete/'+$(this).data('id'),
                type: 'POST',
                data: {
                },
                success: function () {
                }
            });
          }catch (e){
          //    location.reload();
          }
        });




    });

    $(function ($) {

        $('#dataStudiesTable').on('click', 'tr td  .add', function (e) {
        //  var name= this.closest('text').value;

                $.ajax({
                    url: host+'/service/study/createNew',
                    type: 'POST',
                    data: {
                    },
                    success: function () {
                    }
                });
          {
             // location.reload();
          }
        });




    });

    $(function ($) {
        var valueList=[];
        $('#saveStudies').click(function () {

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
                }
            });}catch (e){}
      location.reload();
        });


    })





})(jQuery);


