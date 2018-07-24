<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s
}

.sidenav a:hover, .offcanvas a:focus{
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>
<html>

<body>

<section style="background-image:url(img/party_back2.jpg);height: 675px">

<br/><br/><br/><br/><br/><br/>
<h1 align="center"><i><b><font color="orange">Post how do you want to party and find a mate.</font></b></i></h1>

<form  action="PostParty" method="get">
<table align="center">
<tr><td><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I want to party by&nbsp;&nbsp;<input type="hidden" name="party" value="party"><input type="text" name="maker" placeholder="how do you want to party"></h3></td></tr>
<tr><td><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;on&nbsp;&nbsp;<input type="date" name="date" ></h3></td></tr> 
<tr><td><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;at&nbsp;&nbsp;<select name="loc">
  <option value="Neemrana">Neemrana</option>
  <option value="Delhi">Delhi</option>
  <option value="Jaipur">Jaipur</option>
  <option value="Rewari">Rewari</option>
</select></h3></td></tr> 
<tr><td><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Post Activity" class="button"></h3></td><tr>
</table>
</form>
<h3 align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHER ACTIVITIES</h3>
<h3 align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Study"><font color="orange"><b><i>Study</i></b></font></a> || <a href="Play"><font color="orange"><b><i>Sport</i></b></font></a> || <a href="Movie"><font color="orange"><b><i>Movie</i></b></font></a> || <a href="Misc"><font color="orange"><b><i>Miscellaneous</i></b></font></a></h3>
<h4 align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Home"><font color="orange"><b><i>Click here to go back to home</i></b></a></h4>


<div id="mySidenav" class="sidenav">
  
  <a href="#">About</a>
  <a href="Play">Play</a>
  <a href="#">Study</a>
  <a href="#">Party</a>
  <a href="#">Movies</a>
</div>


</section>
</body>
</html> 

