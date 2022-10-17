function FormValidate(event) {
    var nameParent = document.getElementById('fullname').value;
    var errorNameparent = document.getElementById('errorNameparent');

    var phone = document.getElementById('phonenumber').value;
    var errorPhone = document.getElementById('errorPhone');

    var address = document.getElementById('address').value;
    var errorAddress = document.getElementById('errorAddress');

    var workUnit = document.getElementById('wokingAt').value;
    var errorWorkunit = document.getElementById('errorWorkunit');

    var email = document.getElementById('email').value;
    var errorEmail = document.getElementById('errorEmail');

    var nameBaby = document.getElementById('fullnameBaby').value;
    var errorNamebaby = document.getElementById('errorNamebaby');

    var regexName = /^[a-zA-Z!@#\$%\^\&*\)\(+=._-]{2,}$/g;

    var regexAddress = /^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s]+)$/i;

    var regexPhone = /[0]{1}[2-9]{1}[0-9]{8}/;

    var reGexEmail = /[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}/;

    /*
    if ((nameParent !== '' || nameParent !== null) && (nameBaby !== '' || nameBaby !== null) &&
        (phone !== '' || phone !== null) && (email !== '' || email !== null)
        && (workUnit !== '' || workUnit !== null) && (address !== '' || address !== null)) {
        return true;
    }else{
        errorNameparent.innerHTML = "Trường này không được trống.";
        errorPhone.innerHTML = "Trường này không được trống.";
        errorAddress.innerHTML = "Trường này không được trống.";
        errorWorkunit.innerHTML = "Trường này không được trống.";
        errorEmail.innerHTML = "Trường này không được trống.";
        errorNamebaby.innerHTML = "Trường này không được trống.";
        return false;
    } */
    //
    if (nameParent === '' || nameParent === null) {
        errorNameparent.innerHTML = "Trường này không được trống.";
        //event.preventDefault();
        return false;
    } else if (!regexName.test(nameParent)) {
        errorNameparent.innerHTML = "Họ và tên phụ huynh không hợp lệ!";
        //event.preventDefault();
        return false;
    } else {
        errorNameparent.innerHTML = '';
    }

    if (phone === '' || phone === null) {
        errorPhone.innerHTML = "Trường này không được trống.";
        //event.preventDefault();
        return false;
    } else if (!regexPhone.test(phone)) {
        errorPhone.innerHTML = "Số điện thoại không hợp lệ!";
        //event.preventDefault();
        return false;
    } else {
        errorPhone.innerHTML = '';
    }

    if (address === '' || address === null) {
        errorAddress.innerHTML = "Trường này không được trống.";
        //event.preventDefault();
        return false;
    } else if (!regexAddress.test(address)) {
        errorAddress.innerHTML = "Địa chỉ không hợp lệ!";
        //preventDefault();
        return false;
    } else {
        errorAddress.innerHTML = '';
    }

    if (workUnit === '' || workUnit === null) {
        errorWorkunit.innerHTML = "Trường này không được trống.";
        //event.preventDefault();
        return false;
    } else if (!regexAddress.test(address)) {
        errorWorkunit.innerHTML = "Đơn vị công tác không hợp lệ!";
        //preventDefault();
        return false;
    } else {
        errorWorkunit.innerHTML = '';
    }

    if (email === '' || email === null) {
        errorEmail.innerHTML = "Trường này không được trống.";
        //event.preventDefault();
        return false;
    } else if (!reGexEmail.test(email)) {
        errorEmail.innerHTML = "Email không hợp lệ!";
        //preventDefault();
        return false;
    } else {
        errorEmail.innerHTML = '';
    }
    
    if (nameBaby === '' || nameBaby === null) {
        errorNamebaby.innerHTML = "Trường này không được trống.";
        //event.preventDefault();
        return false;
    } else if (!regexName.test(nameParent)) {
        errorNamebaby.innerHTML = "Họ và tên bé không hợp lệ!";
        //event.preventDefault();
        return false;
    } else {
        errorNamebaby.innerHTML = '';
    }

}