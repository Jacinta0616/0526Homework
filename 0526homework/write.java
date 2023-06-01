import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class write{
    public static void main(String argv[])throws IOException{
        System.out.println("請輸入成績檔檔名");
        System.out.println("->");

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String filename =br.readLine();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));

        String str = new String();
        int counter=0;

        do{
            counter++;

            System.out.println("請輸入學生姓名:");
            String name = br.readLine();

            System.out.println("請輸入英文分數:");
            str = br.readLine();
            short e = Short.parseShort(str);
            
            System.out.println("請輸入數學分數:");
            str = br.readLine();
            short m = Short.parseShort(str);

            System.out.println("請輸入Java分數:");
            str = br.readLine();
            short j = Short.parseShort(str);

            Student ss = new Student(name, e, m, j);

            os.write(ss);

            System.out.println("還要輸入其他資料嗎??(y/n)");
            str = br.readLine();
        }while (str.equalsIgnoreCase("Y"));

        os.flush();
        os.close();

        System.out.println("\n已寫入"+counter+" 筆學生資料至檔案 "+filename);
    } 
}