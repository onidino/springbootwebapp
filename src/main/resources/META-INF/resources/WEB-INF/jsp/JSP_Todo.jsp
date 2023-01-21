<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <!-- CSS -->
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css" rel="stylesheet">
    <title>Add Todo Page</title>
  </head>
  <body>
    <div class="container">
      <h1>Enter Todo Details</h1>
      <form:form method="post" modelAttribute="todo">
        <!-- DESCRIPTION -->
        <fieldset class="mb-2">
          <form:label path="description">Description:</form:label>
          <form:input type="text" path="description" required="required"/>
          <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <!-- TARGET_DATE -->
        <fieldset class="mb-2">
          <form:label path="targetDate">Target Date:</form:label>
          <form:input id="targetDate" readonly="true" type="text" path="targetDate" required="required"/>
          <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="done"/>
        </br><input type="submit" class="btn btn-success" value="Confirm"/>
      </form:form>
    </div>

    <!-- JS -->
    <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
    <script src="webjars\jquery\3.6.0\jquery.js"></script>
    <script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
      $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
      });
    </script>
  </body>
</html>
