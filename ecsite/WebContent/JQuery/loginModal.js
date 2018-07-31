$(function(){
		resizeMain();

	$("#modal-open").click(
			function(){
				$(this).blur();
				$("#modal-overlay").fadeIn("slow");
				centeringModalSyncer();
				$("#modal-login form").prop("action","LoginAction");
				$("#flg").val("user");
				$("#modal-login").fadeIn("slow");
			}
	);

	$("#Cmodal-open").on("click",function(){
				$(this).blur();
				$("#modal-overlay").fadeIn("slow");
				centeringModalSyncer();
				$("#modal-login form").prop("action","LoginAction");
				$("#flg").val("user")
				$("#modal-login").fadeIn("slow");
			}
	);


	if(($("#mes").val())!=null){
		var flg=$("#flg").val();
		$("#modal-overlay").show();
		centeringModalSyncer();
		if(flg=="user"){
			$("#modal-login form").prop("action","LoginAction");
		}else if(flg=="master"){
			$("#modal-login form").prop("action","HostLoginAction");
		}
		$("#modal-login").show();
	}

	$("#host-link").click
		(function(){
			$(this).blur();
			$("#modal-overlay").fadeIn("slow");
			centeringModalSyncer();
			$("#modal-login form").prop("action","HostLoginAction");
			$("#flg").val("master");
			$("#modal-login").fadeIn("slow");
		})

});



function centeringModalSyncer(){
		var w=$(window).width();
		var h=$(window).height();
		var lw=$("#modal-login").outerWidth();
		var lh=$("#modal-login").outerHeight();
		var pxleft=((w-lw)/2);
		var pxtop=((h-lh)/2);

		$("#modal-login").css({"left": pxleft+ "px"});
		$("#modal-login").css({"top": pxtop + "px"});
}


function resizeMain(){
	var w=$(window).width();
	var h=$(window).height();
	$("#main").css("height",h-80+"px");
	if($("#content").height()*1.3 > $("#main").height() - $("#top").outerHeight()){
		$("#main").css("height",$("#content").height()*1.3);
	}
	$("#main").css("width",w+"px");
	if($("#long").width() > w*0.7){
		$("#main").css("width",$("#long").width()+200+"px");
		$("#content").css("width",$("#long").width()+100+"px");
	}
}



$(window).on("resize",function(){
	centeringModalSyncer();
	resizeMain();

});

$("#modal-overlay,#modal-close").click(function(){
	$("#modal-login,#modal-overlay").fadeOut("slow");

});