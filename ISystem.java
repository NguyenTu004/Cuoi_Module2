
import java.util.Scanner;

public class ISystem {
    private ManagerCRUD managerCRUD = new ManagerCRUD();
    public ISystem() {
    }

    public void SystemStudent(Scanner scanner){
        int choice=0;
        do {
            System.out.println("____ CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ____");
            System.out.println("1.Xem danh sách sinh viên ");
            System.out.println("2.Thêm mới sinh viên ");
            System.out.println("3.Cập nhập sinh viên ");
            System.out.println("4.Xóa sinh viên ");
            System.out.println("5.Sắp xếp sinh viên ");
            System.out.println("6.Đọc file ");
            System.out.println("7.Ghi file ");
            System.out.println("8.Thoát ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >=1 && choice <=8){
                    switch (choice){
                        case 1: managerCRUD.display(scanner);break;
                        case 2: managerCRUD.addStudent(scanner);break;
                        case 3: managerCRUD.updateStudent(scanner);break;
                        case 4: managerCRUD.deleteStudent(scanner);break;
                        case 5: menuSort(scanner);break;
                        case 6: managerCRUD.readFile();break;
                        case 7: managerCRUD.writeFile();break;
                    }
                }else {
                    System.out.println("Chọn từ 1 đến 8");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai kiểu dữ liệu");
            }

        }while (choice!=8);
    }
    private void menuSort(Scanner scanner){
        int choice =0 ;
        do {
            System.out.println("____Sắp Xếp Sinh Viên Theo Điểm Trung Bình____");
            System.out.println("1.Sắp xếp tăng dần ");
            System.out.println("2.Sắp xếp giảm dần ");
            System.out.println("0.Thoát ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice ==1){
                    managerCRUD.sortAz();
                }else if (choice ==2){
                    managerCRUD.sortZa();
                }else {
                    System.out.println("Chọn từ 0 đến 2!");
                }
            } catch (NumberFormatException e){
                System.out.println("Nhập sai kiểu dữ liệu");
            }
        }while (choice!=0);
    }

}
