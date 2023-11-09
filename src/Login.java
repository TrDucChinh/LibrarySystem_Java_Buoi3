import java.util.Scanner;

public class Login {
    public Login(){
        System.out.print("Enter username: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();

        if (userName.equals(Admin.getAdminUserName())) {
            System.out.print("Enter password: ");
            String passWord = sc.nextLine();
            if (passWord.equals(Admin.getAdminPassWord())) {
                System.out.println("Đăng nhập thành công!");

                Admin admin = new Admin();
                admin.adminActions(sc);
            } else {
                do{
                    System.out.print("Vui lòng nhập lại Password: ");
                    passWord = sc.nextLine();
                } while (!passWord.equals(Admin.getAdminPassWord()));
                Admin admin = new Admin();
                admin.adminActions(sc);
            }
        } else if (userName.equals(Guest.getGuestUserName())) {
            Guest guest = new Guest();
            guest.guestActions(sc);
        }
    }

}