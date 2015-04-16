/* Copyright(C) 2014 Interactive Health Solutions, Pvt. Ltd.

This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as
published by the Free Software Foundation; either version 3 of the License (GPLv3), or any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program; if not, write to the Interactive Health Solutions, info@ihsinformatics.com
You can also access the license on the internet at the address: http://www.gnu.org/licenses/gpl-3.0.html

Interactive Health Solutions, hereby disclaims all copyright interest in this program written by the contributors. */
/**
 * 
 */

package org.openmrs.module.csvimporter.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.jfree.util.Log;

/**
 * @author owais.hussain@irdresearch.org
 */
public final class PropertiesUtil {
	
	public static Properties props;
	
	private String filePath;
	
	/**
     * 
     */
	public PropertiesUtil(String filePath) {
		this.setFilePath(filePath);
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * Read properties from properties file
	 */
	public void readProperties() {
		props = new Properties();
		if (new File(filePath).exists()) {
			try {
				props.load(new FileInputStream(filePath));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Write properties to properties file and reads back
	 */
	public boolean writeProperties(Map<String, String> properties) {
		boolean success = false;
		if (properties.isEmpty()) {
			System.out.println("No properties to write to file.");
		}
		Set<Entry<String, String>> entrySet = properties.entrySet();
		for (Iterator<Entry<String, String>> iter = entrySet.iterator(); iter.hasNext();) {
			Entry<String, String> pair = iter.next();
			props.setProperty(pair.getKey(), pair.getValue());
		}
		try {
			// Check for directory and permissions
			//			if (!(new File(FileConstants.XPERT_SMS_DIR).exists())) {
			//				boolean checkDir = new File(FileConstants.XPERT_SMS_DIR).mkdir();
			//				if (!checkDir) {
			//					JOptionPane.showMessageDialog(null,
			//					    "Could not create properties file. Please check the permissions of your home folder.", "Error!",
			//					    JOptionPane.ERROR_MESSAGE);
			//				}
			//			}
			props.store(new FileOutputStream(getFilePath()), null);
			props.load(new FileInputStream(getFilePath()));
			success = true;
		}
		catch (IOException ioe) {
			Log.error("Exception while writing properties file.", ioe);
		}
		return success;
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
}
