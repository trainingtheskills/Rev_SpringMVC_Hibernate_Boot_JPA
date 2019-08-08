<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
       <form:form method="post" action="save" modelAttribute="book">    
        <table >    
         <tr>    
          <td>Title : </td>   
          <td><form:input path="title"  /></td>   <!-- book.getTitle() -->
         </tr>    
         <tr>    
          <td>Author :</td>    
          <td><form:input path="author" /></td>  
         </tr>   
         <tr>    
          <td>Price:</td>    
          <td><form:input path="price" /></td>  
         </tr>   
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    