package esse.Dijkalkulator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Properties;

public class CapacityConfigManager {

	Properties capacityTypesProp = new Properties();;
	Properties capacityObjectsProp = new Properties();
	String ctFileString;
	String coFileString;
	String defaultPath;
	InputStream ctInputStream = null;
	InputStream coInputStream = null;
	OutputStream ctOutputStream = null;
	OutputStream coOutputStream = null;
	Enumeration<String>  capacityTypeKeys;
	Enumeration<String> capacityKeys;
	
	   private static CapacityConfigManager instance = null;
	   private CapacityConfigManager() {
	      // No instantiation.
	   }
	   public static CapacityConfigManager getInstance() {
	      if(instance == null) {
	         instance = new CapacityConfigManager();
	      }
	      return instance;
	   }
	
	public Properties getCapacityTypesProp() {
		return capacityTypesProp;
	}

	public void setCapacityTypesProp(Properties capacityTypesProp) {
		this.capacityTypesProp = capacityTypesProp;
	}

	public Properties getCapacityObjectsProp() {
		return capacityObjectsProp;
	}

	public void setCapacityObjectsProp(Properties capacityObjectsProp) {
		this.capacityObjectsProp = capacityObjectsProp;
	}

	public String getCtFile() {
		return ctFileString;
	}

	public void setCtFile(String ctFile) {
		this.ctFileString = ctFile;
	}

	public String getCoFile() {
		return coFileString;
	}

	public void setCoFile(String coFile) {
		this.coFileString = coFile;
	}

	public String getDefaultPath() {
		return defaultPath;
	}

	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
	}

	public InputStream getCtInputStream() {
		return ctInputStream;
	}

	public void setCtInputStream(InputStream ctInputStream) {
		this.ctInputStream = ctInputStream;
	}

	public InputStream getCoInputStream() {
		return coInputStream;
	}

	public void setCoInputStream(InputStream coInputStream) {
		this.coInputStream = coInputStream;
	}

	public OutputStream getCtOutputStream() {
		return ctOutputStream;
	}

	public void setCtOutputStream(OutputStream ctOutputStream) {
		this.ctOutputStream = ctOutputStream;
	}

	public OutputStream getCoOutputStream() {
		return coOutputStream;
	}

	public void setCoOutputStream(OutputStream coOutputStream) {
		this.coOutputStream = coOutputStream;
	}

	public Enumeration<String> getCapacityTypeKeys() {
		return capacityTypeKeys;
	}

	public void setCapacityTypeKeys(Enumeration<String> capacityTypeKeys) {
		this.capacityTypeKeys = capacityTypeKeys;
	}

	public Enumeration<String> getCapacityKeys() {
		return capacityKeys;
	}

	public void setCapacityKeys(Enumeration<String> capacityKeys) {
		this.capacityKeys = capacityKeys;
	}

	//methods
	public void ReadCapacityTypes() throws FileNotFoundException, IOException{
		try {
			ctInputStream = new FileInputStream(ctFileString);
			capacityTypesProp.clear();
			capacityTypesProp.load(ctInputStream);
			
//			coInputStream = new FileInputStream(coFileString);
//			capacityObjectsProp.load(coInputStream);
		} 
		catch (FileNotFoundException e) {
			throw e;
		}
		catch (IOException e) {
			throw e;
		}
		finally {
			ctInputStream.close();
//			coInputStream.close();
		}
	} //ReadCapacityTypes()
	
	public void WriteCapacityTypes () throws IOException{
		try {
			ctOutputStream = new FileOutputStream(ctFileString);			
			capacityTypesProp.store(ctOutputStream, "");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
	}
	
}
