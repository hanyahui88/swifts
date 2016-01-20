<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>数据管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/test/testData/">数据列表</a></li>
		<shiro:hasPermission name="test:testData:edit"><li><a href="${ctx}/test/testData/form">数据添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="testData" action="${ctx}/test/testData/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNum" type="hidden" value="${page.pageNum}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>name：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>name</th>
				<shiro:hasPermission name="test:testData:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="testData">
			<tr>
				<td><a href="${ctx}/test/testData/form?id=${testData.id}">
					${testData.name}
				</a></td>
				<shiro:hasPermission name="test:testData:edit"><td>
    				<a href="${ctx}/test/testData/form?id=${testData.id}">修改</a>
					<a href="${ctx}/test/testData/delete?id=${testData.id}" onclick="return confirmx('确认要删除该数据吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>