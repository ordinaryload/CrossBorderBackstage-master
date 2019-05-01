var baseurl ="http://localhost:8080/CrossBorderBackstage/";

function Userlogin(username,password,power) {
    $.ajax({
        url: baseurl +"user/login",
        type:'post',
        contentType:"application/json",
        data:JSON.stringify({
            'username':username,
            'password':password,
            'power':power
        }),
        success:function (data) {
            console.log(data);
        },
        error:function (data) {
            console.log('url有误');
        }
    })
}

function Userexit() {
    $.ajax({
        url: baseurl +"User/exit",
        type:'post',
        success:function (data) {
            console.log(data);
        },
        error:function (data) {
            console.log('url有误');
        }
    })
}

function UserchangePassword(oldPWD,newPWD){
    $.ajax({
        url: baseurl +"User/changePassword",
        type:'post',
        data:{
            'oldPWD':oldPWD,
            'newPWD':newPWD
        },
        success:function (data) {
            console.log(data);
        },
        error:function (data) {
            console.log('url有误');
        }
    })
}
function UserchangeDepartment(newDepartment){
    $.ajax({
        url: baseurl +"User/changeDepartment",
        type:'post',
        data:{
            'newDepartment':newDepartment
        },
        success:function (data) {
            console.log(data);
        },
        error:function (data) {
            console.log('url有误');
        }
    })
}

function getUserinfo(){
    $.ajax({
        url: baseurl +"user/userinfo",
        type:'get',
        success:function (data) {
            console.log(data);
        }
    })
}
$("#btn-login").on('click',function () {
    Userlogin('account','a123456','0');
    //test
})

$("#btn-exit").on('click', function () {
    Userexit();
})

$("#btn-test").on('click', function () {
    // UserchangePassword('a123456','a10010');
    // UserchangeDepartment("外语院");
    getUserinfo();
})