//文档加载完毕后执行
$(function() {
	//获取最新文章
      $.ajax({
        url: "././post/getNewPost",
        type: "GET",
        data: {
        },
		dataType: "json",
        cache: false,
        success: function(json) {
          // Success message
		  alert(json);
          //登陆成功，设置跳转页面
		  if(json.code == 1){
		  $('location').prop('index.html');
		  }
		  message(json.context);
        },
        error: function() {
          // Fail message
          message("Sorry " + username + ", it seems that my mail server is not responding. Please try again later!*_*")
        },
        complete: function() {
          setTimeout(function() {
            $this.prop("disabled", false); // Re-enable submit button when AJAX call is complete
          }, 1000);
        }
      });
	  //获取所有标签
	  $.ajax({
        url: "././Tag/getTag",
        type: "GET",
        data: {
        },
		dataType: "json",
        cache: false,
        success: function(json) {
          // Success message
		  alert(json);
          //登陆成功，设置跳转页面
		  if(json.code == 1){
		  $('location').prop('index.html');
		  }
		  message(json.context);
        },
        error: function() {
          // Fail message
          message("Sorry " + username + ", it seems that my mail server is not responding. Please try again later!*_*")
        },
        complete: function() {
          setTimeout(function() {
            $this.prop("disabled", false); // Re-enable submit button when AJAX call is complete
          }, 1000);
        }
      });
	  //获取登录用户的信息
	  $.ajax({
        url: "././User/getLoginUser",
        type: "GET",
        data: {
        },
		dataType: "json",
        cache: false,
        success: function(json) {
          // Success message
		  alert(json);
          //登陆成功，设置跳转页面
		  if(json.code == 1){
		  $('location').prop('index.html');
		  }
		  message(json.context);
        },
        error: function() {
          // Fail message
          message("Sorry " + username + ", it seems that my mail server is not responding. Please try again later!*_*")
        },
        complete: function() {
          setTimeout(function() {
            $this.prop("disabled", false); // Re-enable submit button when AJAX call is complete
          }, 1000);
        }
      });
 });
