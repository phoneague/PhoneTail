function go_report(pseq,userid){
	if(userid==""){
		location.href='phonetail.do?command=loginForm';
	}else{
		var url = "phonetail.do?command=reportForm&pseq="+pseq;
		var opt = "menubar=no, scrollbars=no, width=500, height=400, top=300, left=300";
		window.open( url, "reportForm", opt);
	}
}
function report(){
	let Form = document.reportViewForm;
	if(Form.retype.value==-1){
		alert("신고 타입을 선택하세요");	
	}else if(Form.recontent.value==""){
		alert("신고 내용을 입력해주세요");
	}else{
		Form.action="phonetail.do?command=report";
		Form.submit();	
	}	
}

function processReport(){
	document.reportViewForm.action="phonetail.do?command=processReport";
	document.reportViewForm.submit();
}

function closeWindow(){
	window.close();
}