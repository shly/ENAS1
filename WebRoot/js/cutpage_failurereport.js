$(function(){
  $("a#prepage ,a#nextpage").die().live("click",function(e){
     e.preventDefault();
     
      /*
	 * 处理要传递的参数
	 * */
     
     var url=$(this).attr("href");
     
     //获取参数，其中#maxpage在要加载的界面中，如findcpass.jsp,一定要为maxpage（总页数）
     
     var deviceName=$("#deviceName").attr("value");
     var deviceIp=$("#deviceIp").attr("value");
     max=Number($("#maxpage").attr("value"));
     pagenum=Number($("#currentpage").val());
     $("#total").html("共"+max+"页");
       /*
	 * 处理上下页显示逻辑,此处不用改
	 * */
     var btn=$(this).attr("id");
     if(btn=="prepage"){
    	$("#npage").parents("li").html("<a href="+url+" id='nextpage'>下一页</a>"); 
	       pagenum=pagenum-1;
	     $("#currentpage").attr("value",pagenum);
	     showpage=pagenum+1;
	     if(showpage==1){
	    	$("#prepage").parents("li").html("<a id='ppage'>上一页</a>"); 
	     }
	     $(".showpage").html("第"+showpage+"页");
     }else if(btn=="nextpage"){
    	  $("#ppage").parents("li").html("<a href="+url+" id='prepage'>上一页</a>"); 
	      pagenum=pagenum+1;
	     $("#currentpage").attr("value",pagenum);
	     showpage=pagenum+1;
	     if(showpage==max){
	    	 $("#nextpage").parents("li").html("<a id='npage'>下一页</a>");
	     }
	     
	     $(".showpage").html("第"+showpage+"页");
     }
    
     gotoPage(deviceName,deviceIp,pagenum,url);
  });
});



/*
 * 处理向后台传的数据
 * */



function gotoPage(deviceName,deviceIp,pagenum,url)
{
 $.ajax({
	   type: "post",
	   url: url,
	   data: {
		   deviceName:deviceName,
		   deviceIp:deviceIp,
		   beginPage:pagenum
	   },
	   success: function(msg){
		   $("#list").html(msg);
	   }
	});
}
