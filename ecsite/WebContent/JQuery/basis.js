$(function(){
	$(document).snowfall({
		flakeCount:100,
		flakeIndex:"-5",
		minSize:5,
		maxSize:40,
		minSpeed:0.5,
		maxSpeed:1,
		image:"images/snow2.png"
	});



	jQuery.validator.addMethod("smallalphanum", function(value, element) {
		return this.optional(element) || /^([a-z0-9]+)$/.test(value);
		}, "半角小文字英数字を入力してください"
	);

	$(".checkAll").on("change", function() {
		$('.' + this.id).prop('checked', this.checked);
	});

	$(".delete").on("click",function(){
		console.log($(".check :checked").length);
		console.log($(".cartCheck").length);
		if($(".check :checked").length == $(".cartCheck").length){
			$(".checkAll").prop("checked","checked");
		}else{
			$(".checkAll").prop("checked",false);
		}
	});

	$(".tempCheckAll").on("change", function() {
		$('.' + this.id).prop('checked', this.checked);
	});

	$(".tempDelete").on("click",function(){
		console.log($(".tempCheck :checked").length);
		console.log($(".tempCartCheck").length);
		if($(".tempCheck :checked").length == $(".tempCartCheck").length){
			$(".tempCheckAll").prop("checked","checked");
		}else{
			$(".tempCheckAll").prop("checked",false);
		}
	});



	$("#login").validate({
		rules:{
			loginUserId:{
				required:true,
				rangelength:[5,15],
				smallalphanum:true
			},
			loginPassword:{
				required:true,
				rangelength:[5,15],
				smallalphanum:true
			}

		},
		messages:{
			loginUserId:{
				required:"idを入力してください　",
				rangelength:"idは、5文字以上15文字以下で入力してください　",
				smallalphanum:"idは半角小文字英数字で入力してください　"
			},
			loginPassword:{
				required:"passwordを入力してください　",
				rangelength:"passwordは、5文字以上15文字以下で入力してください　",
				smallalphanum:"passwordは半角小文字英数字で入力してください　"
			}
		},
			errorPlacement: function(error,element){
			error.appendTo($("#messages"));
		}
	})

	$("#userCreate").validate({
		rules:{
			loginUserId:{
				required:true,
				rangelength:[5,15],
				smallalphanum:true
			},
			loginPassword:{
				required:true,
				rangelength:[5,15],
				smallalphanum:true
			},
			userName:{
				required:true,
				rangelength:[5,15],
				smallalphanum:true
			}

		},
		messages:{
			loginUserId:{
				required:"idを入力してください　",
				rangelength:"idは、5文字以上15文字以下で入力してください　",
				smallalphanum:"idは半角小文字英数字で入力してください　"
			},
			loginPassword:{
				required:"passwordを入力してください　",
				rangelength:"passwordは、5文字以上15文字以下で入力してください　",
				smallalphanum:"passwordは半角小文字英数字で入力してください　"
			},
			userName:{
				required:"userNameを入力してください　",
				rangelength:"userNameは、5文字以上15文字以下で入力してください　",
				smallalphanum:"userNameは半角小文字英数字で入力してください　"
			}
		},
		errorPlacement: function(error,element){
			error.appendTo($("#messages"));
		}
	})
})