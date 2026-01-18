public class Teacher extends Member{

    //Constructor
    public Teacher(String id, String name){
        super(id, name);
    }

    //Methods
    @Override
    public String getMemberType() {
        return "Teacher";
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

}
