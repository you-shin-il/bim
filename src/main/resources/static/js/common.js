$(document).ready(function(){
 
	//Header 메뉴
	$("#btnHeaderMenu").click(function(e){
		console.log("btnHeaderMenu click");
		e.preventDefault();
		$("#headerMenu").animate({left:"0"});
	});

	$("#btnHeaderMenuClose").click(function(e){
		e.preventDefault();
		$("#headerMenu").animate({left:"-200px"});
	});

	// 메인 Resource 출력/미출력 선택
	$("#btnResource").click(function(){
		$(".dashboard").removeClass("noResource");
	});

	$("#btnNoResource").click(function(){
		$(".dashboard").addClass("noResource");
	});

	//메인 장애이력 팝업
	$("#popEmergency h6").click(function(){
		popEmergencyOpen();
	});
	$("#btnEmergencyClose").click(function(e){
		e.preventDefault();
		popEmergencyClose();
	});
});

function popEmergencyOpen(){
	$("#popEmergency").animate({
		"bottom":"0px"
	}, 500, function(){
		$("#btnEmergencyClose").show();
	});
}

function popEmergencyClose(){
	$("#popEmergency").animate({
		"bottom":"-220px"
	}, 500, function(){
		$("#btnEmergencyClose").hide();
	});
}