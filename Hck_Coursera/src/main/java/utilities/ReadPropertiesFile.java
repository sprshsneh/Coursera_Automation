package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {
	
		Properties prop;
		String path = null;
		
		public ReadPropertiesFile(String path) {
			this.path=path;
			FileInputStream fis;
			try {
				fis = new FileInputStream(path);
				prop = new Properties();
				prop.load(fis);
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
		
		public String getUrl() {
			return prop.getProperty("url");
		}
		
		public String getBrowser() {
			return prop.getProperty("browser");
		}

}
