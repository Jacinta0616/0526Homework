import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class read{
    public static void main(String argv[]) throws IOException, ClassNotFoundException{

        System.out.println("要讀取的學生資料檔名:");
        System.out.println("->");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename=br.readLine();
        int counter=0;
        double Esum=0;
        double Msum=0;
        double Jsum=0;
        Student ss=new Student();

        System.out.println("姓名\t英文\t數學\tJava\t平均");
        System.out.println("__________________________________");

        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename))){
            while (true){
                ss=(Student) ois.read();
                counter++;

                Esum+= ss.getE();
                Msum+= ss.getM();
                Jsum+= ss.getJ();

                System.out.println(ss.getN()+'\t'+ss.getE()+'\t'+ss.getM()+'\t'+ss.getJ()+'\t'+ss.getAvg());
            }
        }
        catch (EOFException e){
            System.out.println("\n已從檔案"+filename+"讀取"+counter+" 筆學生資料");
            System.out.println("\n全員英文平均"+(Esum/counter));
            System.out.println("全員數學平均"+(Msum/counter));
            System.out.println("全員Java平均"+(Jsum/counter));
        }

    }
}