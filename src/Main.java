import Array.Array;
import Connection.Post;
import javafx.geometry.Pos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            Post post = new Post();
            System.out.println("Введіть довжину массиву");
            Integer num = System.in.read();
            Array array = new Array(num);
            Integer[] arr = array.AddArray();
            for (Integer i = 0; i< arr.length; i++){
                System.out.println(arr[i]);
            }

            String connstr = "http://localhost:3030";
            String str= "";
            for (int i=0; i<arr.length; i++){
                str =  new StringBuilder(str).append(arr[i].toString()).append(arr[i].toString()).toString();
            }
            String connresp = Post.Send(connstr, str);
            System.out.println(connresp);

            System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
