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

function go_userstate_change() {
    var count = 0;
	// 혹시라도 체크박스에 체크를 하나도 안넣고 삭제버튼을 눌렀는지 검사
	if( document.frm.userstate.length == undefined ){
		// 체크박스가 한개라면, 체크박스가 단일 변수로 인식
		if( document.frm.userstate.checked==true){
			count++;
		}		
	}else{
		// 체크박스가 두개이상이라면,  체크박스들이 배열이라면
		for(var i=0; i<document.frm.userstate.length; i++){
			if( document.frm.userstate[i].checked== true){
				count++;
			}
		}
}
}
