import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        operateForURL.loadDataFromFile();
        while(true){
            menu();
        }

    }
    public static void menu(){
        System.out.println("****************");
        System.out.println("*1.收藏一个资源");
        System.out.println("*2.浏览一个资源");
        System.out.println("*3.删除一个资源");
        System.out.println("*0.退出       ");
        System.out.println("****************");

        int n=getOption();
        switch (n) {
            case 1:
                // 处理收藏资源的逻辑
                operateForURL.Collect();
                break;
            case 2:
                // 处理浏览资源的逻辑
                operateForURL.openURL();
                break;
            case 3:
                // 处理删除资源的逻辑
                operateForURL.delete();
                break;
            case 0:
                operateForURL.saveDataToFile();
                System.exit(0);
            default:
                System.out.println("请重新输入");
        }
    }
    public static int getOption(){
        System.out.printf("请选择:");
        Scanner sc=new Scanner(System.in);
        return sc.nextInt();
    }
}
