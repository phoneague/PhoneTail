function loginCheck(){
	if(document.loginForm.adminid.value==""){
		alert("아이디를 입력하세요");
		document.loginForm.adminid.focus();
		return false;
	}else if(document.loginForm.pwd.value==""){
		alert("패스워드를 입력하세요");
		document.loginForm.pwd.focus();
		return false;
	}else{
		return true;
	}
}

function go_search(command){
	var url="phonetail.do?command="	+command+"&page=1"
	document.frm.action = url;
	document.frm.submit();
}
