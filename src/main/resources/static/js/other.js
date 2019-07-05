var myPlaylist = new jPlayerPlaylist({
        jPlayer: "#jquery_jplayer_N",
        cssSelectorAncestor: "#jp_container_N"
    },
    [
        {
            title: "Ellens Gesang III D839",
            artist: "Geoffrey Parsons",
            mp3: "http://music.163.com/song/media/outer/url?id=16691428.mp3  ",
            poster: "http://p1.music.126.net/wAIlwR4SxuZg_ZMwgmSYcg==/3386495814257726.jpg?param=130y130"
        },
        {
            title: "默",
            artist: "那英",
            mp3: "http://music.163.com/song/media/outer/url?id=31473269.mp3 ",
            poster: "http://p1.music.126.net/OCGt5ln0lPPtPbVJ3VEKtA==/109951163020570422.jpg?param=130y130"
        },
        {
            title: "Fire",
            artist: "Said The Sky",
            mp3: "http://music.163.com/song/media/outer/url?id=435289279.mp3",
            poster: "http://p1.music.126.net/tg2zke_mrqwuOPlEIEUjGg==/18294773975127592.jpg?param=130y130"
        }
    ],

    {
        playlistOptions: {enableRemoveControls: true},
        swfPath: "js/",
        supplied: "webmv, ogv, m4v, oga, mp3",
        useStateClassSkin: true,
        autoBlur: false,
        smoothPlayBar: true,
        keyEnabled: true,
        audioFullScreen: true
    });
//移除
$("#playlist-remove").click(function () {
    myPlaylist.remove();		//（0 1 2 ... -2 -1）
});

$("#listRemove").click(function () {
    myPlaylist.remove();
});

// 上一曲、下一曲

$("#playlist-next").click(function () {
    myPlaylist.next();
});
$("#playlist-previous").click(function () {
    myPlaylist.previous();
});

// 播放
$("#playlist-play").click(function () {
    myPlaylist.play();
});

$("#playlist-play--2").click(function () {
    myPlaylist.play(-2);
});
$("#playlist-play--1").click(function () {
    myPlaylist.play(-1);
});
$("#playlist-play-0").click(function () {
    myPlaylist.play(0);
});
$("#playlist-play-1").click(function () {
    myPlaylist.play(1);
});
$("#playlist-play-2").click(function () {
    myPlaylist.play(2);
});

// 暂停

$("#playlist-pause").click(function () {
    myPlaylist.pause();
});


//是否自动播放

$("#playlist-option-autoPlay-true").click(function () {
    myPlaylist.option("autoPlay", true);
});
$("#playlist-option-autoPlay-false").click(function () {
    myPlaylist.option("autoPlay", false);
});


//播放器列表滚动条js------------------------------------------------------------------------------------------------
var $bar = $(".bar");
var $scrollBar = $(".scrollBar");
var $maxH = $scrollBar.innerHeight() - $bar.outerHeight();
var $ul = $(".jp-playlist ul");
var $li = $(".jp-playlist ul li");
var disY = 0;
var iScale = 0;
var iSpeed = 0;

$ul.height(1000);		//设置ul的高度

$bar.mousedown(function (event) {
    var event = event || window.event;
    disY = event.clientY - $(this).position().top;
    $(document).bind("mousemove", function (event) {
        var event = event || window.event;
        var iH = event.clientY - disY;
        iH <= 0 && (iH = 0);
        iH >= $maxH && (iH = $maxH);
        $bar.css({top: iH + "px"});
        iScale = -iH / $maxH;
        $ul.css({top: iScale * ($ul.height() - $(".jp-playlist-box").height()) + "px"});
        return false;
    });
    $(document).bind("mouseup", function () {
        $(document).unbind("mousemove");
        $(document).unbind("mouseup");
    });
    return false;
});

//当鼠标移入，监听事件
$(".jp-playlist-box").mouseover(function () {
    //鼠标滚轮
    addHandler(this, "mousewheel", mouseWheel);//IE
    addHandler(this, "DOMMouseScroll", mouseWheel);//标准
    return false;
});

//绑定事件重写兼容
function addHandler(element, type, handler) {
    return element.addEventListener ? element.addEventListener(type, handler, false) :
        element.attachEvent("on" + type, handler, false)
}

//鼠标滚轮事件
function mouseWheel(event) {
    var event = event || window.event;
    if (event.wheelDelta) {//IE
        iSpeed = event.wheelDelta > 0 ? -3 : 3;
    } else if (event.detail) {//火孤
        iSpeed = event.detail < 0 ? -3 : 3;
    }
    move();

    //FF,绑定事件，阻止默认事件
    if (event.preventDefault) {
        event.preventDefault();
    }
};

//滚轮 要执行的
function move() {
    var iH = $bar.position().top;
    iH = iH + iSpeed;
    iH <= 0 && (iH = 0);
    iH >= $maxH && (iH = $maxH);
    $bar.css({top: iH + "px"});
    iScale = -iH / $maxH;
    $ul.css({top: iScale * ($ul.height() - $(".jp-playlist-box").height()) + "px"});
    return false;
};
//播放器列表滚动条js 结束------------------------------------------------


//音乐播放器 收缩、展开----------------------------------------------
var fold = true;//标识

//页面加载时，播放器运动出来，延迟2秒，运动回去
$(".jp-video").animate({left: 0}, "slow", function () {
    slideOut($(this));
}).delay(2000).animate({left: "-480px"}, 350, function () {
    slideIn($(this));
});

//点击按钮运动出来，或运动回去
$("#btnfold").mouseover(function () {
    if (fold) {
        $(".jp-video").animate({left: "-480px"}, 350, function () {
            slideIn($(this));
        });
    } else {
        $(".jp-video").animate({left: 0}, 350, function () {
            slideOut($(this));
        });
    }
});

//封装按钮背景切换1
function slideOut(obj) {
    $("#btnfold").attr({"title": "点击收缩"});
    obj.find("span").css({"transform": "rotate(180deg)"});
    obj.find("span").css({"MozTransform": "rotate(180deg) translateX(2px)"});
    obj.find("span").css({"WebkitTransform": "rotate(180deg)"});
    fold = true;
};

//封装按钮背景切换2
function slideIn(obj) {
    $("#btnfold").attr({"title": "点击展开"});
    obj.find("span").css({"transform": "rotate(0deg)"});
    obj.find("span").css({"MozTransform": "rotate(0deg) translateX(-2px)"});
    obj.find("span").css({"WebkitTransform": "rotate(0deg)"});
    fold = false;
};

//歌曲列表展开、收缩---------------------------------------------------
var iOpen = false;
$("#listClose").click(function () {
    if (iOpen) {
        $(".jp-playlist-box").animate({height: 0}, 100);
        $("#btnfold").css({top: "5px"});
        $("#listRemove").css({display: "none"});
        $(".scrollBar").css({display: "none"});
        $(".jp-video").animate({height: "94px", bottom: "20px"}, 100);
        iOpen = false;
    } else {
        $(".jp-playlist-box").animate({height: "80px"}, 100);
        $("#btnfold").css({top: "52px"});
        $("#listRemove").css({display: "block"});
        $(".scrollBar").css({display: "block"});
        $(".jp-video").animate({height: "175px", bottom: "20px"}, 100);
        iOpen = true;
    }
});