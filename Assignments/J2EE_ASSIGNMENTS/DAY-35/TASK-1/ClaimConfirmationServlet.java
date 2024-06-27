package com.serveletjsp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ClaimConfirmationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the ClaimBean object from the request scope
        ClaimBean claimBean = (ClaimBean) req.getAttribute("claimBean");

        // Process the claim (e.g., store in database, send to insurance company, etc.)
        // For demonstration purposes, simply print the claim information
        System.out.println("Claim submitted: " + claimBean.getClaimantName() + ", " + claimBean.getClaimType() + ", " + claimBean.getClaimDescription() + ", $" + claimBean.getClaimAmount());

        // Forward the request to the JSP page for confirmation
        RequestDispatcher dispatcher = req.getRequestDispatcher("claimSubmitted.jsp");
        dispatcher.forward(req, resp);
    }
}