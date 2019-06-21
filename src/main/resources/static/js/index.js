// index.js


$(function(){




//一、user_login_box(用户登陆)------------------------------------------------------------------

	$(document).click(function(){		//页面点击 隐藏
		$(".user_login_box").hide();
		$(".user_login").removeClass("btn_active");
	})
	 $(".user_login,.user_login_box").click(function(event){
		event.stopPropagation();		//阻止默认事件
	})
	 $(".user_login").each(function(){
		$(this).click(function(){
			$(this).toggleClass("btn_active");
			$(this).next().toggle();						//显示和隐藏 切换
			$(this).parent().siblings().find(".user_login_box").hide();
		})
	})




//主菜单--------------------------------------------------------------------------------------
	
	var index_1=0;				   //鼠标移入的序列号	

	//鼠标移入主菜单----------------------------------------------
	$("ul.navigation li a").hover(function(){
		$("ul.navigation li a").removeClass("on");
		$(this).addClass("on");
		audioPlayer();	
	},function(){
		$("#audioPlayer")[0].pause();
	});

	$("ul.navigation li a").hover(function(){	//鼠标移入
		index_1=$(this).parent().index();		
		$(".sub_nav ul .sub_list p").eq(index_1).stop(true,true).show(600).siblings().hide();
		audioPlayer();
	},function(){
		$("#audioPlayer")[0].pause();		
	});

	//hover音效
	function audioPlayer(){
		$("#audioPlayer").attr({"src":"/wp-content/uploads/2015/01/3.mp3"});
		$("#audioPlayer")[0].play();	
		$("#audioPlayer")[0].volume="0.5";	
	};
	
	

	//主菜单解决bug-------------------------------------------
	//解决 非火狐、非谷歌的兼容性      判断浏览器类型及版本号
	$.browser.mozilla = /firefox/.test(navigator.userAgent.toLowerCase()); 
	$.browser.webkit = /webkit/.test(navigator.userAgent.toLowerCase()); 
	$.browser.opera = /opera/.test(navigator.userAgent.toLowerCase()); 
	$.browser.msie = /msie/.test(navigator.userAgent.toLowerCase()); 
	
	//判断是webkit且版本小于35.0的(360-7.1)   或者    是IE浏览器
	if(($.browser.webkit&&parseFloat($.browser.version)<35)||$.browser.msie){
		$("#main_nav li a").css({"transition":"none",background:"none","transform":"rotateX(0deg)"});
		$("#main_nav li a").find("span:last-child").css({display:"none"});
		$("#main_nav li a").click(function(){
			$(this).css({background:"none","transform":"rotateX(0deg)"});
		});
		$("#main_nav li a").mouseover(function(){
			$(this).css({background:"none","transform":"rotateX(0deg)"});
		});
	}//主菜单解决bug-------------------------------------------
	
	

//三、二级菜单，当滚动条滚到一定距离，让它相对浏览器定位(fixed)---------------------------------
	if($(".sub_nav").length>0){					//获取二级菜单到顶部的距离
		var navTop = $(".sub_nav").offset().top - $('.sub_nav').height()/5;
		$(window).scroll(function(){
			if ($(window).scrollTop() >= navTop) {
				$(".sub_nav").addClass("fixed");
				$(".sub_nav ul li a.smallogo").css({opacity:1});
				/*$(".main_banner").css({background:"#112233"});#d1d6da*/  //轮播图背景
			} else {
				$(".sub_nav").removeClass("fixed");
				$(".sub_nav ul li a.smallogo").css({opacity:0});
				/*$(".main_banner").css({background:""});*/
			}
		});
	}
	

//五、轮播图-------------------------------------------------------------------------------------
	
	var len=$(".main_banner li").length;
	var index_2=0;
	var timer=800;
	var intervaltimer=0;
	var isMoving=false;
	
	function slide(slideMode){//轮播方法		
		if (isMoving==false){
			isMoving=true;
			var prev; var next; var hidden;
			var curr=$("#imgCard"+index_2);//当前正中显示
			
			if(index_2==0){								//当前正中显示的是第0张时 prev为最后一张
				prev=$("#imgCard"+(len-1));					
			}else{												//否则  序列号-1
				prev=$("#imgCard"+(index_2-1)); 		
			}
			if(index_2==(len-1)){					//当前正中显示的是最后一张时 next为第0张
				next=$("#imgCard0");
			}else{											//否则  序列号+1
				next=$("#imgCard"+(index_2+1));
			}
	
			if(slideMode){			//slideMode为1(true)，执行slide(1)，上一张
				if(index_2-2>=0){									//index_2						2		3		4
					hidden=$("#imgCard"+(index_2-2));//									0		1		2
				}else{													//index_2		0		1
					hidden=$("#imgCard"+(len+index_2-2));//			3		4
				}
				prev.css("z-index","5");			//点击prev按钮  让prev位置上的这张图片 层级最高 显示
				next.css("z-index","1");
				curr.css("z-index","2");			
				hidden.css("z-index","1");
				//当index_2自减，各图片往右运动效果
				hidden.css({width:"450px",height:"180px",top:"60px","left":"0px","opacity":0});
				hidden.stop(true,true).animate({width:"580px",height:"240px",top:"20px",left:"0px",opacity:1},timer);
				curr.stop(true,true).animate({width:"580px",height:"240px",top:"20px",left:"600px",opacity:1},timer);
				next.stop(true,true).animate({width:"450px",height:"180px",top:"60px","left":"730px","opacity":0},timer,function(){next.find("span").css("opacity",0); isMoving = false;});
				//prev  -->  curr     prev中的图片li轮换到curr的位置      其他一次轮换
				prev.find("span").css("opacity",0);
				$(".main_banner_box li").find("p").css({"bottom":"-50px"});//所有标题隐藏
				prev.stop(true,true).animate({width:"670px",height:"280px",left:"255px",top:0,opacity:1},timer,function(){
					$(this).find("p").animate({"bottom":"0px"});	//当前这张图片的标题运动出来
				});
				index_2--;
			}else{			//执行next 操作
				if(index_2+2>=len){								//index_2								3		4	
					hidden=$("#imgCard"+(index_2+2-len));//										0		1
				}else{													//index_2		0		1		2
					hidden=$("#imgCard"+(index_2+2));//						2		3		4
				}
				prev.css("z-index","1");
				next.css("z-index","5");			//点击next按钮  让next位置上的这张图片 层级最高 显示
				curr.css("z-index","2");
				hidden.css("z-index","1");
				//当index_2自增，各图片往左运动效果
				hidden.css({width:"450px",height:"180px",top:"60px","left":"730px","opacity":0});
				hidden.stop(true,true).animate({width:"580px",height:"240px",top:"20px",left:"600px",opacity:1},timer);							
				curr.stop(true,true).animate({width:"580px",height:"240px",top:"20px",left:"0px",opacity:1},timer);
				//next  -->  curr     next中的图片li轮换到curr的位置      其他一次轮换
				next.find("span").css("opacity",0);
				$(".main_banner_box li").find("p").css({"bottom":"-50px"});//所有标题隐藏
				next.stop(true,true).animate({width:"670px",height:"280px",left:"255px",top:0,opacity:1},timer,function(){
					$(this).find("p").animate({"bottom":"0px"});	//当前这张图片的标题运动出来
				});
				prev.stop(true,true).animate({width:"450px",height:"180px",left:"0px",top:"60px",opacity:0},timer,function(){
					isMoving = false;
				}); 
				index_2++;	
			}//if else
	
			hidden.find("span").css("opacity",0.5);
			curr.find("span").css("opacity",0.5);
	
			if(index_2==len) index_2=0;
			if(index_2<0) index_2=len+index_2;			//限制index_2的范围
			$(".btn_list span").removeClass('curr').eq(index_2).addClass('curr');//给序列号按钮添加、移除样式
		}
	}//slide()


	if(len>3){
		//序列号按钮 跳序切换 方法
		$(".btn_list span").click(function(event){
			
			if (isMoving ) return;
			var oIndex=$(this).index();
	
			if(oIndex==index_2) return;//点击按钮的序列号与当前图片的序列号一致，return
			clearInterval(intervaltimer)
			intervaltimer=null;
	
			var flag=false;
			//当前显示图片的序列号  和  被点击按钮的序列号  间隔超过1且不是首尾两个的时候
			if(Math.abs(index_2-oIndex)>1&&Math.abs(len-Math.abs(index_2-oIndex))!=1){
				//统一样式
				$(".main_banner_box li").css({width:"300px",height:"120px",left:"600px",top:"60px",opacity:0});
				//如果当前的序列号   比    被点击按钮序列号     大     而且     不相邻、不是首尾  
				if(index_2>oIndex&&len-Math.abs(index_2-oIndex)!=1){
					flag=true;
					index_2=oIndex+1;		//oIndex+1    通过slide()  运动回上一张    oIndex
				}else{//比   小     而且     不相邻、不是首尾
					index_2=oIndex-1;		//oIndex-1     通过slide()  运动到下一张    oIndex
					if(index_2<0) index_2=len-1;
				}
			}else{//当前 比 被点击  大	且   相邻									//从0    跳到     4		要执行上一张方法
				if((index_2>oIndex&&len-(index_2-oIndex)!=1)||(index_2<oIndex&&len+(index_2-oIndex)==1)){
					flag=true;			//执行上一张
				}
			}
			slide(flag);
			intervaltimer=setInterval(slide,3000);//自动轮播
			
		});
	
		$(".main_banner_box li").on("mousemove",function(){
			if($(this).css("width")=="670px"){//鼠标移入为当前正中显示的图片li，则清除定时器
				clearInterval(intervaltimer);
				intervaltimer=null;
			}
		}).on("mouseout",function(){//鼠标移除重新滚动
				clearInterval(intervaltimer);
				intervaltimer=null;
				intervaltimer=setInterval(slide,3000);
		});
		
		$(".js_pre").click(function(event){//上一张
			if (isMoving ) return;
			clearInterval(intervaltimer);
			intervaltimer=null;
			slide(1);
			intervaltimer=setInterval(slide,3000);
		});
	
		$(".js_next").click(function(event){//下一张
			if (isMoving ) return;
			clearInterval(intervaltimer);
			intervaltimer=null;
			slide();
			intervaltimer=setInterval(slide,3000);        
		});
		
		intervaltimer=setInterval(slide,3000);
		
	}else{
		
		$(".js_pre").hide();
		$(".js_next").hide();
		
	}//if else
	


	
//七、MV首播-----------------------------------------------------------------------------------
	var index_3=0;					//MV首播按钮序列号
	var index_33=0;				//首发MV按钮序列号（MV页面）
	var index_333=0;				//热门MV按钮序列号（MV页面）
	var cont_1=$(".index_mv_body .mvList");
	var cont_2=$(".shoufa_mv_body .mvList");
	var cont_3=$(".hot_mv_body .mvList");
	
	//MV首播 (首页)-------------------------------------
	$(".index_mv_title ul li").click(function(){	//选项卡
		index_3=$(this).index();
		mvSlide($(this),index_3,cont_1);
	});
	
	//首发MV (MV页面)--------------------------------
	$(".shoufa_mv_title ul li").click(function(){	//选项卡
		index_33=$(this).index();
		mvSlide($(this),index_33,cont_2);
	});
	
	//热门MV（MV页面）------------------------------------
	$(".hot_mv_title ul li").click(function(){	//选项卡
		index_333=$(this).index();
		mvSlide($(this),index_333,cont_3);
	});
	
	//封装MV列表切换效果，共用
	function mvSlide(btn,n,cont){
		btn.find("a").addClass("cur").parent().siblings().find("a").removeClass("cur");
		cont.eq(n).fadeIn().siblings("div").fadeOut();	
		cont.eq(n).addClass("curShow").siblings().removeClass("curShow");	
	}

	var iHtml = "<b></b>";
	$(".index_mv_body .mvList ul.sb li").eq(0).append(iHtml);
	$(".index_mv_body .mvList ul.sb li").eq(1).append(iHtml);
	$(".shoufa_mv_body .mvList ul.sb li").eq(0).append(iHtml);
	$(".shoufa_mv_body .mvList ul.sb li").eq(1).append(iHtml);
	



	//排行榜-----------------

	// $("#rank li").eq(0).find("a.musicName").prepend("<i class='first_place'>1</i>");
	// $("#rank li").eq(1).find("a.musicName").prepend("<i class='second_place'>2</i>");
	// $("#rank li").eq(2).find("a.musicName").prepend("<i class='third_place'>3</i>");
	for(var r=0;r<9;r++){
		$("#rank li").eq(r).find("a.musicName").prepend(" " + (r + 1) + "  ");
	}
    for(var k=0;k<9;k++){
		$("#latest li").eq(k).find("a.musicName").prepend(" " + (k + 1) + "  ");
	}
	for (var p=0;p<9;p++){
		$("#popular li").eq(p).find("a.musicName").prepend(" " + (p + 1) + "  ");
	}


	
//九、精选集-------------------------------------------------------------------------------
	var oList_omnibus=document.getElementById("omnibus_list");
	var oI=oList_omnibus.getElementsByTagName("i")[0];
	var aSpan=oList_omnibus.getElementsByTagName("span");
	$("#omnibus_list .post_big a").hover(function(){
		$(this).find("i").stop(true,true).animate({left:"0px"},300);
	},function(){
		$(this).find("i").stop(true,true).animate({left:"305px"},300,function(){
			oI.style.left="-305px";
		});
	});
	$("#omnibus_list .post_small a").hover(function(){
		$(this).find("span").stop(true,true).animate({left:"0px"},300);
	},function(){
		$(this).find("span").stop(true,true).animate({left:"130px"},300,function(){
			for(var i=0; i<aSpan.length; i++){
				aSpan[i].style.left="-130px";
			}
		});
		
	});
	
	
	
	

});//$(function(){});        window.onload







