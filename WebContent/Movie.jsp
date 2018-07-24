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
<section style="background-image:url(img/movie_back1.jpg);height: 675px">

<br/><br/><br/><br/><br/>
<h1 align="center"><i><b><font color="orange">Post which movie are you going to watch and find a mate.</font></b></i></h1>

<form  action="PostMovie" method="get">
<table align="center">
<tr><td><h3>I want to watch  <input type="hidden" name="movie" value="movie">  <input type="text" name="maker" placeholder="enter movie name here"> movie</h2></td></tr>
<tr><td><h3>on <input type="date" name="date" ></h3></td></tr> 
<tr><td><h3>at <select name="loc">
  <option value="Neemrana">Neemrana</option>
  <option value="Delhi">Delhi</option>
  <option value="Jaipur">Jaipur</option>
  <option value="Rewari">Rewari</option>
</select></h3></td></tr>
 
<tr><td> <h3> <input type="submit" value="Post Activity" class="button"> </h3> </td><tr>
</table>

</form>
<h3 align="center"><i><b><font color="orange">Other Activities</font></b></i></h3>
<h3 align="center"> <font color="orange"> <a href="Study"><font color="orange"><b><i>Study</i></b></font></a> || <a href="Play"><font color="orange"><b><i>Sport</i></b></font></a> || <a href="Party"><font color="orange"><b><i>Party</i></b></font></a> || <a href="Misc"><font color="orange"><b><i>Miscellaneous</i></b></font></a></font></h3>
<br/>	
<h4 align="center"><a href="Home"><font color="orange"><b><i>Click here to go back to home</i></b></a></h4>


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