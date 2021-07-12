<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>SpamDoop</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Facebook Opengraph integration: https://developers.facebook.com/docs/sharing/opengraph -->
<meta property="og:title" content="">
<meta property="og:image" content="">
<meta property="og:url" content="">
<meta property="og:site_name" content="">
<meta property="og:description" content="">

<!-- Twitter Cards integration: https://dev.twitter.com/cards/  -->
<meta name="twitter:card" content="summary">
<meta name="twitter:site" content="">
<meta name="twitter:title" content="">
<meta name="twitter:description" content="">
<meta name="twitter:image" content="">

<!-- Fav and touch icons -->
<link rel="shortcut icon" href="img/icons/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="img/icons/114x114.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="img/icons/72x72.png">
<link rel="apple-touch-icon-precomposed" href="img/icons/default.png">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.carousel.min.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.theme.min.css" rel="stylesheet">
<link href="lib/owlcarousel/owl.transitions.min.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="css/style.css" rel="stylesheet">

<!--Your custom colour override - predefined colours are: colour-blue.css, colour-green.css, colour-lavander.css, orange is default-->
<link href="#" id="colour-scheme" rel="stylesheet">

<!-- =======================================================
    Theme Name: Flexor
    Theme URL: https://bootstrapmade.com/flexor-free-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<!-- ======== @Region: body ======== -->

<body class="page-elements">
	<!--Change the background class to alter background image, options are: benches, boots, buildings, city, metro -->
	<div id="background-wrapper" class="benches"
		data-stellar-background-ratio="0.8">

		<!-- ======== @Region: #navigation ======== -->
		<div id="navigation" class="wrapper">
			<!--Hidden Header Region-->

			<!--Header & navbar-branding region-->
			<div class="header">
				<div class="header-inner container">
					<div class="row">
						<div class="col-md-8">
							<!--navbar-branding/logo - hidden image tag & site name so things like Facebook to pick up, actual logo set via CSS for flexibility -->
							<a class="navbar-brand" href="index.html" title="Home">
								<h1 class="hidden">
									<img src="img/logo.png" alt="Flexor Logo"> SpamDoop
								</h1>
							</a>
							<div class="navbar-slogan">
								Collaborative <br> Spam Detection
							</div>
						</div>
						<!--header rightside-->

					</div>
				</div>
			</div>
			<div class="container">
				<div class="navbar navbar-default">
					<!--mobile collapse menu button-->
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target=".navbar-collapse"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!--everything within this div is collapsed on mobile-->
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav" id="main-menu">
							<li><a href="index.jsp">Home</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Access Project<b class="caret"></b></a> <!-- Dropdown Menu -->
								<ul class="dropdown-menu">
									<li class="dropdown-header">Actions</li>
									<li><a href="register.jsp" tabindex="-1" class="menu-item">Register</a></li>
									<li><a href="login.jsp" tabindex="-1" class="menu-item">Login</a></li>
								</ul></li>

						</ul>
					</div>
					<!--/.navbar-collapse -->
				</div>
			</div>
		</div>
	</div>

	<!-- ======== @Region: #content ======== -->
	<div id="content">
		<div class="container" style='min-height:500px;'>
								<h2>Registration</h2>
			<hr/>
			
			
			
				<div class='row'>
					<div class='col-md-8'>
					<br/>
							<%
								String msg = request.getParameter("msg");
							%>
							<%
								if (msg != null) {
							%>
								<div class="alert alert-success alert-dismissable">
								  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								  <strong>Message!</strong> <%=msg %>.
								</div>
							<%
								}  
							%>
   							<br/>    
							<form method="post" action="account" style='color:black; text-align:left;' class='well'>

							<input type="hidden" name='request_type' value='register' /> <label>Email:</label>
							<input type="text" name="email" class="form-control" required="required"/>
							
<br/>   
							<label>Password:</label> <input type="password" name="password"
								class="validate-email form-control" required="required"/>
							<br/>
							<label>First name:</label> <input type="text" name="fname"
								class="form-control" required="required"/>
							<br/>
							<label>Last name:</label> <input type="text" name="lname"
								class="form-control" required="required"/>
							<br/>

							<label>Gender:</label> <br/><input type="radio" name='gender'
								value='Male' /> Male &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name='gender'
								value='Female' /> Female

							<br/><br/>

							<label>Mobile:</label> <input type="text" name="mobile"
								class="form-control" required="required"/>
							<br/>
							<label>Address:</label>
							<textarea name="addr" rows=3 class="form-control" required="required"></textarea>
							<br/>

							<input style="font-weight: bold;" type="submit"
								class="btn btn-primary" name="submit" id="submit" value=" Register " />
							

  
							</form>   
					
					
					</div>
					<div class='col-md-2'></div>
														<div class='col-md-2'></div>
									
				</div>
				
			
			
			
			
		</div>
	</div>
	
	<!-- ======== @Region: #footer ======== -->
	<footer id="footer" class="block block-bg-grey-dark"
		data-block-bg-img="img/bg_footer-map.png"
		data-stellar-background-ratio="0.4">
		<div class="container">
			<a href="#top" class="scrolltop">Top</a>
			
			 <div class="row subfooter">
        <!--@todo: replace with company copyright details-->
        <div class="col-md-7">
          <p>Copyright © SpamDoop</p>
          <div class="credits">
            <!--
              All the links in the footer should remain intact.
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Flexor
            -->
            Final Year Project Work
          </div>
        </div>
        
      </div>
		</div>
	</footer>

	<!-- Required JavaScript Libraries -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/stellar/stellar.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/counterup/counterup.min.js"></script>
	<script src="contactform/contactform.js"></script>

	<!-- Template Specisifc Custom Javascript File -->
	<script src="js/custom.js"></script>

	<!--Custom scripts demo background & colour switcher - OPTIONAL -->
	<script src="js/color-switcher.js"></script>

	<!--Contactform script -->
	<script src="contactform/contactform.js"></script>

</body>

</html>
