function go_insert(){
	let Form = document.productInsertForm;
	if (Form.brand.value == "") {
		alert('상품분류를 선택하세요');
		Form.brand.focus();
	} else if (Form.series.value == "") {
		alert('시리즈명을 입력하세요.'); 
		Form.series.focus();
	} else if (Form.model.value == "") {
		alert('모델명을 입력하세요.'); 
		Form.model.focus();
	} else if (Form.price.value == "") {
		alert('판매가를 입력하세요.'); 
		Form.price.focus();
	} else if (Form.content.value == "") {
		alert('상품상세를 입력하세요.'); 
		Form.content.focus();
	} else if (Form.image.value == "") {
		alert('상품이미지들 입력하세요.'); 
		Form.image.focus();
	} else {
		Form.action="phonetail.do?command=productInsert"
		Form.submit();
	}
}