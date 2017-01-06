function login(){
	//获取参数
	var phone = $.trim($("#phone").val());
	var password = $.trim($("#password").val());
		if(phone && password){
			$.ajax({
				url : serUrl+'login',
				data : {'phone': phone,'password': password},
				dataType : 'json',
				type:'POST',
				success : function(data) {
					if(data == "1" && data == "2"){
						alert("用户名或密码错误");
					}else{
						switch(data.role)
						{
						case 1:
							$.cookie("phone", data.phone);
							$.cookie("name", data.name);
							$.cookie("gender", data.gender);
							$.cookie("Id", data.id);
							$.cookie("role", data.role);
							
							console.log("Id："+data.id+"昵称："+data.name+"手机号："+data.phone+"性别："+data.gender);
					    	location.href = "index-guest.html";
					    	break;
						case 2:
							$.cookie("phone", data.phone);
							$.cookie("name", data.name);
							$.cookie("gender", data.gender);
							$.cookie("Id", data.id);
							$.cookie("role", data.role);
							
							console.log("Id："+data.id+"昵称："+data.name+"手机号："+data.phone+"性别："+data.gender);
					    	location.href = "index.html";
					    	break;
						case 3:
							$.cookie("phone", data.phone);
							$.cookie("name", data.name);
							$.cookie("Id", data.id);
							
							location.href = "index-doctor.html";
							break;
						}
					}
				},
				error : function() {
					alert("系统错误");
				}
			});
	}
}
function logged(){
	var phone = $.cookie("phone");
	var name = $.cookie("name");
	var gender = $.cookie("gender");
	var Id = $.cookie("Id");
	var role = $.cookie("role");
	console.log("保持登录:"+"id:"+Id+"手机号:" +phone+"昵称："+name+"角色："+role);
}