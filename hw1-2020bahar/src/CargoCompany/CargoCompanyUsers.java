package CargoCompany;

/**
 * CargoCompanyUsers is a super class for representing the cargo company's users.
 * It has basic fields that every user has,such as name and id.
 */
public class CargoCompanyUsers {

    private String name;
    private String id;
    /*Both transportation personnel and branch employee
     *can update the shipment's situation,so shipment placed in the super class*/
    static Shipment[] shipmentArr;
    static int shipmentSize=0;

    /**
     * Constructor that takes two parameter
     * @param _name  for name
     * @param _id for id
     */
    public CargoCompanyUsers(String _name,String _id){
        name=_name;
        id=_id;
    }

    /**
     * Returns the shipment array,which is stores the shipments in the branch
     * @return shipment array
     */
    public Shipment[] getShipmentArr() { return shipmentArr; }

    /**
     * Returns the shipment arrays size
     * @return shipment size
     */
    public int getShipmentSize() { return shipmentSize; }


    /**
     * getName method to show user's name
     * @return user's name
     */
    protected String getName(){ return name; }

    /**
     * getId method to show user's id
     * @return user's id
     */
    protected  String getId(){ return id; }

    /**
     * void setName method sets user's name
     * @param newName new name information
     */
    protected  void setName(String newName){ name=newName;}

    /**
     * void setId method sets user's id
     * @param newId new id information
     */
    protected  void setId(String newId){ id=newId;}

    /**
     * Overriden toString method for printing user's name and id information
     * @return string user information
     */
    @Override
    public String toString(){
        String userInformation="";
        userInformation+="Name of the user: "+getName()+"  "
                        +"Id of the admin: "+getId();
        return userInformation;
    }

}
