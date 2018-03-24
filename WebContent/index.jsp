<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="Style/myweb.css" />
<link rel="stylesheet" type="text/css" href="Style/grid.css"/>
<link rel="stylesheet" type="text/css" href="Style/dropDownSlide.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="header"> 
  <div class="headerTitle">
	<h1>Chat System</h1>
  </div>
  <div class="headerLogin">
	<a class="button" href="login" ><h5>Login</h5></a>
	<a class="button" href="register" ><h5>Register</h5></a>
  </div>
</div>

<div class="row">

<div class="col-2" id="customcol-2">
	<div class=" sidenav">
		<button class="dropdown-btn">Friends 
			<i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<a target="_blank" href="https://www.youtube.com/watch?v=TRGDY514wJw">friendsample</a>

		</div>
		<button class="dropdown-btn">Groups 
			<i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<a href="#">groupsample</a>
		</div>
	</div>
</div>

<div class="col-9 displaybox" id="customcol-9">
  <h4>Chat box</h1>
  <div class="col-2 current-list" id="customcol-2">
	<ul>
		<li>dialog</li>
		<li>dialog</li>
		<li>dialog</li>
		<li>dialog</li>
		<li>dialog</li>
	</ul>
  </div>
  <div class="col-9 chatdisplay" id="customcol-9">
	<h1>display messages here</h1>
  </div>
</div>

</div>
<script>
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
</script>
</body>
</html>
