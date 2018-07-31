$(function(){
	$(".ON").click(function(){
		if($(this).hasClass("reverse")){
			$(this).children("p").text("ON");
			$(this).children("input").val("true");
			$(this).removeClass("reverse");
		}else{
		$(this).children("p").text("OFF");
		$(this).children("input").val("false");
		$(this).addClass("reverse");
		}
	})

	$(".OFF").click(function(){
		if($(this).hasClass("reverse")){
			$(this).children("p").text("OFF");
			$(this).children("input").val("false");
			$(this).removeClass("reverse");
		}else{
		$(this).children("p").text("ON");
		$(this).children("input").val("true");
		$(this).addClass("reverse");
		}
	})






});