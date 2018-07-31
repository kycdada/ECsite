$(function(){
	$("#upfile").change(function(){
		if(this.files.length>0){
			var file=this.files[0];


			var reader=new FileReader();
			reader.readAsDataURL(file);
			reader.onload=function(){
				$("#thumbnail,#smallThumbnail").prop("src",reader.result);
			}
		}
	})
	$("#btn").click(function(){
		$(this).blur();
		var name="商品名： "+$("#name").val();
		var hira="ふりがな: "+$("#hira").val();
		var kata="フリガナ: "+$("#kata").val();
		var cate="カテゴリー: "+$("#cate").val();
		var price="価格: " +$("#price").val();
		var explain="商品説明: "+$("#explain").val();
		$("#nameModal").text(name);
		$("#hiraModal").text(hira);
		$("#kataModal").text(kata);
		$("#cateModal").text(cate);
		$("#priceModal").text(price);
		$("#explainModal").text(explain);


		if($("#name").val() !=null && $("#price").val() !=null && $("#hira").val() !=null && $("#kata").val() !=null && $("#explain").val() !=null){
			$("#overlay").fadeIn("slow");
			centeringModal();
			$("#modal").fadeIn("slow");
		}

	})

})

function centeringModal(){
	var w=$(window).width();
	var h=$(window).height();
	var mw=$("#modal").outerWidth();
	var mh=$("#modal").outerHeight();
	var pxLeft=(w-mw)/2;
	var pxheight=(h-mh)/2;

	$("#modal").css("left",pxLeft +"px");
	$("#modal").css({"top" : pxheight +"px"})
}

$(window).resize(function(){
	setTimeout(centeringModal(),200);
})

$("#overlay,#close").on("click",function(){
	$("#modal,#overlay").fadeOut("slow");
})
