package com.artem.parser;


import com.artem.device.BathroomDevice;
import com.artem.device.Device;
import com.artem.device.KitchenDevice;
import com.artem.device.LongueRoomDevice;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<Device> allDevices;
    private DocumentBuilder documentBuilder;

    public Parser() {
        this.allDevices = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public List<Device> getAllDevices() {
        System.out.println("Size= " + allDevices.size());
        System.out.println("List= " + allDevices);

        return allDevices;
    }

    public void buildListDeviceKitchen() throws IOException, SAXException {

        try {
            Document doc1 = documentBuilder.parse("deviceHands.xml");
            Element root = doc1.getDocumentElement();
            NodeList deviceListKitchen = root.getElementsByTagName("KitchenDevice");
            for (int i = 0; i < deviceListKitchen.getLength(); i++) {
                Element kitchenElement = (Element) deviceListKitchen.item(i);
                Device kitchen = buildDeviceKitchen(kitchenElement);
                allDevices.add(kitchen);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buildListDeviceBathroom() throws IOException, SAXException {
        try {
            Document doc2 = documentBuilder.parse("deviceHands.xml");
            Element root = doc2.getDocumentElement();
            NodeList deviceListBath = root.getElementsByTagName("BathroomDevice");
            for (int j = 0; j < deviceListBath.getLength(); j++) {
                Element bathElement = (Element) deviceListBath.item(j);
                Device bath = buildDeviceBath(bathElement);
                allDevices.add(bath);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void buildListDeviceLongueRoom() throws IOException, SAXException {
        try {
            Document doc1 = documentBuilder.parse("deviceHands.xml");
            Element root = doc1.getDocumentElement();
            NodeList deviceListLongue = root.getElementsByTagName("LongueRoomDevice");
            for (int k = 0; k < deviceListLongue.getLength(); k++) {
                Element longueElement = (Element) deviceListLongue.item(k);
                Device longue = buildDeviceLongue(longueElement);
                allDevices.add(longue);

            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Device buildDeviceKitchen(Element kitchenElement) {

        KitchenDevice kitchenDevice = new KitchenDevice();
        getDeviceField(kitchenDevice, kitchenElement);
        Integer temperatureMinim = Integer.parseInt(getElementTextContent(kitchenElement, "minTemperature"));
        kitchenDevice.setMinTemperature(temperatureMinim);
        Integer temperatureMaxim = Integer.parseInt(getElementTextContent(kitchenElement, "maxTemperature"));
        kitchenDevice.setMaxTemperature(temperatureMaxim);

        return kitchenDevice;
    }

    private Device buildDeviceBath(Element bathElement) {
        BathroomDevice bathroomDevice = new BathroomDevice();
        getDeviceField(bathroomDevice, bathElement);
        Boolean water = Boolean.parseBoolean(getElementTextContent(bathElement, "waterproof"));
        bathroomDevice.setWaterproof(water);

        return bathroomDevice;
    }

    private Device buildDeviceLongue(Element longueElement) {
        LongueRoomDevice longueRoomDevice = new LongueRoomDevice();
        getDeviceField(longueRoomDevice, longueElement);
        Boolean display = Boolean.parseBoolean(getElementTextContent(longueElement, "lcdDisplay"));
        longueRoomDevice.setLcdDisplay(display);
        Boolean wifi = Boolean.parseBoolean(getElementTextContent(longueElement, "wiFi"));
        longueRoomDevice.setWiFi(wifi);
        Boolean bluet = Boolean.parseBoolean(getElementTextContent(longueElement, "bluetooth"));
        longueRoomDevice.setBluetooth(bluet);
        return longueRoomDevice;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }

    private <T extends Device> void getDeviceField(T device, Element dev) {
        device.setName(getElementTextContent(dev, "name"));
        Integer powerSize = Integer.parseInt(getElementTextContent(dev, "powerSizekW"));
        device.setPowerSizekW(powerSize);
        Boolean power = Boolean.parseBoolean(getElementTextContent(dev, "powerON"));
        device.setPowerON(power);
        Integer serial = Integer.parseInt(getElementTextContent(dev, "serialNumber"));
        device.setSerialNumber(serial);
    }
}