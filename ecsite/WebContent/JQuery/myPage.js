$(function(){
	$("#accordion").click(function(){

		$(this).nextAll("#heading,.date").slideToggle();
		$(this).toggleClass("active");
	})

	$(".date").click(function(){
		$(this).next(".loop").slideToggle();
		$(this).toggleClass("active");
	})


})