$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();

    $('.btnNew-User').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        // var text = $(this).text(); //return New or Edit addAccount
        $('#addAccount #fullname').val('');
        $('#addAccount #email').val('');
        $('#addAccount #phonenumber').val('');
        $('#addAccount #gender').val('');
        $('#addAccount #birthday').val('');
        $('#addAccount #citizenId').val('');
        $('#addAccount #TaiKhoan').val('');
        $('#addAccount').modal();
    });

    $('.table .btnEditUser').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (admin, status) {
            $('.form-editUser #id').val(admin.id);
            $('.form-editUser #fullname').val(admin.fullname);
            $('.form-editUser #email').val(admin.email);
            $('.form-editUser #phonenumber').val(admin.phonenumber);
            $('.form-editUser #gender').val(admin.gender);
            $('.form-editUser #birthday').val(admin.birthday);
            $('.form-editUser #citizenId').val(admin.citizenId);
            $('.form-editUser #TaiKhoan').val(admin.getTaiKhoan());
        });
        $('#editAccount').modal(); // id modal
    });

    $('.table .btnRemove-User').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href'); // Phương thức attr () đặt hoặc trả về các thuộc tính và giá trị của các phần tử đã chọn.
        $('#removeaccount #btnDel-User').attr('href', href);
        $('#removeaccount').modal(); // id modal
    });
});

function find(){
    var key = $('#searchAdmin').val();
    setTimeout(1000);
    $.ajax({
        type: "POST",
        url: "/manager/manager-user/searchAdmin",
        data: "key=" + key,
        success: function (data) {
            $('#reloaddbAdmin').replaceWith(data);
            $('#searchAdmin').val(key);
        },
        error: function (data) {
            alert("lỗi!");
        }
    });
}