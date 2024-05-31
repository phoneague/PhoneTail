function replyCheck(){
	if( document.chating.content.value==""){
		alert("내용을 입력하세요");
		document.chating.content.focus();
		return false;
	}
	return true;
}

function go_chat(pseq,userid){
	if(userid==""){
		location.href='phonetail.do?command=loginForm';
	}else{
		location.href='phonetail.do?command=insertChatList&pseq='+pseq;
	}
}