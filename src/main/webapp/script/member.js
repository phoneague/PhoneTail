function idcheck(){
	if( document.joinForm.userid.value==""){
		alert("아이디를 입력하고 중복체크를 진행하세요" );
		document.joinForm.userid.focus();
		return;
	}
	var url = "phonetail.do?command=idcheck&userid=" + document.joinForm.userid.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	
	window.open(url, "idcheck", opt);
}

function idok( userid ){
	opener.joinForm.userid.value = userid;
	opener.joinForm.reid.value = userid;
	self.close();
}

function post_zip(){
	var url = "phonetail.do?command=findZipnum";
	var opt = "menubar=no, scrollbars=no, width=550, height=300, top=300, left=300";
	window.open( url, "findZipNum", opt);
}

function addressOK( zip_num, sido, gugun, dong ){
	opener.document.joinForm.zip_num.value=zip_num;
	opener.document.joinForm.address1.value=sido+" "+gugun+" "+dong;
	self.close();
}


function go_save(){
	if ( document.joinForm.userid.value == "") {
		alert("아이디를 입력하여 주세요."); 
		document.joinForm.userid.focus();
	}else if( document.joinForm.reid.value != document.joinForm.userid.value){
		alert("아이디 중복확인을 하지 않았습니다");		
		document.joinForm.userid.focus();
	}else if( document.joinForm.pwd.value == "") {
	    alert("비밀번호를 입력해 주세요.");	    
	    document.joinForm.pwd.focus();
	} else if( document.joinForm.pwd.value != document.joinForm.pwdCheck.value) {
	    alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");	    
	    document.joinForm.pwd.focus();
	} else if( document.joinForm.name.value == "") {
	    alert("이름을 입력해 주세요.");	    
	    document.joinForm.name.focus();
	} else if( document.joinForm.phone.value == "") {
	    alert("전화번호를 입력해 주세요.");	   
	    document.joinForm.phone.focus();
	}else if( document.joinForm.email.value == "") {
	    alert("이메일을 입력해 주세요.");	   
	    document.joinForm.email.focus();
	} else{
	    document.joinForm.submit();
	}
}