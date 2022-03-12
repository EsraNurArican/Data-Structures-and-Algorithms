package CargoCompany;

import java.io.IOException;

/**
 * Administrator class represents one of the cargo company's user.
 * This is the subclass of CargoCompanyUsers.
 * Administrator can add/remove branch,branch employee and transportation employee to the system.
 */
public class Administrator extends CargoCompanyUsers {

    protected String[] branchArray;
    protected CargoCompanyUsers[] branchEmployeeArr;
    protected CargoCompanyUsers[] transportEmployeeArr;
    protected int numberBranch;
    protected int numberBranchEmp;
    protected int numberTranspEmp;

    /**
     * Constructor that takes two parameter name and id information
     * At first,sizes of the arrays which keeps branches, branch employees and transportation employees are 0
     * If administrator adds new branch or employee these sizes will increase
     * @param _name name information
     * @param _id id information
     */
    public Administrator(String _name,String _id){
        super(_name,_id);
        numberBranch=0;
        numberBranchEmp=0;
        numberTranspEmp=0;
    }

    /**
     * Getter for branch array's size
     * @return number of branches
     */
    public int getNumberBranch(){ return numberBranch;}
    /**
     * Getter for branch employees array's size
     * @return number of branch employees
     */
    public int getNumberBranchEmp(){return numberBranchEmp;}
    /**
     * Getter for transportation employees array's size
     * @return number of  transportation employees
     */
    public int getNumberTranspEmp(){return numberTranspEmp;}

    /**
     * Adds new branch to the system
     * @param branchName string name parameter for new branch
     */
    public void addBranch(String branchName){
        numberBranch++;                         //increase branch size
        String[] temp=branchArray;              //creating temp array
        branchArray=new String[numberBranch];   //creating branchArray for new size

        for(int i = 0; i<getNumberBranch()-1; ++i)  //copying array to the temp
            branchArray[i] = temp[i];

        branchArray[getNumberBranch()-1] = branchName;  //adding new element

    }

    /**
     * Deletes given branch from the system
     * @param branchName string name parameter for branch to be deleted
     * @throws IOException if administrator tries to remove a transportation personnel which is non-exist in the system
     */
    public void removeBranch(String branchName) throws IOException {
        int count=0;
        String[] temp = new String[getNumberBranch()];   //creating temp array
        //copying all content
        for (int i = 0, j = 0; i < getNumberBranch(); ++i) {
            if (!branchName.equals(branchArray[i])) {
                temp[j] = branchArray[i];
                ++j;
            }
            else if(branchName.equals(branchArray[i]))
                count++;
        }
        if (count==0)
            throw new IOException("This branch can not removed because it is not in the system!");

        --numberBranch; //Decrease branch size
        System.arraycopy(temp, 0, branchArray, 0, numberBranch);     //copying array
    }

    /**
     * Adds new branch employee to the system
     * @param emp new employee
     */
    public void addBranchEmployee(CargoCompanyUsers emp){
        numberBranchEmp++;                               //increase branch employee size
        CargoCompanyUsers[] temp=branchEmployeeArr;      //create temp array
        branchEmployeeArr=new CargoCompanyUsers[numberBranchEmp];   //creating branchEmp array for new size

        for(int i = 0; i<getNumberBranchEmp()-1; ++i)     //copying array to temp
            branchEmployeeArr[i] = temp[i];

        branchEmployeeArr[getNumberBranchEmp()-1] = emp;    //adding new branch employee to the array
    }

    /**
     *Deletes given branch employee from the system
     * @param emp branch employee to be deleted
     * @throws IOException if administrator tries to remove a branch employee which is non-exist in the system
     */
    public void removeBranchEmployee(CargoCompanyUsers emp) throws IOException{
        int count=0;
        CargoCompanyUsers[] temp= new CargoCompanyUsers[getNumberBranchEmp()];      //creating temp array
        //copying all content
        for (int i = 0,j = 0; i < getNumberBranchEmp(); ++i) {
            if( ! emp.equals(branchEmployeeArr[i]) ) {
                temp[j] = branchEmployeeArr[i];
                ++j;
            }
            else if(emp.equals(branchEmployeeArr[i]))
                count++;
        }
        if (count==0)
            throw new IOException("This branch employee can not removed because it is not in the system!");
        --numberBranchEmp;       //Decrease size
        System.arraycopy(temp, 0, branchEmployeeArr, 0, numberBranchEmp);      //copying array
    }

    /**
     * Adds new transportation employee to the system
     * @param emp new transportation employee to be added
     */
    public void addTransportationEmployee(CargoCompanyUsers emp){
        numberTranspEmp++;                              //increase branch employee size
        CargoCompanyUsers[] temp=transportEmployeeArr;  //create temp array
        transportEmployeeArr=new CargoCompanyUsers[numberTranspEmp];//creating branchEmp array for new size

        for(int i = 0; i<getNumberTranspEmp()-1; ++i)        //copying array to temp
            transportEmployeeArr[i] = temp[i];

        transportEmployeeArr[getNumberTranspEmp()-1] = emp;    //adding new branch employee to the array
    }

    /**
     * Deletes transportation employee from the system
     * @param emp transportation employee to be deleted
     * @throws IOException if administrator tries to remove a transportation personnel which is non-exist in the system
     */
    public void removeTransportationEmployee(CargoCompanyUsers emp) throws IOException{
        int count=0;
        CargoCompanyUsers[] temp= new CargoCompanyUsers[getNumberTranspEmp()];
        //copying all content
        for (int i = 0,j = 0; i < getNumberTranspEmp(); ++i) {
            if( ! emp.equals(transportEmployeeArr[i]) ) {
                temp[j] = transportEmployeeArr[i];
                ++j;
            }
            else if(emp.equals(transportEmployeeArr[i]))
                count++;
        }
        if (count==0)
            throw new IOException("This transportation personnel can not removed because it is not in the system!");

        --numberTranspEmp;  //Decrease size
        System.arraycopy(temp, 0, transportEmployeeArr, 0, numberTranspEmp);  //copying array
    }

    /**
     * Method for showing the branches in the system
     */
    public void showBranches(){
        System.out.printf("number of branches:%d\n",getNumberBranch());
        for(int i=0;i<numberBranch;i++){
            System.out.println(branchArray[i]);
        }
    }

    /**
     * Method for showing the branch employees in the system
     */
    public void showBrancEmp(){
        System.out.printf("number of branch employees:%d\n",getNumberBranchEmp());
        for(int i=0;i<getNumberBranchEmp();i++){
            System.out.println("Branch employee :"+(i+1)+"  "+branchEmployeeArr[i].getName()+" "+branchEmployeeArr[i].getId());
        }
    }
    /**
     * Method for showing the transportation employees in the system
     */
    public void showTranspEmp(){
        System.out.printf("number of transportation employees:%d\n",getNumberTranspEmp());
        for(int i=0;i<getNumberTranspEmp();i++){
            System.out.println("Transportation employee :"+(i+1)+"  "+transportEmployeeArr[i].toString());
        }
    }
}
