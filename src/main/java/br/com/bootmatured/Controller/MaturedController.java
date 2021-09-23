package br.com.bootmatured.Controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value ="/")
public class MaturedController {
	
	@GetMapping(value="/")
	public String inicio(){
		try {
			System.out.println("Entrou no looping");
			cURL();
			System.out.println("Saiu do looping");
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		System.out.println("saiu do try");
		return "index.html";
	}
	
	public void cURL() throws InterruptedException {
//		BufferedReader reader;
		 
        try {
//            URL url = new URL("http://localhost:3000/sendText?number=" + cliente.getNumeroCelular()+"&message=olaEdner");
// 
//            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
////            System.out.println(reader.read);
//            for (String line; (line = reader.readLine()) != null; ) {
//                System.out.println(line);
//            }
// 
//            reader.close();

		//78048989463956D51D93B911DA93CEEB
		
        	for(int i = 0; i < 20; i++) {
        		URL url;
        		HttpURLConnection http;
        		
				url = new URL("http://localhost:5000/sendTextGrups?number=5511972100922-1620070555" + "&messages=ola" + LocalDateTime.now());
				http = (HttpURLConnection)url.openConnection();
	            http.setRequestProperty("Content-Type", "application/json");
	            http.setRequestProperty("Accept", "application/json");
	
	            System.out.println(http.getResponseCode() + " " + http.getResponseMessage() + i);
	            http.disconnect();
				
        		Thread.currentThread();
				Thread.sleep(63000);
        	}
        } catch (Exception ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
