   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th></tr>  
   <c:forEach var="book" items="${list}">   
   <tr>  
   <td>${book.id}</td>  
   <td>${book.title}</td>  
   <td>${book.author}</td>  
   <td>${book.price}</td>  
   </tr>  
   </c:forEach>  
   </table> 