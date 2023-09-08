package org.Mahagan.Test;

import org.Mahagan.config.Applicationconfig;
import org.Mahagan.dao.IOTDevice;
import org.Mahagan.dao.IOTDeviceImpl;
import org.Mahagan.model.IOTdevice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Applicationconfig.class);
        IOTDevice iotDevice = context.getBean(IOTDeviceImpl.class);

        System.out.println("List of device is:::::::::::");

        for (IOTdevice iotdevice : iotDevice.getAllDevice())
        {
            System.out.println(iotdevice);
        }
//        ==================================================================
        System.out.println("\nGet Device to ID 1 or 2");

        IOTdevice deviceById = iotDevice.getDeviceById(5L);
        System.out.println(deviceById);
        //=========================================creating===========================================================
        System.out.println("\nCreating iot Device is:::::::::::::");
        IOTdevice device = new IOTdevice(6L, "Modbus", "Pune", "Robotic");
        System.out.println(device);
        iotDevice.createDevice(device);
        System.out.println("\nList of person is::");

        for (IOTdevice iotdevice : iotDevice.getAllDevice())
            System.out.println(iotdevice);
        System.out.println("All List Printed");


//================================================delete==============================================================
        System.out.println("*/delete device with ID 4");
        iotDevice.deleteDevice(deviceById);

        for (IOTdevice iotdevice : iotDevice.getAllDevice())
            System.out.println(iotdevice);
        System.out.println("After Delete....All List Printed");

        //=======================================================================
        System.out.println("/Update device with ID 2");
        IOTdevice ddevice= iotDevice.getDeviceById(1L);
        ddevice.setDeviceName("IOT");
        //iotDevice.updateDevice(ddevice);
        ddevice.setDeviceFunction("Modbus");
        ddevice.setDeviceLocation("Sangamner");
        iotDevice.updateDevice(ddevice);


        for (IOTdevice iotdevice : iotDevice.getAllDevice())
            System.out.println(iotdevice);
        System.out.println("Updated List Printed");

        System.out.println("/Updated Device>>>>>>>>");

        //======================================================================================

        System.out.println("\n List of device is :");
        for (IOTdevice iotdevice:iotDevice.getAllDevice()){
            System.out.println(iotdevice);
        }
        context.close();
    }
}