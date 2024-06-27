<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm Claim</title>
</head>
<body>
    <h1>Confirm Claim</h1>
    <p>Please review the claim information:</p>
    <table>
        <tr>
            <td>Claimant Name:</td>
            <td>${claimBean.claimantName}</td>
        </tr>
        <tr>
            <td>Claim Type:</td>
            <td>${claimBean.claimType}</td>
        </tr>
        <tr>
            <td>Claim Description:</td>
            <td>${claimBean.claimDescription}</td>
        </tr>
        <tr>
            <td>Claim Amount:</td>
            <td>$${claimBean.claimAmount}</td>
        </tr>
    </table>
    <form action="ClaimConfirmationServlet" method="post">
        <input type="submit" value="Submit Claim">
    </form>
</body>
</html>