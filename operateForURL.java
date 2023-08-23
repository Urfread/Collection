import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class operateForURL {
    private static final String FILE_PATH = "net\\source.txt";
    private static ArrayList<MyURL>arrForMyURL=new ArrayList<>();

    public static void Collect(){
        //收藏一个资源
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入描述：");
        String describe = scanner.nextLine();

        System.out.print("请输入URL：");
        String urlString = scanner.nextLine();

        MyURL url = new MyURL(describe, urlString);
        arrForMyURL.add(url);
    }
    public static int search(){
        //寻找一个资源
        if(arrForMyURL.isEmpty()){
            System.out.println("Error:资源为空！");
            System.exit(0);
        }
        int i=0;
        for(MyURL myurl:arrForMyURL){
            System.out.println(i+"."+myurl.describe);
        }
        System.out.println("请输入序号");
        Scanner sc=new Scanner(System.in);
        return sc.nextInt();
    }
    public static void openURL() {
        //打开一个资源
        int i=search();
        String urlString=arrForMyURL.get(i).getUrlString();
        try {

            URI uri = new URI(urlString);
            Desktop desktop = Desktop.getDesktop();

            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            } else {
                System.out.println("不支持在默认浏览器中打开链接。");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void delete(){
        //删除一个资源
        int i=search();
        arrForMyURL.remove(i);
    }
    public static void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(arrForMyURL);
            System.out.println("数据保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadDataFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            return ;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            arrForMyURL = (ArrayList<MyURL>) ois.readObject();
            if (!arrForMyURL.isEmpty())
                System.out.println("数据读取成功！");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
