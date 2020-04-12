<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pagination" tagdir="/WEB-INF/tags/desktop/nav/pagination" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="facebookUrl" required="false" rtexprvalue="true" %>

<c:url value="${facebookUrl}" var="url" />
<a href="${url}">
	<button type="button" class="btn btn-default facebook">
		<i class="icon-Facebook" aria-hidden="true"></i>&nbsp;&nbsp;<spring:theme code="social.network.facebookbutton.text" />
	</button>
</a>
