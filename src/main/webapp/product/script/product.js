function go_insert() {
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
	} else if (Form.comment.value == "") {
		alert('상품상세를 입력하세요.');
		Form.content.focus();
	} else if (Form.image.value == "") {
		alert('상품이미지들 입력하세요.');
		Form.image.focus();
	} else {
		Form.action = "phonetail.do?command=productInsert"
		Form.submit();
	}
}
function go_search(command) {
	let Form = document.productListForm;
	var url = "phonetail.do?command=" + command + "&page=1"
	Form.action = url;
	Form.submit();
}

function clear_brand() {
	sessionStorage.setItem('brand', null);
	window.location.href = "phonetail.do?command=productList";
}

function go_updateForm(pseq, sellerId, loginId) {
	if (sellerId != loginId) {
		console.log(sellerId);
		console.log(loginId);
		alert("본인이 쓴 글만 수정할 수 있습니다.");
		document.loginForm.userid.focus();
	}
	alert("상품을 수정하시겠습니까?");
	window.location.href = "phonetail.do?command=productUpdateForm&pseq=" + pseq;
}

function go_update() {
	let Form = document.productUpdateForm;
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
	} else if (Form.comment.value == "") {
		alert('상품상세를 입력하세요.');
		Form.content.focus();
	} else if (Form.image.value == "") {
		alert('상품이미지들 입력하세요.');
		Form.image.focus();
	} else {
		Form.action = "phonetail.do?command=productUpdate"
		Form.submit();
	}
}

function go_delete(pseq, sellerId, loginId) {
	if (sellerId != loginId) {
		alert("본인이 쓴 글만 삭제할 수 있습니다.");
		document.loginForm.userid.focus();
	}
	let answer = confirm("정말로 삭제하시겠습니까?");
	if(answer) {
			window.location.href = "phonetail.do?command=productDelete&pseq=" + pseq;
	} 
}


function go_chat(pseq) {

}

function sold(pseq){
	let answer = confirm("거래를 완료하셨나요?");
	if(answer) {
		window.location.href = "phonetail.do?command=productSold&pseq=" + pseq;
	}
	
}

function previewImage(){
	document.getElementById('image').addEventListener('change', function(event) {
       const file = event.target.files[0];
       const reader = new FileReader();
       reader.onload = function(e) {
            const preview = document.getElementById('preview');
           preview.src = e.target.result;
       }
       if (file) {
           reader.readAsDataURL(file);
       }
   });
}


