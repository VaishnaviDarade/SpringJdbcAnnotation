package org.Mahagan.dao;

import org.Mahagan.model.IOTDeviceMapper;
import org.Mahagan.model.IOTdevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
//in this class we are going to implement JDBCTemplate
@Component
public class IOTDeviceImpl implements IOTDevice {
    //created JdbcTemplate reference for updating deleting etc operations

    JdbcTemplate jdbcTemplate;  //HE below constatnt la execute kart    //fetching record    //below five are constants(SQL_FIND_DEVICE)
    private final String SQL_Find_Device = "select * from iotdevice where id= ?";
    //Deleting records
    private final String SQL_Delete_Device = "delete from iotdevice where id= ?";
    //Updating records from fields taken below
    private final String SQL_Update_Device = "update iotdevice set deviceName= ?,deviceLocation= ?, deviceFunction= ? where Id= ?";
    //Getting all records
    private final String SQL_Get_All_Device = "select * from iotdevice";
    //Inserting new values into iotdevice
    private final String SQL_Insert_Device = "insert into iotdevice(id,deviceName,deviceLocation,deviceFunction) values(?,?,?,?)";


    //create method of IOTDeviceImpl with dataSource parameter
    // @Autowired

    //public IOTDeviceImpl(DataSource dataSource) {
    //take above reference jdbcTemplate and create its objec
    // jdbcTemplate = new JdbcTemplate();
    @Autowired
    public IOTDeviceImpl( DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    /**
     * This is to execute logic of by id in database, and it will get the respective id records for user
     * @param id id
     * @return jdbc Template
     */

    public org.Mahagan.model.IOTdevice getDeviceById(Long id) {
        return jdbcTemplate.queryForObject(SQL_Find_Device, new Object[]{id}, new IOTDeviceMapper());

    }


//    public IOTdevice getDeviceById(Long id) {
//        return jdbcTemplate.queryForObject(SQL_Find_Device, new Object[]{id}, new IOTDeviceMapper());
//    }


//    public IOTdevice getDeviceById(int id) {
//        return null;
//    }

    /**
     * this is the method uaed to get all the devices from database
     * @return jdbc Template
     */

    public List<org.Mahagan.model.IOTdevice> getAllDevice() {
        return jdbcTemplate.query(SQL_Get_All_Device, new IOTDeviceMapper());
    }

    /**
     *
     * @param iotdevice
     * @return
     */
    public boolean deleteDevice(org.Mahagan.model.IOTdevice iotdevice) {
        return jdbcTemplate.update(SQL_Delete_Device, iotdevice.getId()) > 0;

    }

    /**
     * Update the records in existing fields
     *
     * @param  iotdevice ioTdevice
     * @return jdbcTemplate
     */
    public int updateDevice(IOTdevice iotdevice) {
        return jdbcTemplate.update(SQL_Update_Device, iotdevice.getDeviceName(),iotdevice.getDeviceFunction(),
                iotdevice.getDeviceLocation(),iotdevice.getId()) ;

    }

    /**
     * creating IOT device
     * @param iotdevice ioTDevice
     * @return jdbc Template
     */

    public boolean createDevice(IOTdevice iotdevice) {
        return jdbcTemplate.update(SQL_Insert_Device, iotdevice.getId(),iotdevice.getDeviceName(),
                iotdevice.getDeviceLocation(),iotdevice.getDeviceFunction()) > 0;
    }
}