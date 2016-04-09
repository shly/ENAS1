$(document).ready(function() {
	$("#inputname").formValidator( {
		onShowFixText : "请输入真实姓名",
		onShow : "",
		onFocus : "",
		onCorrect : "格式正确"
	}).inputValidator( {
		min : 1,
		onError : "姓名不能为空"
	}, {
		min : 2,
		max : 4,
		onError : "你输入的编号长度非法,请确认"
	});

	$("#contactorName").formValidator( {
		onShowFixText : "请输入真实姓名",
		onShow : "",
		onFocus : "",
		onCorrect : "格式正确"
	}).inputValidator( {
		min : 1,
		onError : "联系人姓名不能为空"
	}, {
		min : 2,
		max : 4,
		onError : "你输入的编号长度非法,请确认"
	});

	$(":radio[name='passGender']").formValidator( {
		tipID : "sexTip",
		onShow : "请选择你的性别",
		onFocus : "没有第三种性别了，你选一个吧",
		onCorrect : "输入正确",
	}).inputValidator( {
		min : 1,
		max : 1,
		onError : "性别忘记选了,请确认"
	});//.defaultPassed();

		$("#inputemail").formValidator( {
			onShowFixText : "请输入正确邮箱",
			onShow : "请输入邮箱",
			onFocus : "该项为非必填项",
			onCorrect : "恭喜你,你输对了",
			defaultValue : "@"
		}).inputValidator( {
			min : 0,
			max : 100,
			onError : "你输入的邮箱长度非法,请确认"
		});

		$("#inputbirthday").formValidator( {
			onShowFixText : "请输入的生日",
			onShow : "请输入的生日",
			onFocus : "",
			onCorrect : "格式正确",
		}).inputValidator( {
			min : 1,
			onError : "入职日期不能为空"
		});

		$("#inputPhone").formValidator( {
			empty : true,
			onShowFixText : "请输入你的手机或电话，可以为空",
			onShow : "请输入你的手机或电话，可以为空哦",
			onFocus : "格式例如：0577-88888888或11位手机号码",
			onCorrect : "谢谢你的合作",
			onEmpty : "你真的不想留手机或电话了吗？"
		}).regexValidator( {
			regExp : [ "tel", "mobile" ],
			dataType : "enum",
			onError : "你输入的手机或电话格式不正确"
		});
		$("#inputID").formValidator( {
			ajax : true,
			onShowFixText : "请输入身份证号码",
			onShow : "请输入15或18位的身份证",
			onFocus : "输入15或18位的身份证",
			onCorrect : "输入正确"
		}).functionValidator( {
			fun : isCardID
		});

	});