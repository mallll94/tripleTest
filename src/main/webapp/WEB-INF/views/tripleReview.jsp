<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
<script type="text/javascript">

$(function(){
	function selectAll(){
		$.ajax({
			url:"${pageContext.request.contextPath}/review/select",
			type:"post",
			traditional: true,
			dataType:"json",
			data: {userId: "3ede0ef2-92b7-4817-a5f3-0c575361f745", placeId: "2e4baf1c-5acb-4efb-a1af-eddada31b00f"},
   			success :function(result){
   				
   				var status = "<table >";
   				status+="<tr>";
   				status+="<td>statusId</td>";
   				status+="<td>내용</td>";
   				status+="</tr>";
				$.each(result.status, function(index, item){
					status+="<tr>";
					status+="<td>"+item.userPointStateId+"</td>";
					status+=`<td>${'${item.status}'}</td>`;
					status+="</tr>";	 
				})
				status+="</table>";	
				
				var review = "<table >";
				review+="<tr>";
				review+="<td>reviewId</td>";
				review+="<td>내용</td>";
				review+="<td>사진</td>";
				review+="</tr>";
				$.each(result.review, function(index, item){
					review+="<tr>";
					review+="<td>"+item.reviewId+"</td>";
					review+=`<td>${'${item.content}'}</td>`;
					review+="<td>"+item.attachedPhotoIds+"</td>";
					review+="</tr>";	 
				})
				review+="</table>";	
				
				$("#table").html(review);
				$("#point").html("내 포인트 : "+result.myPoint);
				$("#status").html(status);
				$("#id").html("userId : "+$("#userid").val())
   				},error : function(request,status,error){  
   					//alert(1)
   					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
   				}  //실팽했을때 실행할 함수 
   			});
	}
	selectAll();
	
	function event(id,content,photos,action){
		$.ajax({
			url:"${pageContext.request.contextPath}/review/event",
			type:"post",
			traditional: true,
			dataType:"text",
			data: {type: "REVIEW",
				action: action,
				reviewId: "240a0658-dc5f-4878-9381-ebb7b26671235",
				content: content,
				attachedPhotoIds: photos,
				userId: id,
				placeId: "2e4baf1c-5acb-4efb-a1af-eddada31b00f"},
   			success :function(result){
   				selectAll();
   				},error : function(request,status,error){  
   					//alert(1)
   					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
   				}  //실팽했을때 실행할 함수 
   			});
	}
	
	$("[name=event]").click(function(){
		var id = $("#userid").val();
		var content = $("[name=content]").val();
		var photo = $("[name=attachedPhotoIds]").val().split("/");
		var action = $(this).val()
		
		event(id,content,photo,action);
		
	})
	
})


</script>
</head>
<body>

<h1>트리플 마일리지서비스 테스트</h1>
<hr>
<h3><span id ="id"></span></h3>
<h3><span id="point"></span></h3>
<hr>
<h3>포인트 이력</h3>
<div id="status"></div>
<hr>
<h3>리뷰</h3>
<div id="table"></div>
아이디 : <input type="text" id="userid" value="3ede0ef2-92b7-4817-a5f3-0c575361f745" style="width: 300px">
내용 : <input type="text" name="content" value="" >
사진 : <input type="text" name="attachedPhotoIds" value="" style="width: 500px">
<button name="event" value="ADD">등록</button>  <button name="event" value="MOD">수정</button> <button name="event" value="DELETE">전체삭제</button>
<hr>
<h2>안내사항</h2>
사진 여러개 등록시 "/"로 구분 해주시면 됩니다.




</body>
</html>