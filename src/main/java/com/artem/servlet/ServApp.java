package com.artem.servlet;

import com.artem.parser.Parser;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServApp extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String kitchenDevice = request.getParameter("kitchenDevice");
        String bathroomDevice = request.getParameter("bathroomDevice");
        String longueRoomDevice = request.getParameter("longueRoomDevice");


        try {

            if (kitchenDevice != null) {
                Parser parser = new Parser();
                parser.buildListDeviceKitchen();
                writer.println("<p>" + parser.getAllDevices() + "</p>");
                writer.println("<p>" + kitchenDevice + "</p>");// для проверки работы

            }
            if (bathroomDevice != null) {
                Parser parser = new Parser();
                parser.buildListDeviceBathroom();
                writer.println("<p>" + parser.getAllDevices() + "</p>");
                writer.println("<p>" + bathroomDevice + "</p>");// для проверки работы

            }
            if (longueRoomDevice != null) {
                Parser parser = new Parser();
                parser.buildListDeviceLongueRoom();
                writer.println("<p>" + parser.getAllDevices() + "</p>");
                writer.println("<p>" + longueRoomDevice + "</p>"); // для проверки работы

            }

        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}