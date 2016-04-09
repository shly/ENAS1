jQuery(document).ready(function() {
	$("#gjxxgl").addClass("active open").siblings("li").removeClass("active");
	$("#gjxxgl a span.title").after("<span class='selected'></span>");
	/*$("#gjxxgl a span.arrow").addClass("open");*/
	
	App.init();

	
});


/*
 * 2013-01-01 01:01:11
 * alarmId@_@alarmName...
 * */
function run(message) {
	
	i+=1;
	
	var li_1=$("ul.timeline li:first");
	var li_2=$("ul.timeline li:nth-child(2)");
	var li_3=$("ul.timeline li:nth-child(3)");
	var li_4=$("ul.timeline li:nth-child(4)");
	li_1.hide();
	li_4.find("span.date").text(li_3.find("span.date").text());
	li_4.find("span.time").text(li_3.find("span.time").text());
	li_4.find("tbody").html(li_3.find("tbody").html());
	
	li_3.find("span.date").text(li_2.find("span.date").text());
	li_3.find("span.time").text(li_2.find("span.time").text());
	li_3.find("tbody").html(li_2.find("tbody").html());
	
	li_2.find("span.date").text(li_1.find("span.date").text());
	li_2.find("span.time").text(li_1.find("span.time").text());
	li_2.find("tbody").html(li_1.find("tbody").html());
	
	
	
	
	/*$("ul.timeline li:last").remove();
	$("ul.timeline li:nth-child(2)").children(".timeline-body").removeClass("alarm_past_1").addClass("alarm_past_2");
	$("ul.timeline li:nth-child(3)").children(".timeline-body").removeClass("alarm_past_2").addClass("alarm_past_3");*/
     
	var messages=message.split("\n");
	var times=messages[0].split(" ");
	var date=times[0];
	var time=times[1];
	var contents=messages.slice(1,messages.length);
	var HTML="";
	$.each(contents,function(i,n){
		   var attributes=n.split("@_@");
		   if(attributes.length < 7){
			   return;
		   }
		   var regionId=attributes[1];
			var deviceName=attributes[2];
			var alarmLevel=attributes[3];
			var alarmType=attributes[4];
			var alarmText=attributes[5];
			var alarmTime=(attributes[6].split(" "))[1];
			
			HTML+="<tr><td>"+deviceName+"</td><td>"+regionId+"</td><td>"
			         +alarmLevel+"</td><td>"+alarmType+"</td><td>"+alarmTime+"</td><td>"+alarmText+"</td></tr>";
		});
	li_1.find("span.date").text(date);
	li_1.find("span.time").text(time);
	li_1.find("tbody").html(HTML);
	$("ul.timeline li:first").slideDown();
	if(i>=2){
		li_2.show();
	}
	if(i>=3){
		li_3.show();
	}
	if(i>=4){
		li_4.show();
	}
}