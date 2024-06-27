<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Submit Claim</title>
</head>
<body>
    <h1>Submit Claim</h1>
    <form action="ClaimSubmissionServlet" method="post">
        <label for="claimantName">Claimant Name:</label>
        <input type="text" id="claimantName" name="claimantName"><br><br>
        <label for="claimType">Claim Type:</label>
        <input type="text" id="claimType" name="claimType"><br><br>
        <label for="claimDescription">Claim Description:</label>
        <textarea id="claimDescription" name="claimDescription"></textarea><br><br>
        <label for="claimAmount">Claim Amount:</label>
        <input type="number" id="claimAmount" name="claimAmount"><br><br>
        <input type="submit" value="Submit Claim">
    </form>
</body>
</html>