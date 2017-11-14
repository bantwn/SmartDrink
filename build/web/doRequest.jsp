
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <title>Smart Drink</title>

    <!-- Bootstrap Css -->
    <link href="bootstrap-assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Style -->
    <link href="plugins/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="plugins/owl-carousel/owl.theme.css" rel="stylesheet">
    <link href="plugins/owl-carousel/owl.transitions.css" rel="stylesheet">
    <link href="plugins/Lightbox/dist/css/lightbox.css" rel="stylesheet">
    <link href="plugins/Icons/et-line-font/style.css" rel="stylesheet">
    <link href="plugins/animate.css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <!-- Icons Font -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    </head>
<body>
    
    <!-- Preloader
	============================================= -->
    <div class="preloader"><i class="fa fa-circle-o-notch fa-spin fa-2x"></i></div>
    <!-- Header
	============================================= -->
    <section class="main-header">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        
                    </button>
                    
                </div>
                <div class="collapse navbar-collapse text-center" id="bs-example-navbar-collapse-1">
                    <div class="col-md-8 col-xs-12 nav-wrap">
                        <form action="logout.jsp"> <button class ="btn-sm" type="submit">log out</button></form>
                    </div>
                    <div class="social-media hidden-sm hidden-xs">
                        <ul class="nav navbar-nav">
                            <li><a href="http://www.facebook.com"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="http://www.twitter.com"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="http://www.instagram.com"><i class="fa fa-instagram"></i></a></li>
                            
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
 

    
<div class="item" style="background-image: url(img/sliders/cafe1.jpg)">        
<form method="post" action="RequestConfirmation">         
    <section id="contact">
        <div class="container">
            <h3><span>Choose the category of your request</span></h3>
            <hr class="sep">
            <div class="col-md-6 col-md-offset-3 wow fadeInUp" data-wow-delay=".3s">
                <form>
                    <div class="form-group">
                        <select name=r_category>
                            <option value="Drinks">Drinks</option>
                            <option value="Coffees">Coffees</option>
                        </select>    
                    </div>
                    
                    
        
                    <input type="Submit" class="btn-block" value="Do the request">
                    <input type="Reset" class="btn-block" value="Reset">
                    <tr>
                        <td colspan="2">Not Yet Registered? <a href="businessRegister.jsp">Register Here!</a></td>
                    </tr>
                </form>
            </div>
        </div>
    </section>
</form>    
</div>
  
</section>     
      <footer>
        <div class="container">
            <h1>SMART DRINK</h1>
            <div class="social">
                <a href="http://www.facebook.com"><i class="fa fa-facebook fa-2x"></i></a>
                <a href="http://www.twitter.com"><i class="fa fa-twitter fa-2x"></i></a>
                <a href="http://www.instagram.com"><i class="fa fa-instagram fa-2x"></i></a>
            </div>
            
        </div>
    </footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-assets/js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
    <!-- JS PLUGINS -->
    <script src="plugins/owl-carousel/owl.carousel.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="plugins/waypoints/jquery.waypoints.min.js"></script>
    <script src="plugins/countTo/jquery.countTo.js"></script>
    <script src="plugins/inview/jquery.inview.min.js"></script>
    <script src="plugins/Lightbox/dist/js/lightbox.min.js"></script>
    <script src="plugins/WOW/dist/wow.min.js"></script>
    <!-- GOOGLE MAP -->
    <script src="https://maps.googleapis.com/maps/api/js"></script>
    
</body>     
</html>
