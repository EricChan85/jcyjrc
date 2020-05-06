<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
	  
	  <header>
	    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	      <ol class="carousel-indicators">
	        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	      </ol>
	      <div class="carousel-inner" role="listbox">
	        <!-- Slide One - Set the background image for this slide in the line below -->
	        <div class="carousel-item active" style="background-image: url('<c:url value="/static/img/1.jpg" />')">
	          <div class="carousel-caption d-none d-md-block">
	            <h3></h3>
	            <p>金川集体公司一线技术工人潘从明载誉归来.</p>
	          </div>
	        </div>
	        <!-- Slide Two - Set the background image for this slide in the line below -->
	        <div class="carousel-item" style="background-image: url('<c:url value="/static/img/2.jpg" />')">
	          <div class="carousel-caption d-none d-md-block">
	            <h3></h3>
	            <p>引才小组赴各大高校开展引才宣讲活动.</p>
	          </div>
	        </div>
	        <!-- Slide Three - Set the background image for this slide in the line below -->
	        <div class="carousel-item" style="background-image: url('<c:url value="/static/img/1900x1080.png" />')">
	          <div class="carousel-caption d-none d-md-block">
	            <h3></h3>
	            <p>示例图片，1900x1080.</p>
	          </div>
	        </div>
	      </div>
	      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	        <span class="sr-only">Previous</span>
	      </a>
	      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	        <span class="carousel-control-next-icon" aria-hidden="true"></span>
	        <span class="sr-only">Next</span>
	      </a>
	    </div>
	  </header>
	  
	  <!-- Page Content -->
	  <div class="container">
	
	    <h2 class="my-4">人才活动</h2>
	
	    <!-- Activity Section -->
	    <div class="row">
	    	<c:forEach var="activity" items="${activityList}">
	    		<div class="col-lg-4 mb-4">
			        <div class="card h-100">
			          <h4 class="card-header">${activity.title}</h4>
			          <div class="card-body">
			            <p class="card-text">${activity.sketch}</p>
			          </div>
			          <div class="card-footer">
			            <a href="activity?id=${activity.id}"  target="_blank" class="btn btn-primary">查看详情</a>
			          </div>
			        </div>
			      </div>
	    	</c:forEach>	      	      
	    </div>
	    <!-- /.row -->
	
	    <!-- 优秀人才 Section -->
	    <h2>优秀人才</h2>
	
	    <div class="row">
	    	<c:forEach var="rc" items="${personWithProfile}">
	    		<div class="col-lg-4 col-sm-6 portfolio-item">
			        <div class="card h-100">
			          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
			          <div class="card-body">
			            <h4 class="card-title">
			              <a href="#">${rc.name}</a>
			            </h4>
			            <p class="card-text">${rc.profile}</p>
			          </div>
			        </div>
			      </div>
	    	</c:forEach>
	    </div>
	    <!-- /.row -->
	
	    <!-- Features Section -->
	    <div class="row">
	      <div class="col-lg-6">
	        <h2>Modern Business Features</h2>
	        <p>The Modern Business template by Start Bootstrap includes:</p>
	        <ul>
	          <li>
	            <strong>Bootstrap v4</strong>
	          </li>
	          <li>jQuery</li>
	          <li>Font Awesome</li>
	          <li>Working contact form with validation</li>
	          <li>Unstyled page elements for easy customization</li>
	        </ul>
	        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p>
	      </div>
	      <div class="col-lg-6">
	        <img class="img-fluid rounded" src="http://placehold.it/700x450" alt="">
	      </div>
	    </div>
	    <!-- /.row -->
	
	    <hr>
	
	    <!-- Call to Action Section -->
	    <div class="row mb-4">
	      <div class="col-md-8">
	        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
	      </div>
	      <div class="col-md-4">
	        <a class="btn btn-lg btn-secondary btn-block" href="#">Call to Action</a>
	      </div>
	    </div>
	
	  </div>
	  <!-- /.container -->
	  
<%@ include file="layout/footer.jsp" %>
