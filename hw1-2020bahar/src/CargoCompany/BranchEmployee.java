package CargoCompany;

import java.io.IOException;

/**
 * BranchEmployee class represents one of the cargo company's user.
 * This is the subclass of CargoCompanyUsers.
 * BranchEmployee can add/remove shipment and user to the system
 */
public class BranchEmployee extends CargoCompanyUsers {
    protected CargoCompanyUsers[] customerArr;
    protected int customerSize=0;
    /**
     * Constructor that takes two parameter
     *
     * @param _name for name
     * @param _id   for id
     */
    public BranchEmployee(String _name, String _id) {
        super(_name, _id);
        shipmentArr=null;
        customerArr=null;
    }
    /**
     * Returns the customer arrays size
     * @return customer size
     */
    public int getCustomerSize() { return customerSize; }
    /**
     * Return the customer array,which stores the customers in the branch
     * @return customer array
     */
    public CargoCompanyUsers[] getCustomerArr() { return customerArr; }

    /**
     * Enters shipment to the branch
     * Updates the shipment's situation as in the branch
     * @param ship to be added shipment
     */
    public void enterShipment(Shipment ship){
        ship.setStatus("Entered the branch");
        shipmentSize++;
        Shipment[] temp=shipmentArr;
        shipmentArr=new Shipment[shipmentSize];

        for(int i = 0; i<getShipmentSize()-1; ++i)
            shipmentArr[i] = temp[i];

        shipmentArr[getShipmentSize()-1] = ship;
    }

    /**
     * Removes the shipment from the branch.
     * If shipment doesn't reached to receiver yet,
     * updates the shipment's situation as leaved the branch.
     * If shipment reached to receiver,deletes the package from the system.
     * @param ship removing shipment
     * @throws IOException if branch employee tries to remove a shipment which is non-exist in the system
     */
    public void removeShipment(Shipment ship)  throws IOException{
        int count=0;
        for(int i=0;i<shipmentSize;i++){
            if(ship.equals(shipmentArr[i]))
                count++;
        }
        if(ship.getStatus()!="Reached to the receiver.")
            ship.setStatus("Leaved the branch");
        else if(ship.getStatus()!="Reached to the receiver.") {
            Shipment[] temp = new Shipment[getShipmentSize()];
            //copying all content
            for (int i = 0, j = 0; i < getShipmentSize(); ++i) {
                if (!ship.equals(shipmentArr[i])) {
                    temp[j] = shipmentArr[i];
                    ++j;
                }
            }

            //Decrease size
            --shipmentSize;
            //copying array
            System.arraycopy(temp, 0, shipmentArr, 0, shipmentSize);
        }
        if (0 == count)
            throw new IOException("This shipment can not removed because it is not in the system!");
    }

    /**
     * Adds customer to the system
     * @param newCustomer to be added as customer
     */
    public void addCustomer(CargoCompanyUsers newCustomer){
        customerSize++;
        CargoCompanyUsers[] temp=customerArr;
        customerArr=new CargoCompanyUsers[getCustomerSize()];

        for(int i = 0; i<getCustomerSize()-1; ++i)
            customerArr[i] = temp[i];

        customerArr[getCustomerSize()-1] = newCustomer;
    }

    /**
     * Removes customer from the system
     * @param customer to be removed from system
     * @throws IOException if branch employee tries to remove a customer which is non-exist in the system
     */
    public void removeCustomer(CargoCompanyUsers customer) throws IOException {
        int count=0;
        CargoCompanyUsers[] temp= new CargoCompanyUsers[getCustomerSize()];
        //copying all content
        for (int i = 0,j = 0; i < getCustomerSize(); ++i) {
            if( ! customer.equals(customerArr[i]) ) {
                temp[j] = customerArr[i];
                ++j;
            }
            else if(customer.equals(customerArr[i]))
                count++;
        }
        if (count==0)
            throw new IOException("This customer can not removed because it is not in the system!");

        --customerSize;      //Decrease size
        System.arraycopy(temp, 0, customerArr, 0, customerSize);     //copying array
    }

    /**
     * Overriden method to show customer's information as name and id.
     * Calls super class's toString method with some changes
     * @return string user information
     */
    @Override
    public String toString (){
        String info="";
            for(int i=0;i<getCustomerSize();i++)
                info+="Customer :"+(i+1)+"  "+customerArr[i].toString()+"\n";
        return info;
    }

    public String showShipments(){
        String ships="";
        for(int i=0;i<getShipmentSize();i++){
            ships += "-----Shipment number " + (i + 1) + "-----\n "
                    + shipmentArr[i].toString()+"\n";
        }
        return ships;
    }
}
