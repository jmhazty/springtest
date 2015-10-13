function doSearch(){
	$('#mytable').datagrid('reload',{
		low: $('#lowid').val(),
		high: $('#highid').val()
	});
}