<%@page import="com.gps_tracking.model.Vehicle"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1 class="mb-4">Vehicle List</h1>
    <table class="table">
        <thead>
            <tr>
                <th>Vehicle ID</th>
                <th>Registration Number</th>
                <th>Bike Model</th>
                <th>Insurance Expiry Date</th>
                <th>Purchased Date</th>
                <th>Owner</th>
                <th>Calculate Distance</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
                if (vehicles != null) {
                    for (Vehicle vehicle : vehicles) {
            %>
                        <tr>
                            <td><%= vehicle.getId() %></td>
                            <td><%= vehicle.getRegistrationNumber() %></td>
                            <td><%= vehicle.getBikeModel() %></td>
                            <td><%= vehicle.getInsuranceExpiryDate() %></td>
                            <td><%= vehicle.getPurchasedDate() %></td>
                            <td><%= vehicle.getOwner().getName() %></td>
                            <td>
                                <form action="/get-distance" method="get">
			                    <input type="hidden" name="vehicleId" value="<%= vehicle.getId() %>">
			                    <input type="date" name="startDate" required>
			                    <input type="date" name="endDate" required>
			                    <button type="submit" class="btn btn-primary btn-sm">Calculate Distance</button>
			                </form>
                            </td>
                        </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</div>

</body>
</html>