//十、回到顶部---------------------------------------------------------------------------
	$("#toTop").click(function(){
		$("html,body").animate({scrollTop: "0px"},"slow");
		//点击音效
		$("#audioPlayer").attr({"src":"/wp-content/uploads/2015/01/1.mp3"});
		$("#audioPlayer")[0].play();
	});
	
	//二维码
	$(".footer_cont_right a.twoCode").hover(function(){
			$(this).find("img.tCode").stop(true, true).fadeIn();
		},function(){
			$(this).find("img.tCode").stop(true, true).delay(800).fadeOut();
	});
	
	
	
	
// mv页.js

//十一、MV页面 js-------------------------------------------------------------------------
	
	// $("#mv_rank_list ul li").hover(function(){
	// 	$(this).css({"z-index":"6"}).stop(true,true).animate({"left":"-10px","opacity":"1"},350).siblings().css({"z-index":"1"}).stop(true,true).animate({"left":"0px","opacity":"0.5"},350);
	// 	},function(){
	// 	$("#mv_rank_list ul li").css({"z-index":"1"}).stop(true,true).animate({"left":"0px","opacity":"1"},350);
	// });

	$("#mv_classify_list ul li").hover(function(){
		$(this).stop(true,true).animate({"opacity":"1"},350).siblings().stop(true,true).animate({"opacity":"0.5"},350);
		},function(){
		$("#mv_classify_list ul li").stop(true,true).animate({"opacity":"1"},350);
	});
	
	
	$("#mvList .mv_rcmd").click(function(){
		var index_mv_rcmd1=$(this).index();
		$(this).find("span").addClass("active").parent().siblings("li").find("span").removeClass("active");
		$(this).find("i").addClass("on").parent().siblings("li").find("i").removeClass("on");	
	});



