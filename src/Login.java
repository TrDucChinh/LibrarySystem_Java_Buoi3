import java.util.Scanner;

public class Login {
    public Login(){
        System.out.print("Enter username: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();

        if (userName.equals(Admin.getADMIN_USERNAME())) {
            System.out.print("Enter password: ");
            String passWord = sc.nextLine();
            if (passWord.equals(Admin.getADMIN_PASSWORD())) {
                System.out.println("Đăng nhập thành công!");

                Admin admin = new Admin();
                admin.adminActions(sc);
            }
        } else if (userName.equals(Guest.getGuestUsername())) {
            Guest guest = new Guest();
            guest.guestActions(sc);
        }
    }

}