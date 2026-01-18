public class Student extends Member{

    //Constructor
    public Student(String id, String name){
        super(id, name);
    }

    //Methods
    @Override
    public String getMemberType() {
        return "Student";
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

}
