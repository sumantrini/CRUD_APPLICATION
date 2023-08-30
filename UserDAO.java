package CRUD_APPLICATION;

    public interface UserDAO {
    
        int insertUser(User u);
        int updateUser(User u);
        int deleteUser(String aadhar);
        String[] getAadhar();
        User fillFields(String users);
}
