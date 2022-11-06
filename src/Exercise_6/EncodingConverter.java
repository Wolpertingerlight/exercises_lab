package Exercise_6;

import java.io.*;
import java.net.URL;

public class EncodingConverter {
    public void Convertation(String inputData, String outputFile, String fromEncoding, String toEncoding) {
        try {
            File file = new File(inputData);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputData), fromEncoding));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), toEncoding));
                String string;
                while ((string = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(string);
                    bufferedWriter.flush();
                }
            }
            else {
                URL url = new URL(inputData);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), fromEncoding));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), toEncoding));
                String string;
                while ((string = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(string);
                    bufferedWriter.flush();
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
