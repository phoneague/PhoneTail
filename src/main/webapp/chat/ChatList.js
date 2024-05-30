
function replyCheck(){
	if( document.chating.content.value==""){
		alert("내용을 입력하세요");
		document.chating.content.focus();
		return false;
	}
	return true;
}