/**
 * js in login page. 
 */
$(document).ready(function(){
	var showPass = 0;
	$('.btn-show-pass').on('click', function(){
		if(showPass == 0) {
			$(this).next('input').attr('type','text');
			$(this).find('i').removeClass('mdi-eye');
			$(this).find('i').addClass('mdi-eye-off');
			showPass = 1;
		}
		else {
			$(this).next('input').attr('type','password');
			$(this).find('i').addClass('mdi-eye');
			$(this).find('i').removeClass('mdi-eye-off');
			showPass = 0;
		}
	
	});
	
	$('.bb-form-btn').click(function() {
		if(!$('input[name="username"]').val()) {
			$('.txt1').text('请输入用户名！');
			$('input[name="username"]').focus();
			return false;
		}
		if(!$('input[name="password"]').val()) {
			$('.txt1').text('请输入密码！');
			$('input[name="password"]').focus();
			return false;
		}
	});
	
	
});