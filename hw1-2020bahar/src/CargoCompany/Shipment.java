package CargoCompany;

/**
 * Shipment class represents cargo package
 * It has data fields such as sender,receiver and tracking number
 */
public class Shipment {

    private String trackingNumber;
    private String sender;
    private String receiver;
    private String status;

    /**
     * Constructor with 4 parameters
     * @param trcNo tracking number value
     * @param send sender information
     * @param rec receiver information
     * @param stat status of the shipment
     */
    public Shipment(String trcNo,String send,String rec,String stat){
        trackingNumber=trcNo;
        sender=send;
        receiver=rec;
        status=stat;
    }

    /**
     * Returns the shipment's tracking number
     * @return trackingNumber of the shipment
     */
    public String getTrackingNumber() { return trackingNumber; }

    /**
     * Returns the shipment's sender's name
     * @return sender of the shipment
     */
    public String getSender() { return sender; }
    /**
     * Returns the shipment's receiver's name
     * @return receiver of the shipment
     */
    public String getReceiver() { return receiver; }

    /**
     * Returns the shipment's current status
     * @return status of the shipment
     */
    public String getStatus() { return status; }

    /**
     * Sets the tracking number
     * @param newNum new tracking number
     */
    public void setTrackingNumber(String newNum){ this.trackingNumber=newNum;}

    /**
     * Sets the sender information
     * @param newSender new sender information
     */
    public void setSender(String newSender){ this.sender=newSender;}

    /**
     * Sets the receiver information
     * @param newReceiver new receiver information
     */
    public void setReceiver(String newReceiver) { this.receiver = newReceiver; }

    /**
     * Sets the status information of the shipment
     * @param newStatus new status information
     */
    public void setStatus(String newStatus) { this.status = newStatus; }

    /**
     * Overriden toString method for representing shipment's information
     * @return string shipment information
     */
    @Override
    public String toString(){
        String shipmentInfo="";
        shipmentInfo+="Tracking number of the package: "+getTrackingNumber()+"\n"
                    +"Sender information of the package: "+getSender()+"\n"
                    +"Receiver infırmation of the package: "+getReceiver()+"\n"
                    +"Current status of the package: "+getStatus();
        return shipmentInfo;
    }

}
