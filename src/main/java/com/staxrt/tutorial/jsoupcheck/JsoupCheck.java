package com.staxrt.tutorial.jsoupcheck;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupCheck {
    static String result;

    public static String check(String applicationNumImport, String xxFieldImport, String applicationTypeImport, String yearImport) {

        Connection.Response loginForm = null;
        try {
            loginForm = Jsoup.connect("https://frs.gov.cz/en/ioff/application-status")
                    .method(Connection.Method.GET)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = Jsoup.connect("https://frs.gov.cz/en/ioff/application-status")
                    //.data("cookieexists", "false")
                    .data("ioff_application_number", applicationNumImport)
                    .data("ioff_application_number_fake", xxFieldImport)
                    .data("ioff_application_code", applicationTypeImport)
                    .data("ioff_application_year", yearImport)
                    //.data("form_build_id", "form-Zz27FTR7rhWExMb7bkcT1JD1jvMmHpHM4r7A-AkE1tM")
                    .data("form_id", "ioff_application_status_form")
                    .data("honeypot_time", "1609108448|S6GNmhnN6gA6mbqzXaZP90qH0rylPmeZY831BES6MBI")
                    .cookies(loginForm.cookies())
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String approvedStatus = String.valueOf(document.getElementsMatchingOwnText("Decided – APPROVED"));
        String inprocessStatus = String.valueOf(document.getElementsMatchingOwnText("Process"));
        //String rejectedStatus = String.valueOf(document.getElementsMatchingOwnText("Decided – REJECTED"));

        if(!empty(approvedStatus)){
            result = "Decided – APPROVED";
        }else if (!empty(inprocessStatus)){
            result = "In Process";
        }
        else {
            result = "Decided – REJECTED";
        }

        return result;
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
}
