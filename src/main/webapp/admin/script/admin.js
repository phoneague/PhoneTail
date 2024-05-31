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

function userstate_YtoB() {
var count = 0;
	if( document.frm.userstate.length == undefined ){
		if( document.frm.userstate.checked==true) {
			count++;
		}		
	}else{
		for(var i=0; i<document.frm.userstate.length; i++){
			if( document.frm.userstate[i].checked== true){
				count++;
			}
		}
	}	
	if( count == 0){
		alert("블랙할 회원을 선택하세요");
	}else{
		var ans = confirm("선택한 회원을 블랙할까요?");
		if( ans ){
			document.frm.action = "phonetail.do?command=adminUserStateChangeYtoB";
			document.frm.submit();
		}
	}
}

function userstate_BtoY(){
	var count = 0;
	if( document.frm.userstate.length == undefined ){
		if( document.frm.userstate.checked==true) {
			count++;
		}		
	}else{
		for(var i=0; i<document.frm.userstate.length; i++){
			if( document.frm.userstate[i].checked== true){
				count++;
			}
		}
	}	
	if( count == 0){
		alert("블랙해제할 회원을 선택하세요");
	}else{
		var ans = confirm("선택한 회원을 블랙해제할까요?");
		if( ans ){
			document.frm.action = "phonetail.do?command=adminUserStateChangeBtoY";
			document.frm.submit();
		}
	}
}

function userstate_NtoY(){
		var count = 0;
	if( document.frm.userstate.length == undefined ){
		if( document.frm.userstate.checked==true) {
			count++;
		}		
	}else{
		for(var i=0; i<document.frm.userstate.length; i++){
			if( document.frm.userstate[i].checked== true){
				count++;
			}
		}
	}	
	if( count == 0){
		alert("휴면해제할 회원을 선택하세요");
	}else{
		var ans = confirm("선택한 회원을 휴면해제할까요?");
		if( ans ){
			document.frm.action = "phonetail.do?command=adminUserStateChangeNtoY";
			document.frm.submit();
		}
	}
}