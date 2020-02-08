package com.yosephmartin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InternetAccess {

    private String employeeName;
    private String websiteAddress;

    public InternetAccess(String employeeName, String websiteAddress) {
        this.employeeName = employeeName;
        this.websiteAddress = websiteAddress;
    }

    public void grantInternetAccess() {
        if (getAuthorization() == 1) {
            // grant the internet access to the employee
            System.out.println("Internet access has been granted to " + employeeName);
            System.out.println("Accessing " + websiteAddress + ".....");
        }
        else if  (getAuthorization() == 2) {
            // the website is blocked
            System.out.println("Sorry, " + websiteAddress + " is blocked");
            System.out.println("Declined access to " + websiteAddress + ".....");
        } else if  (getAuthorization() == -1) {
            // the employee is not authorized to access the internet
            System.out.println("Sorry, " + employeeName + " is not authorized to access the internet");
            System.out.println("Declined access to " + websiteAddress + ".....");
        }
        else if  (getAuthorization() == 0) {
            // the employee is not found in the system
            System.out.println("Cannot find " + employeeName + " in the system");
            System.out.println("Declined access to " + websiteAddress + ".....");
        } else {
            System.out.println("Something went wrong");
        }
    }

    public int getAuthorization() {
        // example, retrieve employee data from the database
        // SAMPLE EMPLOYEE DATA
        // Map<EmployeeName, Authorization>
        Map<String, Boolean> employeeData = new HashMap<>();
        employeeData.put("Yoseph Martin Christian", true);
        employeeData.put("Jack", true);
        employeeData.put("Jacob", false);

        // example, retrieve the blocked websites address from the database
        // SAMPLE BLOCKED WEBSITES ADDRESS
        ArrayList<String> blockedWebsites = new ArrayList<>();
        blockedWebsites.add("https://facebook.com");
        blockedWebsites.add("https://instagram.com");
        blockedWebsites.add("https://twitter.com");

        // find the employee data
        if (employeeData.containsKey(employeeName)) {
            // check if the employee is authorized to access the internet
            if (employeeData.get(employeeName).equals(true)) {
                // check if the website is blocked or not
                if (blockedWebsites.contains(websiteAddress)) {
                    // the employee is authorized to access the internet but the website is blocked
                    return 2;
                } else {
                    // the employee is authorized to access the internet and the website is not blocked
                    return 1;
                }
            } else {
                // the employee is not authorized to access the internet
                return -1;
            }
        } else {
            // employee not found
            return 0;
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

}
