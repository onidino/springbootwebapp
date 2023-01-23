  <!-- JSPF HEADER -->
  <%@ include file="common/header.jspf" %>
    <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css" rel="stylesheet">

  <!-- JSPF NAV BAR -->
  <%@ include file="common/navigation.jspf" %>


    <div class="container">
      <h1>Enter Todo Details</h1>
      <form:form method="post" modelAttribute="todo">
        <!-- DESCRIPTION -->
        <fieldset class="mb-2">
          <form:label path="description">Description:</form:label>
          <form:input type="text" path="description" required="required" />
          <form:errors path="description" cssClass="text-warning" />
        </fieldset>
        <!-- TARGET_DATE -->
        <fieldset class="mb-2">
          <form:label path="targetDate">Target Date:</form:label>
          <form:input id="targetDate" readonly="true" type="text" path="targetDate" required="required" />
          <form:errors path="targetDate" cssClass="text-warning" />
        </fieldset>

        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done" />
        </br><input type="submit" class="btn btn-success" value="Confirm" />
      </form:form>
    </div>

  <!-- JSPF FOOTER -->
  <%@ include file="common/footer.jspf" %>
  <script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>
  <script type="text/javascript">
    $('#targetDate').datepicker({
      format: 'yyyy-mm-dd'
    });
  </script>