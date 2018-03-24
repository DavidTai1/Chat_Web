<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="Style/myweb.css"/>
<link rel="stylesheet" href="Style/grid.css"/>
<link rel="stylesheet" href="Style/dropDownSlide.css"/>
<link rel="stylesheet" href="Style/chatBox.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <script src="Js/chats.js"></script> -->
</head>
<body>



<div class="header"> 
  <div class="headerTitle">
	<h1>Chat System</h1>
  </div>
  <div class="headerLogin">
	<a class="button" href="#" ><h5>Welcome, <h5 id="userN">${loggedInUser.username} </h5></a>
	<a class="button" href="logout" ><h5>Logout</h5></a>
  </div>
</div>
<div class="row">

<div class="col-2" id="customcol-2">
	<div class=" sidenav">
		<button class="dropdown-btn">Friends 
			<i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<c:forEach items="${ friendlist }"  var="friend">
				<a onclick="changeValue(this);insertContact('${friend.friendid}');" >${friend.friendid}</a>
			</c:forEach>
		</div>
		<button class="dropdown-btn">Groups 
			<i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<a onclick="changeValue(this);insertContact('PubChat');" class="friends">PubChat</a>
		</div>
	</div>
</div>

<div class="col-9 displaybox" id="customcol-91">
  <h4>Chat box</h4>
  <div class="col-2 current-list" id="customcol-2contact">
  
  
  	<form name="message" action="addfriend" method="post" id="addfriend">
  	<input type="text" name="addname" placeholder="Type Username">
  	<button type="submit">ADD</button>  
  	<c:if test='${ not empty param.err }'>
		<div class="error">
			<c:choose>
				<c:when test="${ param.err == '1.jsp' }">
					<script>alert("Cannot add yourself");</script>
					
				</c:when>
				<c:when test="${ param.err == '2.jsp' }">
					<script>alert("Username does not exist");</script>
				</c:when>
				<c:when test="${ param.err == '3.jsp' }">
					<script>alert("Friend already exist in your friend list");</script>
				</c:when>
			</c:choose>
		</div>
	</c:if>
	<ul id="contactlist">
	
			
	</ul>
	</form>
  </div>

  <div class="col-9 chatdisplay" id="customcol-92" >
  	
<c:set var="currentusername" value="${loggedInUser.username}" />
<%--   		<c:forEach items="${ chatlogs }"  var="chat"> --%>
<%--   			<c:choose> --%>
<%--   				<c:when test="${chat.from_userid == currentusername}"> --%>
				
<!-- 					<div class="container green"> -->
<!--   					<img src="data:image/png;base64,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" alt="Avatar" style="width:100%;"> -->
<%-- 					<p>${chat.message}</p> --%>
<%-- 					<span class="time-right">${chat.timestamp}</span> --%>
<!-- 					</div> -->
<%-- 				</c:when> --%>
<%--             	<c:otherwise> --%>
<!--             		<div class="container darker"> -->
<!--         			  <img src="data:image/png;base64,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" alt="Avatar" class="right" style="width:100%;"> -->
<%--         			  <p class="text-right">${chat.message}</p> --%>
<%--         			  <span class="time-left">${chat.timestamp}</span> --%>
<!--         		   </div> -->
<%--             	</c:otherwise> --%>
<%--             </c:choose> --%>
<%-- 		</c:forEach> --%>
 		
  </div>
		<input name="usermsg" type="text" id="usermsg" size="63" placeholder="Type your message here" autofocus/>
        <input type="hidden" name="touser" id="touser">
        <button id="submitmsg">Send</button>  	

</div>
</div>
<script>
  
//change current talking user
function changeValue(o){
    document.getElementById("touser").value=o.innerHTML;
}  
function changeValuev(o){
    document.getElementById("touser").value=o;
}
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var dropdownContent = this.nextElementSibling;
    if (dropdownContent.style.display === "block") {
      dropdownContent.style.display = "none";
    } else {
      dropdownContent.style.display = "block";
    }
  });
}

var mymap = new Map();

var whichone='';
var intervalId;

