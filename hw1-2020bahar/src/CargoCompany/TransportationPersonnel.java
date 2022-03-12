package CargoCompany;

/**
 * Transportation employee class represents one of the cargo company's user.
 * This is the subclass of CargoCompanyUsers.
 * Transportation employee can update the package's status.
 */
public class TransportationPersonnel extends CargoCompanyUsers {

    /**
     * Constructor that takes two parameter
     *
     * @param _name for name
     * @param _id   for id
     */
    public TransportationPersonnel(String _name, String _id) {
        super(_name, _id);
    }

    /**
     * Void method that updates the shipment's situation.
     * When package arrives,transportation employee updates it's status as received.
     * @param ship shipment object as parameter
     */
    public void updateShipment(Shipment ship){
        for(int i=0;i<getShipmentSize();i++){
            if(ship.equals(shipmentArr[i]))
                ship.setStatus("Reached to the receiver.");
        }
    }
}
