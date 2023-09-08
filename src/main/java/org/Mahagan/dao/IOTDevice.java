package org.Mahagan.dao;

import java.util.List;

public interface IOTDevice {
    org.Mahagan.model.IOTdevice getDeviceById(Long id);
    List<org.Mahagan.model.IOTdevice> getAllDevice();
    boolean deleteDevice(org.Mahagan.model.IOTdevice ioTdevice);
    int updateDevice(org.Mahagan.model.IOTdevice ioTdevice);
    boolean createDevice(org.Mahagan.model.IOTdevice ioTdevice);
}