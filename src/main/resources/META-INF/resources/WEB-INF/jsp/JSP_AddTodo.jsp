<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
  <!-- JSPF HEADER -->
  <%@ include file="common/header.jspf" %>

    <div class="container">
      <h1>Enter Todo Details</h1>
      <form method="post">
        Description: <input type="text" name="description" required="required" />
        </br><input type="submit" class="btn btn-success" />
      </form>
    </div>

  <!-- JSPF FOOTER -->
  <%@ include file="common/footer.jspf" %>