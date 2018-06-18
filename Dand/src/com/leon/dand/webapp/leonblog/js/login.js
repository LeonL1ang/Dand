//提示信息页面显示函数
function message(str){
	$('#success').html("<div class='alert alert-danger'>");
          $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
            .append("</button>");
          $('#success > .alert-danger').append($("<strong>").text(str));
          $('#success > .alert-danger').append('</div>');
          //clear all fields
          $('#contactForm').trigger("reset");
}
//文档加载完毕后执行
$(function() {

  $("#contactForm input").jqBootstrapValidation({
    preventSubmit: true,
    submitError: function($form, event, errors) {
      // additional error messages or events
    },
    submitSuccess: function($form, event) {
      event.preventDefault(); // prevent default submit behaviour
      // get values from FORM
      var email = $("input#email").val();
      var password = $("input#password").val();
      // Check for white space in name for Success/Fail message
      //if (firstName.indexOf(' ') >= 0) {
     //   firstName = name.split(' ').slice(0, -1).join(' ');
      //}
      $this = $("#sendMessageButton");
      $this.prop("disabled", true); // Disable submit button until AJAX call is complete to prevent duplicate messages
      $.ajax({
        url: "././mail/contact_me.php",
        type: "POST",
        data: {
          email: email,
          password: password
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
    },
    filter: function() {
      return $(this).is(":visible");
    },
  });

  $("a[data-toggle=\"tab\"]").click(function(e) {
    e.preventDefault();
    $(this).tab("show");
  });
});

/*When clicking on Full hide fail/success boxes */
$('#name').focus(function() {
  $('#success').html('');
});
