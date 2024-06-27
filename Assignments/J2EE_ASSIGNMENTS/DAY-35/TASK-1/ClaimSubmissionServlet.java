package com.serveletjsp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ClaimSubmissionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get claim information from request parameters
        String claimantName = req.getParameter("claimantName");
        String claimType = req.getParameter("claimType");
        String claimDescription = req.getParameter("claimDescription");
        double claimAmount = Double.parseDouble(req.getParameter("claimAmount"));

        // Create a ClaimBean object to store claim information
        ClaimBean claimBean = new ClaimBean();
        claimBean.setClaimantName(claimantName);
        claimBean.setClaimType(claimType);
        claimBean.setClaimDescription(claimDescription);
        claimBean.setClaimAmount(claimAmount);

        // Store the ClaimBean object in the request scope
        req.setAttribute("claimBean", claimBean);

        // Forward the request to the JSP page for confirmation
        RequestDispatcher dispatcher = req.getRequestDispatcher("confirmClaim.jsp");
        dispatcher.forward(req, resp);
    }
}