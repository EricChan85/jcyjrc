/**
 * created by cyh
 */

$(function() {
	//顶部个人中心下拉框
    $('.header .personal').hover(function(){
        $('.header .userdetail').stop(true).show();
    },function(){
        $('.header .userdetail').stop(true).hide();
    });
});
