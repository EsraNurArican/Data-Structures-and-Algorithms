package CargoCompany;

import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Main class includes static main method and CargoCompanyTest method
 */
public class Main {
    /**
     * Static method main calls the test function
     * @param args String argument type
     */
    public static void main(String[] args){
        System.out.println("at the main");
        CargoCompanyTest();
    }//end of main method

    /**
     * CargoCompanyTest method takes no parameter
     * It tests all methods for written cargo company system and shows the results
     * It tests all adding,removing employees,customers and shipments
     */
    public static void CargoCompanyTest(){
        try{
            System.out.println("************ADMINISTRATOR TEST**************");
            System.out.println("Creating admin to employ employees for the cargo company..");
            Administrator admin=new Administrator("Esra Nur Arıcan","123");
            System.out.println(admin.toString());
            System.out.println("Adding branches to the system..");
            admin.addBranch("branch1");
            admin.addBranch("branch2");
            admin.addBranch("branch3");
            admin.addBranch("branch4");
            System.out.println("Branches after adding:");
            admin.showBranches();
            System.out.println("Removing branch3 from branches..");
            admin.removeBranch("branch3");
            System.out.println("Branches after removing:");
            admin.showBranches();
            System.out.println("Adding branch employees..");
            BranchEmployee branchEmp1=new BranchEmployee("Ali Arıcan","211");
            BranchEmployee branchEmp2=new BranchEmployee("Ayse Yildiz","222");
            BranchEmployee branchEmp3=new BranchEmployee("Fatih Turp","233");
            admin.addBranchEmployee(branchEmp1);
            admin.addBranchEmployee(branchEmp2);
            admin.addBranchEmployee(branchEmp3);
            System.out.println("Branch employees after adding:");
            admin.showBrancEmp();
            System.out.println("Removing branchEmp2 from system..");
            admin.removeBranchEmployee(branchEmp2);
            System.out.println("Branch employees after removing:");
            admin.showBrancEmp();
            System.out.println("Adding transport employees..");
            TransportationPersonnel transpEmp1=new TransportationPersonnel("Merve Demir","311");
            TransportationPersonnel transpEmp2=new TransportationPersonnel("Ahmet Ay","322");
            TransportationPersonnel transpEmp3=new TransportationPersonnel("Veli Cınar","333");
            admin.addTransportationEmployee(transpEmp1);
            admin.addTransportationEmployee(transpEmp2);
            admin.addTransportationEmployee(transpEmp3);
            System.out.println("Transportation employees after adding:");
            admin.showTranspEmp();
            System.out.println("Removing transpEmp3 from system..");
            admin.removeTransportationEmployee(transpEmp3);
            System.out.println("Transportation employees after removing:");
            admin.showTranspEmp();

            System.out.println("\n**********BRANCH EMPLOYEE TEST**********");
            System.out.println("Adding customers to the branch...");
            Customer cust1=new Customer("John Gruber","10");
            Customer cust2=new Customer("Kevin Murray","20");
            Customer cust3=new Customer("David Stan","30");
            Customer cust4=new Customer("Elly Jensen","40");
            branchEmp1.addCustomer(cust1);
            branchEmp1.addCustomer(cust2);
            branchEmp1.addCustomer(cust3);
            branchEmp1.addCustomer(cust4);
            System.out.println("Customers at the branch after adding..");
            System.out.println(branchEmp1.toString());
            System.out.println("Removing customer 2 from the system..");
            branchEmp1.removeCustomer(cust2);
            System.out.println("Customers at the branch after removing..");
            System.out.println(branchEmp1.toString());
            Shipment package1=new Shipment("12345","Esra Gunduz","Tugce Ekin","null");
            Shipment package2=new Shipment("67890","Elif Soylu","Başak Deniz","null");
            Shipment package3=new Shipment("85236","Mert Demir","Mehmet Aydın","null");
            branchEmp1.enterShipment(package1);
            branchEmp1.enterShipment(package2);
            branchEmp1.enterShipment(package3);
            System.out.println("***Shipments after entering the branch..***");
            System.out.println(branchEmp1.showShipments());
            System.out.println("***Shipments after removing the package2 from the branch..***");
            branchEmp1.removeShipment(package2);
            System.out.println(branchEmp1.showShipments());

            System.out.println("**********TRANSPORTATION EMPLOYEE TEST**********");
            System.out.println("Transportation personnel deliveres the package2,updates its situation -which was leaved from branch-");
            transpEmp1.updateShipment(package2);
            System.out.println(package2.toString());

            System.out.println("\n**********CUSTOMER TEST**********");
            System.out.println("Customer's can enter the system by tracking number and see the shipment's information..");
            System.out.println("Hello Customer:"+cust1.getName()+" "+
                        "Package informations that you want to see: \n"+cust1.enterSystem("85236"));
            System.out.println("**************");
            System.out.println("Hello Customer: "+cust3.getName()+" "+
                      "Package informations that you want to see: \n"+cust3.enterSystem("67890"));
        }
        catch (IOException | InvalidParameterException e){
            System.out.print(e.getMessage());
            System.exit(1);
        }
    }//end of CargoCompanyTest method
}//end of class main
