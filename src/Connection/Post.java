package Connection;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Post{

    public Post(){

    }

    public static String Send(String target, String urlParameters){
        try {
            URL url = new URL(target);
            System.out.println(url);
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println(conn);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            conn.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            conn.setRequestProperty("Content-Language", "en-US");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream (
                    conn.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                System.out.println(is);
                // do something with the data here
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
                String line;
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                System.out.println(response);
               return  conn.getResponseMessage();
            } else {
                InputStream err = conn.getErrorStream();
                // err may have useful information.. but could be null see javadocs for more information
                BufferedReader rd = new BufferedReader(new InputStreamReader(err));
                StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
                String line;
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                System.out.println(response);
                return  conn.getResponseMessage();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
        return null;
    }
    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
//            InputStream is = connection.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
//            String line;
//            while ((line = rd.readLine()) != null) {
//                response.append(line);
//                response.append('\r');
//            }
//            rd.close();
            //return response.toString();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
