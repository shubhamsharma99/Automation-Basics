//package
//Reusable
package Reusable;

import java.io.FileInputStream;

import java.util.Properties;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class PropertyReader {
	private Properties prop = null;
	private FileInputStream inputStream = null;
	private static PropertyReader obj = null;

	/**
	 * return obj.
	 * 
	 * @return obj obj
	 */
	public final PropertyReader getInstance() {
		if (obj == null) {
			obj = new PropertyReader();
		}
		return obj;
	}

	/**
	 * return path.
	 * 
	 * @param Path
	 *            Path
	 */
	public final void loadProperties(final String Path) {

		try {
			inputStream = new FileInputStream(Path);
			prop = new Properties();
			prop.load(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

	/**
	 * the propertyname.
	 * 
	 * @param propertyName
	 *            propertyName
	 * @return the return
	 */
	public final String getProperty(final String propertyName) {

		return prop.getProperty(propertyName);
	}

	/**
	 * the path.
	 * 
	 * @param path
	 *            path
	 * @param propertyName
	 *            the propertyname
	 * @return the return
	 */
	public final String getProperty(final String path, final String propertyName) {
		loadProperties(path);
		return prop.getProperty(propertyName).toString();
	}
}
