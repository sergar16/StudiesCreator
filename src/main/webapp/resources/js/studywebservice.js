var host = "http://46.137.108.187";
//http://localhost:8082
(function ($) {

    $(function ($) {

        $('#Conditions').on('click', 'tr td:last-child .close', function (e) {
            console.log('ID', $(this).data('id'));
            if ($('#Conditions tbody tr').length > 2) {
            $(this).closest('tr').remove();
            }
        });


    });

    $(function ($) {

        $('#DCM').on('click', '.destroy', function (e) {
            console.log('ID', $(this).data('id'));

            if ($('#DCM tr').length > 2) {
                $(this).closest('tr').remove();
                console.log("row deleted");
           }
        });


    });

    $(function ($) {
        var studyID;
        var conditions=[];
        $('#saveStudy').click(function () {

            $('#Conditions tbody tr:not(:first-child)').each(function () {
                 studyID=this.id;
                var value = this.cells[1].firstChild.value;
                var name = this.cells[0].children[0].value;
                var data = {name:name,value:value};
                console.log(data);
                conditions.push(data);
            });
            var dcm=[];

            $('#DCM tbody tr:not(:first-child)').each(function () {
                console.log(this.cells[this.cells.length-1]);
                console.log(this);
                var id = this.id;
                console.log(id);
              //  var key = this.cells[0].firstChild.value;
                var key = this.cells[0].children[0].value;
                var source = this.cells[1].firstChild.value;
                var sampling = this.cells[2].firstChild.value;
                var data = {key:key,source:source,sampling:sampling};
                console.log(data);
                dcm.push(data);
            });
            console.log(conditions, dcm);
            $.ajax({
                url: host + '/service/study/update/'+studyID+'/' + JSON.stringify({conditions:conditions,dcm:dcm}),
                type: 'POST',
                data: {

                },
                success: function () {
                }
            });
        });


    })


})(jQuery);