// change current talking user, set color to green and check if user alread exist in sidebar
function tellwhich(val){
	var cd = document.getElementById("customcol-92");
	if(whichone){
		mymap.set(whichone,cd.innerHTML);
		document.getElementById(whichone).style.backgroundColor = '#c7c7c7';
	}
	whichone=val;
	document.getElementById(whichone).style.backgroundColor = 'green';
	if(intervalId!=null){
		clearInterval(intervalId);
		intervalId = setInterval(function(){if(whichone!=''){
			updatenewlogs(document.getElementById(whichone));}},500);
	}else{
		intervalId=setInterval(function(){if(whichone!=''){
			updatenewlogs(document.getElementById(whichone));}},500);
	}
// 	cd.innerHTML=mymap.get(whichone);
}

// insert contact to the sidebar
function insertContact(who){
	if(mymap.has(who)){
		tellwhich(who);
	}
	else{
		control='<li class="dialog" onclick="tellwhich(\''+who+'\');changeValuev(\''+who+'\');"> <input value="'+who+'" onclick="updatenewlogs(this);" id="'+who+'"></li>';
		var cd = document.getElementById("contactlist");
		cd.innerHTML+=control;
		cd.scrollTop = cd.scrollHeight;
		mymap.set(who,document.getElementById("customcol-92").innerHTML);
		tellwhich(who);
	}
}


	
// update all message 
function updatenewlogs(o){
	
	// who im sending to
	var purls="data:image/png;base64,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";
	var purlo="data:image/png;base64,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";
	$.ajax({
		url:"/Chat_Web/updatedialog",
		method:"POST",
		 data:{touser:o.value},
		error: function() {
	         $('#info').html("<p>An error has occurred</p>");
	    },
	    dataType: 'text',
	    success: function(response) {
    		var text=JSON.parse(response);;
    		var div = '';
    		
    		$.each(text, function(index, value) {
    			var userN = document.getElementById("userN").innerHTML;
				if(value.from_userid.trim() === userN.trim()){
					div = div +
					'<div class="container green">'+
					'<img src="'+purls+'" alt="Avatar" style="width:100%;">'+
					'<p>'+value.message+'</p>'+
					'<span class="time-right">' + value.timestamp + '</span>'+
					'</div>';
				}
				if(value.to_userid.trim() === "PubChat".trim() && value.from_userid.trim() !== userN.trim()){
					console.log(document.getElementById("userN").innerHTML);
					div = div +
					'<div class="container darker">'+
					'<p><b>FROM: '+value.from_userid+'</b></p><img src="'+purlo+'" alt="Avatar" class="right" style="width:100%;">'+
					'<p class="text-right">'+value.message+'</p>'+
					'<span class="time-left">' + value.timestamp + '</span>'+
					'</div>';
				}
				if(value.to_userid.trim() !== "PubChat".trim() && value.from_userid.trim() === o.value.trim()){
					div = div +
						'<div class="container darker">'+
						'<img src="'+purlo+'" alt="Avatar" class="right" style="width:100%;">'+
						'<p class="text-right">'+value.message+'</p>'+
						'<span class="time-left">' + value.timestamp + '</span>'+
						'</div>';
				}
    		})
    		document.getElementById("customcol-92").innerHTML=div;
//     		$("#customcol-92").animate({scrollTop: $('#customcol-92').prop("scrollHeight")}, 500);;
	    	console.log('append size: '+text.length +" to: "+o.value);
	    	//document.getElementById("customcol-92").innHTML=response;
	    	
	    },
	     
	   });
	};
// update 1 message(register in db), append to chat box	
$('#submitmsg').click(function() {
	var purl="data:image/png;base64,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";
	var msg=document.getElementById("usermsg").value;
	$.ajax({
	      url: "/Chat_Web/sendmsg",
	      method:"POST",
	      data:{touser:document.getElementById("touser").value,
	    	  usermsg:document.getElementById("usermsg").value},
	      error: function() {
	         $('#info').html("<p>An error has occurred</p>");
	      },
	      dataType: 'text',
	      success: function(response) {
	    	  if(response == "error"){
	    		  alert("Please choose the friend you want to talk to first");
	    	  }
	    	  else{
	    		  var text =
	    		 		'<div class="container green">'+
	    				'<img src="'+purl+'" alt="Avatar" style="width:100%;">'+
	    				'<p>'+msg+'</p>'+
	    				'<span class="time-right">' + response + '</span>'+
	    				'</div>';

	    		         $("#customcol-92").append(text).animate({scrollTop: $('#customcol-92').prop("scrollHeight")}, 500);;
	    		  
	    	  }   			
	      },
	   });
	});


</script>
</body>
</html>
