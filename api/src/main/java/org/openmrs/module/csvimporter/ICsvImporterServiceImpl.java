/**
 * Copyright(C) 2015 Interactive Health Solutions, Pvt. Ltd.
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 3 of the License (GPLv3), or any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program; if not, write to the Interactive Health Solutions, info@ihsinformatics.com
 * You can also access the license on the internet at the address: http://www.gnu.org/licenses/gpl-3.0.html
 * Interactive Health Solutions, hereby disclaims all copyright interest in this program written by the contributors.
 * Contributors: Owais
 */
package org.openmrs.module.csvimporter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.common.util.ContentStreamBase.FileStream;
import org.openmrs.module.csvimporter.util.CsvUtil;
import org.openmrs.module.csvimporter.util.FileUtil;

/**
 * @author owais.hussain@irdresearch.org
 */
public class ICsvImporterServiceImpl implements ICsvImporterService {
	
	public static final String MODULE_NAME = "org.openmrs.csvimporter";
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * Returns module by its qualified name
	 */
	public ICsvImporterService getMyModuleByName(String name) {
		if (name.equals(MODULE_NAME))
			return this;
		return null;
	}
	
	/**
	 * @throws IOException
	 */
	public boolean importDataFile(String filePath) {
		CsvUtil csvUtil = new CsvUtil(filePath, ',', true);
		String[][] readData = csvUtil.readData();
		String[] header = csvUtil.getHeader();
		Map<String, String> map = new HashMap<String, String>();
		
		
		map.put(header[1], "");
		return false;
	}

	/**
	 * 
	 */
	public boolean importMetadataFile(String filePath) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 
	 */
	public boolean createMapping(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}
}
