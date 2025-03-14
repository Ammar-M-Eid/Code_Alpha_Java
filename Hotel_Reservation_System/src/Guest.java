
public class Guest {

    private static int guestIdCounter = 1;

    private String name;
    private String email;
    private String phone;

    public Guest(int id, String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public static int generateGuestId() {
        return guestIdCounter++;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
