<!--ΠΡΟΣΦΟΡΕΣ ΠΟΤΟΥ ΓΙΑ ΤΟΝ ΠΕΙΡΑΙΑ-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <title>RISE-Multipurpose Html Template</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">

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
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>










<section id="portfolio">
        <div class="container-fluid">
            <h2>Προσφορες Ποτων</h2>
            <hr class="sep">
            <p>Διαλέξτε την προσφορά που σας ταιριάζει!!!</p>
            <p>ΠΕΙΡΑΙΑΣ</p>
            <div class="row">
                <div class="col-lg-4 col-sm-6 wow fadeInUp" data-wow-delay=".3s">
                    <a class="portfolio-box" href="img/portfolio/11.jpg" data-lightbox="image-11" data-title="Your caption">
                        <img src="img/portfolio/11.jpg" class="img-responsive" alt="1">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Madama
                                </div>
                                <div class="project-name">
                                     1+1 ποτό
                                </div>
                            </div>
                        </div>
                    </a>
                    <form method="post" action="OrderConfirmation" >
                             <br> <br> 
                               
                        <script
                          src="https://checkout.stripe.com/checkout.js" class="stripe-button"
                          data-key="pk_test_6pRNASCoBOKtIshFeQd4XMUh"                      
                          data-name="Stripe.com"
                          data-description="Widget"
                          data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                          data-locale="auto"
                          data-zip-code="true">
                        </script>
                        <input type="hidden" name ="shopName" value="Madama">
                        <input type="hidden" name ="productName" value="All drinks">
                        <input type="hidden" name ="discount" value="1+1">
                    </form> 
                </div>
                
                 
                <div class="col-lg-4 col-sm-6 wow fadeInUp" data-wow-delay=".3s">
                    <a href="img/portfolio/12.jpg" class="portfolio-box" data-lightbox="image-12" data-title="Your caption">
                        <img src="img/portfolio/12.jpg" class="img-responsive" alt="6">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                   Mind the Cup
                                </div>
                                <div class="project-name">
                                    Κρασιά -20%
                                </div>
                            </div>
                        </div>
                    </a>
                    <form method="post" action="OrderConfirmation" >
                             <br> <br> 
                               
                        <script
                          src="https://checkout.stripe.com/checkout.js" class="stripe-button"
                          data-key="pk_test_6pRNASCoBOKtIshFeQd4XMUh"                      
                          data-name="Stripe.com"
                          data-description="Widget"
                          data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                          data-locale="auto"
                          data-zip-code="true">
                        </script>
                        <input type="hidden" name ="shopName" value="Mind the cup">
                        <input type="hidden" name ="productName" value="Wines">
                        <input type="hidden" name ="discount" value="-20%">
                    </form> 
                </div>
                
                <div class="col-lg-4 col-sm-6 wow fadeInUp" data-wow-delay=".3s">
                    <a class="portfolio-box" href="img/portfolio/18.jpg" data-lightbox="image-18" data-title="Your caption">
                        <img src="img/portfolio/18.jpg" class="img-responsive" alt="1">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    DrinkBar
                                </div>
                                <div class="project-name">
                                     Wine -20%
                                </div>
                            </div>
                        </div>                         
                    </a>
                    <form method="post" action="OrderConfirmation" >
                             <br> <br> 
                               
                        <script
                          src="https://checkout.stripe.com/checkout.js" class="stripe-button"
                          data-key="pk_test_6pRNASCoBOKtIshFeQd4XMUh"                      
                          data-name="Stripe.com"
                          data-description="Widget"
                          data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                          data-locale="auto"
                          data-zip-code="true">
                        </script>
                        <input type="hidden" name ="shopName" value="DrinkBar">
                        <input type="hidden" name ="productName" value="Wine">
                        <input type="hidden" name ="discount" value="-20%">
                    </form> 
                </div>
            </div>
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