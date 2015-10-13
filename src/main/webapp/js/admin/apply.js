$(document).on("click",".showDetail",function(e){
	var $this = $(this);
	e.preventDefault();
	var tabTitle = "查看"+$this.data('name')+"最近回答的问题";//获取超链里span中的内容作为新打开tab的标题
	var url = "/admin/userquestionlist?uuid="+$this.data("userid");
	parent.addTab(tabTitle,url);//增加tab
}).on("click",".passApply",function(e){
	var $this = $(this);
	e.preventDefault();
	var id=$this.data('id');
	var userId=$this.data('userid');
	var userName=$this.data('name');
	var index=$this.data('index');
	 $.ajax({
		  	type: 'POST',
		    url: "/ajax/passApply" ,
		    data: {
		    	userId:userId,
		    	id:id
		    }
	  }).done(function(data){
		  if(data==1){
			  toastr.success('','你已允许'+userName+'编写文章');
			  $("#applyGrid").datagrid('deleteRow',index);
		  }
		  else{
			  var error=jQuery.parseJSON(data); 
			  toastr.error('',error.message);
		  }
	});
});