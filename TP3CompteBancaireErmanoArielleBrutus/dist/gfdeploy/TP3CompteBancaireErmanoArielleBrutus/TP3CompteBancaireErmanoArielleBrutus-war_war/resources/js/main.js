/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function ($) {
    "use strict"; // Start of use strict


    $(document).ready(function () {
        $('select').select2();
        $('.dataTable').DataTable();

        div_debit_trans_toggle();

        $(".s_type_transaction").change(function () {
            div_debit_trans_toggle();
        });


    });

    function div_debit_trans_toggle() {
        if ($(".s_type_transaction").val() == 1) {
            $("#div_debit_trans").hide();
        } else {
            $("#div_debit_trans").show();
        }
    }


})(jQuery); // End of use strict

