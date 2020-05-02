<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<div class="container">
      <div id="carbonads-container">
        <div class="carbonad">
          <div id="azcarbon"></div>
        </div>
      </div>

	<div class="posts-container px-3 mx-auto my-5">
		<div class="post">
		    <h1 class="post-title fw-500">${activity.title}</h1>
		    <span class="post-date">${activity.createTime}</span><!-- <div class="embed-responsive embed-responsive-16by9"></div> -->
		</div>				
		<p>${activity.detail}</p>
	</div>

	<div class="related">
		<h2>最近的活动</h2>
		<ul class="related-posts">
		<c:forEach var="activity" items="${activityList}">
			<li>
		        <h4>
		          <a href="activity?id=${activity.id}">
		            ${activity.title}
		            <small>${activity.createTime}</small>
		          </a>
		        </h4>
			</li>
		</c:forEach>
		</ul>
	</div>
</div>

<%@ include file="layout/footer.jsp" %>
