/*计算视频播放总时长*/
//获取元素
var video=$("video").get(0);//将jQuery对象转换为 Dom对象
//计算时分秒函数formatTime
function formatTime (time){
    var h = Math.floor(time / 3600);
    var m = Math.floor(time % 3600 /60);
    var s = Math.floor(time % 60);
    //00:00:00
    return (h < 10 ?"0" + h : h)+ ":" + (m<10 ? "0" +m : m) + ":" + (s<10?"0" + s :s);
    }
    //当浏览器可以播放视频的时候，就让video显示出来,同时显示出视频的总时长
    video.oncanplay =function () {
        $("video").show();
        var totalTime = formatTime(video.duration);
        $(".total").html(totalTime); //将计算出来的总时长放入页面中的元素中
    };

/*实现视频播放和暂停效果*/
$(".switch").on("click",function () {
    if ($(this).hasClass("fa-play")) {
        video.play(); //播放
        $(this).addClass("fa-pause").removeClass("fa-play"); //切换图标
    } else {
        video.pause();//暂停
        $(this).addClass("fa-play").removeClass("fa-pause"); //切换图标
    }
  });

/*快进和后退*/
$(".forward").on("click",function () {
    video.currentTime+=5;   //快进5s
});
$(".backward").on("click",function () {
    video.currentTime-=5;   //后退5s
});

/*实现进度条显示效果*/
video.ontimeupdate = function (){
    var w =video.currentTime / video.duration* 100 + "%";
    $ (".line").css ("width", w);
    $( ".current").html (formatTime(video.currentTime));
};


/*实现视频音量静音*/
range=document.getElementById('range');
range.onchange=function(){
    video.volume=range.value;
};
$(".volume").on( "click", function (){
    if ($(this).hasClass("fa-volume-off")) {
        video.muted=false; //不静音
        //video.volume=1;
        range.value=1;  //音量进度条100%
        $(this).addClass ("fa-volume-up").removeClass ("fa-volume-off");
    }
    else {
        video.muted=true; //静音
        //video.volume=0;
        range.value=0;   //音量进度条0%
        $(this).addClass("fa-volume-off").removeClass("fa-volume-up");
    }
});

/*实现视频全屏显示效果*/
$(".expand") .on ( "click", function (){
    if ($(this).hasClass("fa-arrows-alt")) {
        video.webkitRequestFullScreen();//全屏显示
    $(this).addClass ("fa-compress").removeClass ("fa-arrows-alt");
    }else {
        document.webkitCancelFullScreen();//取消全屏显示
        $(this).addClass("fa-arrows-alt").removeClass("fa-compress");
    }
});

/*实现视频播放完成后的重置操作*/
video.onended = function (){
    //将当前的视频时长清零
    video.currentTime =0;
    //同时将播放按钮改为.fa-play样式效果
    $(".switch") .addClass( "fa-play") .removeClass("fa-pause");
    };

/*实现单击进度条视频跳转效果*/
$ (".bar").on("click", function (event){
    //获取单击的位置
    var offset = event.offsetX;
   //根据单击视频的播放位置计算要切换的时间
    var current = offset/ $(this).width() * video.duration;
   //将计算后的时回赋值给currentTime
    video.currentTime = current;
});

/*使用Esc键退出全屏*/
function checkFull() {
    var isFull = document.webkitIsFullScreen;
    if (isFull === undefined) {
        isFull = false;
    }
    return isFull;
   }
       $(window).resize (function() {
           if (!checkFull()) { //退出全屏
               $(".expand").addClass("fa-arrows-alt").removeClass("fa-compress");
           }
       });

$(document).keypress (function (event) {
    var code = (event.keyCode ? event.keyCode : event.which);
    if (video != "" && (code == 13 || code == 32)) {
        if (video.paused) {
            video.play();
            $(".switch").addClass("fa-pause").removeClass("fa-play");
        } else {
            video.pause();
            $(".switch").addClass("fa-play").removeClass("fa-pause");
        }
    }
});








