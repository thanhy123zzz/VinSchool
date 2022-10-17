$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();

    $('.Btn-confirm-admission').on('click', function (event) {
        $('.messPaymet').modal();
    });

    // $('.table .btnEditUser').on('click', function (event) {
    //     event.preventDefault();
    //     var href = $(this).attr('href');
    //     $.get(href, function (admin, status) {
    //         $('.form-editUser #fullname').val(admin.fullname);
    //         $('.form-editUser #email').val(admin.email);
    //         $('.form-editUser #phonenumber').val(admin.phonenumber);
    //         $('.form-editUser #gender').val(admin.gender);
    //         $('.form-editUser #birthday').val(admin.birthday);
    //         $('.form-editUser #citizenId').val(admin.citizenId);
    //         $('.form-editUser #TaiKhoan').val(admin.getTaiKhoan());
    //     });
    //     $('#editAccount').modal(); // id modal
    // });

    // $('.table .btnRemove-User').on('click', function (event) {
    //     event.preventDefault();
    //     var href = $(this).attr('href'); // Phương thức attr () đặt hoặc trả về các thuộc tính và giá trị của các phần tử đã chọn.
    //     $('#removeaccount #btnDel-User').attr('href', href);
    //     $('#removeaccount').modal(); // id modal
    // });
});