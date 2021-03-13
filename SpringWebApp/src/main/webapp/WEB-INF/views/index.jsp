<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/icomoon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/superfish.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<script src="${pageContext.request.contextPath}/resources/js/modernizr-2.6.2.min.js"></script>
</head>

<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">
		<div id="fh5co-header">
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
						<h1 id="fh5co-logo"><a href="${pageContext.request.contextPath}/">${message }</a></h1>
						<!-- START #fh5co-menu-wrap -->
						<nav id="fh5co-menu-wrap" role="navigation">
							<ul class="sf-menu" id="fh5co-primary-menu">
								<li class="active">
									<a href="${pageContext.request.contextPath}/">Home</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/login" class="fh5co-sub-ddown">Login</a>
								</li>
							<!--  <li>
									<a href="#" class="fh5co-sub-ddown">Dropdown</a>
									 <ul class="fh5co-sub-menu">
									 	<li><a href="#">Web Development</a></li>
									 	<li><a href="#">Branding &amp; Identity</a></li>
										<li>
											<a href="#" class="fh5co-sub-ddown">Free HTML5</a>
											<ul class="fh5co-sub-menu">
												<li><a href="#">Build</a></li>
												<li><a href="#">Work</a></li>
												<li><a href="#">Light</a></li>
												<li><a href="#">Relic</a></li>
												<li><a href="#">Display</a></li>
												<li><a href="#">Sprint</a></li>
											</ul>
										</li>
										<li><a href="#">UI Animation</a></li>
										<li><a href="#">Copywriting</a></li>
										<li><a href="#">Photography</a></li> 
									</ul>
								</li> -->	
								<li><a href="#">Contact</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</header>
		</div>
		
		
		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover text-center" data-stellar-background-ratio="0.5" style="background-image: url(${pageContext.request.contextPath}/resources/images/cover_bg_1.jpg);">
				<div class="desc animate-box">
					<h2>Travel Around The World.</h2>
					<span><a class="btn btn-primary btn-lg" href="#">Get Started</a></span>
				</div>
			</div>
		</div>


		<div class="fh5co-listing">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-sm-4 fh5co-item-wrap">
						<a class="fh5co-listing-item">
							<img src="${pageContext.request.contextPath}/resources/images/hyderabad.jpg" alt="Free HTML5 Bootstrap Template by FreeHTML5.co" class="img-responsive">
							<div class="fh5co-listing-copy">
								<h2>Hyderabad</h2>
								<span class="icon">
									<i class="icon-chevron-right"></i>
								</span>
							</div>
						</a>
					</div>
					<div class="col-md-4 col-sm-4 fh5co-item-wrap">
						<a class="fh5co-listing-item">
							<img src="${pageContext.request.contextPath}/resources/images/chennai.jpg" alt="Free HTML5 Bootstrap Template by FreeHTML5.co" class="img-responsive">
							<div class="fh5co-listing-copy">
								<h2>Chennai</h2>
								<span class="icon">
									<i class="icon-chevron-right"></i>
								</span>
							</div>
						</a>
					</div>
					<div class="col-md-4 col-sm-4 fh5co-item-wrap">
						<a class="fh5co-listing-item">
							<img src="${pageContext.request.contextPath}/resources/images/bangalore.jpg" alt="Free HTML5 Bootstrap Template by FreeHTML5.co" class="img-responsive">
							<div class="fh5co-listing-copy">
								<h2>Bangalore</h2>
								<span class="icon">
									<i class="icon-chevron-right"></i>
								</span>
							</div>
						</a>
					</div>
					<!-- END 3 row -->

					<div class="col-md-4 col-sm-4 fh5co-item-wrap">
						<a class="fh5co-listing-item">
							<img src="${pageContext.request.contextPath}/resources/images/visakhapatnam.jpg" alt="Free HTML5 Bootstrap Template by FreeHTML5.co" class="img-responsive">
							<div class="fh5co-listing-copy">
								<h2>Vizag</h2>
								<span class="icon">
									<i class="icon-chevron-right"></i>
								</span>
							</div>
						</a>
					</div>
					<div class="col-md-4 col-sm-4 fh5co-item-wrap">
						<a class="fh5co-listing-item">
							<img src="${pageContext.request.contextPath}/resources/images/kolkata.jpg" alt="Free HTML5 Bootstrap Template by FreeHTML5.co" class="img-responsive">
							<div class="fh5co-listing-copy">
								<h2>Kolkata</h2>
								<span class="icon">
									<i class="icon-chevron-right"></i>
								</span>
							</div>
						</a>
					</div>
					<div class="col-md-4 col-sm-4 fh5co-item-wrap">
						<a class="fh5co-listing-item">
							<img src="${pageContext.request.contextPath}/resources/images/mumbai.jpg" alt="Free HTML5 Bootstrap Template by FreeHTML5.co" class="img-responsive">
							<div class="fh5co-listing-copy">
								<h2>Mumbai</h2>
								<span class="icon">
									<i class="icon-chevron-right"></i>
								</span>
							</div>
						</a>
					</div>
					<!-- END 3 row -->
				</div>
			</div>
		</div>


		<div class="fh5co-section">
			<div class="container">
				<div class="row">
					<div class="col-md-6 fh5co-news">
						<h3>News</h3>
						<ul>
							<li>
								<a href="#">
									<span class="fh5co-date">Sep. 10, 2016</span>
									<h3>Newly done Bridge of London</h3>
									<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusamus reprehenderit!</p>
								</a>
							</li>
							<li>
								<a href="#">
									<span class="fh5co-date">Sep. 10, 2016</span>
									<h3>Newly done Bridge of London</h3>
									<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusamus reprehenderit!</p>
								</a>
							</li>
							<li>
								<a href="#">
									<span class="fh5co-date">Sep. 10, 2016</span>
									<h3>Newly done Bridge of London</h3>
									<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusamus reprehenderit!</p>
								</a>
							</li>
						</ul>
					</div>
					<div class="col-md-6 fh5co-testimonial">
						<img src="${pageContext.request.contextPath}/resources/images/cover_bg_1.jpg" alt="Free HTML5 Bootstrap Template by FreeHTML5.co" class="img-responsive mb20">
						<img src="${pageContext.request.contextPath}/resources/images/cover_bg_1.jpg" alt="Free HTML5 Bootstrap Template by FreeHTML5.co" class="img-responsive">
					</div>
				</div>
			</div>
		</div>
		
		<footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 text-center">
							<p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p>
							<p>Copyright 2016 Free Html5 <a href="#">Listing</a>. All Rights Reserved. <br>Made with <i class="icon-heart3"></i> by <a href="http://freehtml5.co/" target="_blank">Freehtml5.co</a> / Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash</a></p>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.waypoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.stellar.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/hoverIntent.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/superfish.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	</body>
</html>
