import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class ManagerCRUD {
    private final String PATH = "C:\\Users\\ASUS\\Desktop\\Máy tính\\Thi_cuoi_module2\\fileData.csv";
    public List<Students> listStudents;

    public ManagerCRUD() {
        listStudents = new ArrayList<>();
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Mã sinh viên: ");
        String id = scanner.nextLine();
        System.out.println("Tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.println("Tuổi : ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Điểm trung bình: ");
        double mediumScore = Double.parseDouble(scanner.nextLine());
        listStudents.add(new Students(id, name, age, gender, address, mediumScore));
    }

    public void updateStudent(Scanner scanner) {
        System.out.println("Nhập id học viên cần sửa:");
        String id = scanner.nextLine();
        int index = checkId(id);
        if (index != -1) {
            System.out.println("*Mã học viên: " + listStudents.get(index).getId());
            checkUpdateInformation(scanner, index, 6);
            System.out.println("1.Tên: " + listStudents.get(index).getName());
            checkUpdateInformation(scanner, index, 1);
            System.out.println("2.Tuổi: " + listStudents.get(index).getAge());
            checkUpdateInformation(scanner, index, 2);
            System.out.println("3.Giới tính: " + listStudents.get(index).getGender());
            checkUpdateInformation(scanner, index, 3);
            System.out.println("4.Địa chỉ: " + listStudents.get(index).getAddress());
            checkUpdateInformation(scanner, index, 4);
            System.out.println("5.Điểm trung bình: " + listStudents.get(index).getMediumScore());
            checkUpdateInformation(scanner, index, 5);
        } else {
            System.out.println("Không tìm được sinh viên với mã sinh viên trên");
        }
    }

    public void deleteStudent(Scanner scanner) {
        System.out.println("Nhập id học viên cần xóa:");
        String id = scanner.nextLine();
        int index = checkId(id);
        if (index != -1) {
            System.out.println("*Mã học viên: " + listStudents.get(index).getId());
            System.out.println("1.Tên: " + listStudents.get(index).getName());
            System.out.println("2.Tuổi: " + listStudents.get(index).getAge());
            System.out.println("3.Giới tính: " + listStudents.get(index).getGender());
            System.out.println("4.Địa chỉ: " + listStudents.get(index).getAddress());
            System.out.println("5.Điểm trung bình: " + listStudents.get(index).getMediumScore());
            System.out.println("Bạn có muốn xóa không?<Nhập Y để xóa>");
            String choice = toUpperCase(scanner.nextLine());
            if (choice.equals("Y")) {
                listStudents.remove(index);
            }
        } else {
            System.out.println("Không tìm được sinh viên với mã sinh viên trên");
        }
    }

    private void checkUpdateInformation(Scanner scanner, int index, int choice) {
        String text = scanner.nextLine();
        if (!Objects.equals(text, "")) {
            switch (choice) {
                case 1:
                    listStudents.get(index).setName(text);
                    break;
                case 2:
                    try {
                        int num = Integer.parseInt(text);
                        listStudents.get(index).setAge(num);
                        break;
                    } catch (Exception e) {
                        System.out.println("Nhập sai kiểu dữ liệu!!");
                    }
                    break;
                case 3:
                    listStudents.get(index).setGender(text);
                    break;
                case 4:
                    listStudents.get(index).setAddress(text);
                    break;
                case 5:
                    try {
                        int num = Integer.parseInt(text);
                        listStudents.get(index).setMediumScore(num);
                        break;
                    } catch (Exception e) {
                        System.out.println("Nhập sai kiểu dữ liệu!!");
                    }
                    break;
                case 6:
                    listStudents.get(index).setId(text);
                    break;
            }
        }
    }

    public void display(Scanner scanner) {
        if (listStudents.size() == 0) {
            System.out.println("Hiện tại không có sinh viên nào trong danh sách");
        } else {
            for (Students student : listStudents) {
                String confirm = scanner.nextLine();
                if (confirm.equals("")) {
                    System.out.println(student);
                }
            }
        }
    }

    private int checkId(String id) {
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudents.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void readFile() {
        List<Students> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                String id = arr[0];
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                double mediumScore = Double.parseDouble((arr[5]));
                Students student = new Students(id, name, age, gender, address, mediumScore);
                list.add(student);
                str = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listStudents = list;
    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Students student : listStudents) {
                bufferedWriter.write(student.displayCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sortAz(){
        if (listStudents.size()==0){
            System.out.println("Hiện tại không có sinh viên nào trong danh sách");
        }else {
            CollectionSortAZ sortAZ = new CollectionSortAZ();
            listStudents.sort(sortAZ);
            for (Students student : listStudents){
                System.out.println(student);
            }
        }

    }
    public void sortZa(){
        if (listStudents.size()==0){
            System.out.println("Hiện tại không có sinh viên nào trong danh sách");
        }else {
            CollectionSortZA sortZA = new CollectionSortZA();
            listStudents.sort(sortZA);
            for (Students student : listStudents){
                System.out.println(student);
            }
        }
    }
}