//十二、MV视频播放器---------------------------------------------------------------------------------------------------
	//数组 保存 MV.url
	var arrSongs = ["http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",
	"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",
	"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"]
	
	//爱情大师 - 崔子格       匆匆那年 - 王菲        喜欢你 - 邓紫棋
	$("#mvList li.mv_rcmd").click(function(){
		var _index_songs=$(this).index();
		video[0].src=arrSongs[_index_songs];
		video[0].play();	
		$(".playPause").css({"backgroundPosition":"-54px -10px"});
	});
	$("#mv_rank_list ul li").click(function(){
		var index_mv_rcmd2=$(this).index();
		video[0].src=arrSongs[index_mv_rcmd2];
		video[0].play();
		$(".playPause").css({"backgroundPosition":"-54px -10px"});
	});



	//MV视频播放器
	var video=$("#video");
	//video[0].volume="0.5";
	//播放暂停
	$(".playPause").click(function(){
		if(video[0].paused){		//video 要带上 [0]
			video[0].play();
			$(this).css({"backgroundPosition":"-54px -10px"});
		}else{
			video[0].pause();
			$(this).css({"backgroundPosition":"-12px -10px"});
		}
		return false;
	});
	
	//获取总时长 与 获取当前播放时间
	video.on("loadedmetadata",function(){
		var dur=changeTime(video[0].duration);
		$(".duration").text(dur);
	});
	video.on("timeupdate",function(){
		var cur=changeTime(video[0].currentTime);
		$(".current").text(cur);

		var cur_pos=video[0].currentTime; //当前播放时间
		var dur_max=video[0].duration; //总时长，两者相除 求比例	
		var scale=100*cur_pos/dur_max; 
		$(".timeBar").css("width",scale+"%");
	});

	//把获取的时间(单位为毫秒) 转化成秒 方法
	function changeTime(time){
		iNum=parseInt(time);
		var iM=toZero(Math.floor(time/60));
		var iS=toZero(Math.floor(time%60));
		return iM+":"+iS;
	}
	//补零
	function toZero(num){
		return num<=9?"0"+num:""+num;
	}

	//点击或拖动进度条
	var timeDrag=false;   /* 拖动状态 */
	$(".progressBar").mousedown(function(e){
	   timeDrag=true;
	   updatebar(e.pageX);
	});
	$(document).mouseup(function(e){
	   if(timeDrag){
		  timeDrag=false;
		  updatebar(e.pageX);
	   }
	});
	$(document).mousemove(function(e){
	   if(timeDrag){
		  updatebar(e.pageX);
	   }
	});
	 
	//进度条 操作
	var updatebar=function(x){
	var progress=$(".progressBar");
	var maxduration=video[0].duration; //总时间
	var position=x-progress.offset().left; //点击或拖动的位置
	var percentage=100*position/progress.width();

	//限制拖动范围
	if(percentage>100){
		percentage=100;
	}
	if(percentage<0){
		percentage=0;
	}
 
	//拖动滚动条 currenttime 相应变化
	$(".timeBar").css("width",percentage+"%");
		video[0].currentTime=maxduration*percentage/100;
	};


	//缓冲加载条
	var startBuffer=function(){
		var maxduration=video[0].duration;
		var currentBuffer=video[0].buffered.end(0);
		var percentage=100*currentBuffer/maxduration;
		$(".bufferBar").css("width",percentage+"%");

		if(currentBuffer<maxduration){
			setTimeout(startBuffer,500);
		}
	};
	setTimeout(startBuffer,500);


	//静音按钮
	$(".muted").click(function(){
		if(video[0].muted){
			$(this).css({"backgroundPosition":"-88px -10px"});
			video[0].muted=false;
		}else{
			$(this).css({"backgroundPosition":"-126px -10px"});
			video[0].muted=true;
		}
		return false;
	});

	//音量条 点击或拖动
	var timeDrag2=false;   /* 拖动状态 */
	$(".volumeBar").mousedown(function(e){
		timeDrag2=true;
		updatebar2(e.pageX);
	});
	$(document).mouseup(function(e){
		if(timeDrag2){
			timeDrag2=false;
			updatebar2(e.pageX);
		}
	});
	$(document).mousemove(function(e){
		if(timeDrag2){
			updatebar2(e.pageX);
		}
	});
	 
	//音量条 操作
	var updatebar2=function(x){
		var progress=$(".volumeBar");
		var maxduration=video[0].duration; //总时间
		var position=x-progress.offset().left; //点击或拖动的位置
		var percentage=100*position/progress.width();
	 
		//限制范围
		if(percentage>100){
			percentage=100;
		}
		if(percentage<0){
			percentage=0;
		}
	 
	//拖动滚动条 currenttime 相应变化
	$(".volume").css("width",percentage+"%");
		video[0].volume=percentage/100;
	};

	//全屏
	$(".fullscreen").on("click",function(){
		//兼容写法
		video[0].RequestFullScreen=video[0].RequestFullScreen||video[0].webkitRequestFullScreen||video[0].mozRequestFullScreen;
		//调用全屏方法
		video[0].RequestFullScreen();
		return false;
	});