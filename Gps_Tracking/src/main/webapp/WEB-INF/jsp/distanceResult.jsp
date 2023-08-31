<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Distance Result</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1 class="mb-4">Distance Result</h1>
    <c:if test="${errorMessage != null}">
        <p class="alert alert-danger">${errorMessage}</p>
    </c:if>
    <c:if test="${vehicle != null}">
        <p>Distance traveled for vehicle ${vehicle.id}: <strong>${distance} kilometers</strong></p>
    </c:if>
</div>

</body>
</html>
