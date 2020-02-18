/**
 * work expericnce added by cyh
 */

$(document).ready(function () {	  
	var $tr = null;
	var index = 0;
    $('#inputStart').monthpicker();
    $('#inputEnd').monthpicker();	    
    $('#divMsg').hide();
    $('#btnToAdd').click(function() {
    	$("#myModal").modal('show');
    });
    
    $('#btnCancel').click(function() {
    	$tr = null;
    	$("#myModal").modal('hide');
    });
    
    $('#btnFinish').click(function() {
    	$('#divMsg').hide();
    	var errors = 0;
    	$('#myModal input[type="text"]').each(function() {
    		if (!$(this).val()) {
    			errors++;
    		}
    	});
    	if (errors > 0) {
    		$('#divMsg').show();
    		return;
    	}
		
    	if ($tr == null) {
    		var markup = "<tr><td>" + $('#inputStart').val() +"</td><td>" + $('#inputEnd').val() + 
			"</td><td>" + $('#inputStudy').val() + 
			'</td><td><button type="button" class="btn btn-primary btn-sm btnEdit">修改</button>&nbsp;' + 
			'<button type="button" class="btn btn-primary btn-sm btnDelete">删除</button> </td></tr>';
			$('.table').append(markup);	    			
    	} else {
    		index = 0;
    		$tr.find('td').each(function() {
	    		switch(index) {
	    		case 0:		    			
	    			$(this).text($('#inputStart').val());
	    			break;
	    		case 1:
	    			$(this).text($('#inputEnd').val());
	    			break;
	    		case 2:
	    			$(this).text($('#inputStudy').val());
	    			break;
	    		}
	    		index++;
	    	});
    	}
    	$('#inputStart').val("");
    	$('#inputEnd').val("");
    	$('#inputStudy').val("");
    	$tr = null;
    	$("#myModal").modal('hide');
    });
    
    $('.table').on('click', '.btnDelete', function() {	    	
    	$(this).closest('tr').remove();
    });
	
    $('.table').on('click', '.btnEdit', function() {
    	index = 0;
    	$tr = $(this).closest('tr');
    	$tr.find('td').each(function() {
    		switch(index) {
    		case 0:
    			$('#inputStart').val($(this).text());
    			break;
    		case 1:
    			$('#inputEnd').val($(this).text());
    			break;
    		case 2:
    			$('#inputStudy').val($(this).text());
    			break;
    		}
    		index++;
    	});
    	$("#myModal").modal('show');
    });
    
    $('#btnToSave').click(function() {
    	var tableData = [];    	
    	$('.table').find('tr').each(function(rowIndex, r) {
    		if (rowIndex == 0) {
    			return;
    		}	 
    		var rowData = {};
    		rowData["startDate"] = $(this).find('td:first').text();
    		rowData["endDate"] = $(this).find('td').eq(1).text();
    		rowData["details"] = $(this).find('td').eq(2).text();
    		tableData.push(rowData);
    	});
    	$.ajax({
    		type : "post",
    		headers: { 
    	        /* 'Accept': 'application/json', */
    	        'content-Type' : "application/json;charset=UTF-8"
    	    },	    		
    		url : "saveWE",
    		data : JSON.stringify(tableData),
    		success : function(msg) {
    			alert("保存成功！");	
    		},
    		error : function( jqXHR, textStatus) {
    			console.log(jqXHR);
    			alert(textStatus);
    		}
    		
    	});
    	
    });
});