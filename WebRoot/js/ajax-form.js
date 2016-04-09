$(function(){
    	var url=$("#Form").attr("action");
    	$('#Form').submit(function(){
           var options = {
				target:     '#list',
				url:        url,
				beforeSubmit:  function(){
					 $("#currentpage").val("0");
					 $(".showpage").html("第1页");
					 $("#prepage").parents("li").html("<a id='ppage'>上一页</a>");
					 $("#n").parents("li").html("<a id='nextpage'>下一页</a>");
				},
				success: function(e) {
					 max=$("#maxpage").attr("value");
					 $("#total").html("共"+max+"页");
					 if(max<=1){
						 if(max==0)
						       $("#list").html(" <tr><td colspan='11'><span class='red'>没有找到数据！请重新输入查询条件。。。</span></td></tr>");
				    	 $("#prepage").parents("li").html("<a id='ppage'>上一页</a>");
				    	  $("#nextpage").parents("li").html("<a id='npage'>下一页</a>");
					     }else{
					    	 $("#npage").parents("li").html("<a href='"+url+"' id='nextpage'>下一页</a>");
					     };
					
				}
				};
             $('#Form').ajaxSubmit(options);
            return false; 
         });
    	
    	var add_url=$("#addForm").attr("action");
    	$('#addForm').submit(function(){
           var options = {
				target:     '#content',
				url:        add_url,
				/*success: function(e) {
					alert(e);
				}*/
				};
             $('#addForm').ajaxSubmit(options);
            return false; 
         });
    	var delete_url=$(this).attr("id");
    	/*$(".remove").live("click",function(){
    		var delete_url=$(this).attr("id");
    		alert(delete_url);
    		$(".modal-footer").children("a.bt-delete").attr("href",delete_url);		
    	});    */	
    	$(".remove").live("click",function(){
    		var delete_url=$(this).attr("id");
    		$(".modal-footer").children("a.bt-delete").attr("href",delete_url);
    	});  
    	$(".bt-delete").click(function(e){
    		var delete_url=$(this).attr("href");
    		$.post(delete_url,  function(data){
    			$("#static").remove();
    			$(".modal-backdrop").remove();
    			$("#content").html(data);
			   });
    		e.preventDefault();
    	});
    
    	/*$("select#owner").one("focus",function(){
        	$.post("deviceAction.findContactors.action",  function(data){
    			$("select#owner").append(data);
			   });
    	});*/
});
