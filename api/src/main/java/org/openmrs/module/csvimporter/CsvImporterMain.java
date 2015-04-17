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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.csvimporter.model.CsvImporterMapping;
import org.openmrs.module.csvimporter.util.CsvUtil;

/**
 * @author owais.hussain@irdresearch.org
 */
public class CsvImporterMain {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	static String filePath = "C:\\Users\\Owais\\Documents\\dumps\\MINE-TB Clean data.csv";
	static char separator = ',';
	static String dateFormat = "yyyy-MM-dd";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Initialize the service class
		CsvUtil csvUtil = new CsvUtil(filePath, separator, true);
		String[][] readData = csvUtil.readData();
		String[] header = csvUtil.getHeader();
		List<CsvImporterMapping> map = new ArrayList<CsvImporterMapping>();
		// form_date, time_stamp, district_name, facility_name, screener_id, user_id, nhls_id,
		// address, phone1, tb_contact, hiv_positive, diabetes, sputum_collection_date, sputum_result_date, sputum_result, 
		// mdr, treatment_start_date, died,lost_followup,transferred,transfer_to,comments

		// PERSON ATTRIBUTES
//		map.add(new MapObject("first_name", OpenMRSObjectType.PERSON_ATTRIBUTE, "given_name"));
//		map.add(new MapObject("surname", OpenMRSObjectType.PERSON_ATTRIBUTE, "family_name"));
//		map.add(new MapObject("age", OpenMRSObjectType.PERSON_ATTRIBUTE, "age"));
//		map.add(new MapObject("dob", OpenMRSObjectType.PERSON_ATTRIBUTE, "dob"));
//		map.add(new MapObject("gender", OpenMRSObjectType.PERSON_ATTRIBUTE, "gender"));


	}
	
}
