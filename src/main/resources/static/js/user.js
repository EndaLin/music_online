//判断有没有登录
function islogin(){
    var username = getCookie("username");
    if(username !== null && username !== "undefined"){
        return true;
    }else{
        return false;
    }
}

//获取用户信息
function getUser(){
    var username = getCookie("username");
    user = {
        name:name
    };
    return user;
}

//写入信息
function login(username){
    setCookie("username",username);
}

//注销
function logout(){
    delCookie("username");
}

/**
 * Cookie的相关操作
 */

//设置cookies
function setCookie(name,value)
{
    var  Days = 1;//1天
    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString() + ";path=/";
}

//读取cookies
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");

    if(arr=document.cookie.match(reg))

        return unescape(arr[2]);
    else
        return null;
}

//删除cookies
function delCookie(name)
{
    document.cookie= name + "=0;expires=" + new Date(0).toUTCString() + ";path=/";
}
