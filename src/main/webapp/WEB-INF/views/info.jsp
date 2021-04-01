<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h3> Information for all people</h3>
<br><br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="GetSalary"
onclick="window.location.href='manager_info'"/>
Only for managers.
</security:authorize>
<br>
<security:authorize access="hasRole('OWNER')">
<input type="button" value="Performance"
       onclick="window.location.href='owner_info'"/>
Only for owners.
</security:authorize>

</body>
</html>