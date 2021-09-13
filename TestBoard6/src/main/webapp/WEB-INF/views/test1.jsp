<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jQuery AJAX Form Submit example</title>
<script type="text/javascript" src="jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form id="testForm" name="testForm">
		<input type="text" name="pageIndex" id="pageIndex" value="1" />
		<input type="text" name="searchKeyword" id="searchKeyword" value="2" />
		<input type="text" name="pkList" id="pkList1" value="no1" />
		<input type="text" name="pkList" id="pkList2" value="no2" />
		<input type="text" name="pkList" id="pkList3" value="no3" />
		<button type="button"  name="btn" id="btn" value="test" class="btnChk">확인</button>
	</form>
<script>

  var $form = $("#testForm");

  $form.find(".btnChk").on('click', function(e){

    console.log($form.serialize());

    alert($form.serialize());

    $.ajax({

      dataType: 'json', type : 'post',
	url: '/test2', // <<-- 처리 요청 URL
	data: $form.serialize(),
	}).done(function(data) {
		$form.attr('action', '/test/list');  //<<-- 처리 이후 리턴 페이지
		$form.submit();
	}); 
});

</script>
</body>
</html>
