package CargoCompany;

import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Customer class represents one of the cargo company's user.
 * This is the subclass of CargoCompanyUsers.
 * Customer can see package's informations such as sender,receiver and status.
 */
public class Customer extends CargoCompanyUsers {
    /**
     * Constructor that takes two parameter
     *
     * @param _name for name
     * @param _id   for id
     */
    public Customer(String _name, String _id) {
        super(_name, _id);
    }

    /**
     * Method for showing package information
     * User can enter the system with tracking number of the package
     * @param trackNo tracking number of the package to enter the system
     * @return shipment information as string
     */
    public String enterSystem(String trackNo) throws InvalidParameterException {
        int count=0;
        String shipmentInfo="";
        for(int i=0;i<getShipmentSize();i++){
            if(shipmentArr[i].getTrackingNumber()==trackNo) {
               return shipmentArr[i].toString();
            }
            if(trackNo.equals(shipmentArr[i])) {
                count++;
            }
        }
        if(count==0)
            throw new InvalidParameterException("Invalid tracking number!!!");
        return shipmentInfo;
    }
}
