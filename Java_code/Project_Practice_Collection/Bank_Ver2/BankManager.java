package Project_Practice_Collection.Bank_Ver2;

public class BankManager {
    
    private static String path = "C:\\AI\\javaEx\\Normal\\BankSystem";
    private static String fileName = "\\Bank_information.txt";

    public static String getPath() {
        return path;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setPath(String newPath) {
        if (newPath != null && !newPath.isBlank()) {
            System.out.println("경로가 변경되었습니다");
            System.out.println("새 경로 : " + newPath);
            path = newPath;
        } else {
            System.out.println("유효하지 않은 경로입니다");
        }
    }
    public static void setFileName(String newFileName) {
        if (newFileName != null && !newFileName.isBlank()) {
            System.out.println("경로가 변경되었습니다");
            System.out.println("새 경로 : " + newFileName);
            path = newFileName;
        } else {
            System.out.println("유효하지 않은 경로입니다");
        }
    }

    
}
