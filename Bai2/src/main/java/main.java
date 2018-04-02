import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			Document doc =Jsoup.connect("http://dantri.com.vn").get();
			String fileName=calendar.getTime().toString().replaceAll(":", " ")+".txt";
			System.out.println(fileName);
			File file =new File(fileName);
			file.createNewFile();
			fw=new FileWriter(file);
			bw=new BufferedWriter(fw);
			StringBuilder stringBuilder=new StringBuilder(doc.head()+""+doc.body());
			fw.write(stringBuilder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Done");
			}
		}
	}

}
