   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
	<body>
	<form:form method="get" action="booklist" modelAttribute="book">
	<p> The Book is saved : ${book.title}   ${book.author} ${book.price} </p>
	
	 <input type="submit"  />
	</form:form>
	</body>
</html> 
