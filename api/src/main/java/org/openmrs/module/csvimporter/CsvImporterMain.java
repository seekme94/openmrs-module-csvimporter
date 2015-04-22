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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.PersonAddress;
import org.openmrs.PersonName;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.ModuleMustStartException;
import org.openmrs.module.csvimporter.model.CsvImporterConfiguration;
import org.openmrs.module.csvimporter.model.CsvImporterMapping;
import org.openmrs.module.csvimporter.util.CsvUtil;
import org.openmrs.util.DatabaseUpdateException;
import org.openmrs.util.InputRequiredException;

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

		try {
			Properties props = new Properties();
			props.load(new FileReader("c:\\Application Data\\OpenMRS\\openmrs-runtime.properties"));
	        Context.startup(props);
        }
        catch (ModuleMustStartException e) {
	        e.printStackTrace();
        }
        catch (DatabaseUpdateException e) {
	        e.printStackTrace();
        }
        catch (InputRequiredException e) {
	        e.printStackTrace();
        }
        catch (FileNotFoundException e) {
	        e.printStackTrace();
        }
        catch (IOException e) {
	        e.printStackTrace();
        }
		
		// Initialize the service class
		CsvUtil csvUtil = new CsvUtil(filePath, separator, true);
		String[][] readData = csvUtil.readData();
		String[] header = csvUtil.getHeader();
		
		CsvImporterConfiguration configuration = new CsvImporterConfiguration();
		configuration.setConfigName("MINE-TB import");
		configuration.setConfigDescription("MINE-TB legacy data import");
		User user = Context.getUserService().getUserByUsername("owais");
		configuration.setCreator(user);
		configuration.setCsvHeader("form_date,time_stamp,district_name,facility_name,screener_id,user_id,nhls_id,first_name,surname,dob,age,gender,address,phone1,tb_contact,hiv_positive,diabetes,sputum_collection_date,sputum_result_date,sputum_result,mdr,treatment_start_date,died,lost_followup,transferred,transfer_to,comments");
		configuration.setDateCreated(new Date());
		configuration.setDateFormat(dateFormat);
		configuration.setFieldSeparator(separator);
		configuration.setId(0);
		configuration.setLineSeparator('\n');
		configuration.setTimeFormat("");
		configuration.setUuid(UUID.randomUUID().toString());

		List<CsvImporterMapping> map = new ArrayList<CsvImporterMapping>();
		// Person
		map.add(new CsvImporterMapping(0, new Date(), user, null, null, configuration, "first_name", "person", "given_name", null));
		map.add(new CsvImporterMapping(1, new Date(), user, null, null, configuration, "surname", "person", "surname", null));
		map.add(new CsvImporterMapping(2, new Date(), user, null, null, configuration, "age", "person", "age", null));
		map.add(new CsvImporterMapping(3, new Date(), user, null, null, configuration, "dob", "person", "date_of_birth", null));
		map.add(new CsvImporterMapping(4, new Date(), user, null, null, configuration, "gender", "person", "gender", null));
		map.add(new CsvImporterMapping(5, new Date(), user, null, null, configuration, "gender", "person", "gender", null));
		map.add(new CsvImporterMapping(6, new Date(), user, null, null, configuration, "form_date", "person", "date_created", null));
		// Person attributes
		map.add(new CsvImporterMapping(7, new Date(), user, null, null, configuration, "phone1", "person_attribute", "Primary Phone", null));
		map.add(new CsvImporterMapping(7, new Date(), user, null, null, configuration, "location", "person_attribute", "Location", null));

		
// time_stamp,district_name,facility_name,screener_id,user_id,nhls_id,address,phone1,tb_contact,hiv_positive,diabetes,sputum_collection_date,sputum_result_date,sputum_result,mdr,treatment_start_date,died,lost_followup,transferred,transfer_to,comments

		Date birthdate = null;
		Boolean birthdateEstimated = false;
		Date dateCreated = null;
		String gender = null;
		Set<PersonAddress> addresses = new HashSet<PersonAddress>();
		addresses.add(new PersonAddress());
		Set<PersonName> names = new HashSet<PersonName>();
		names.add(new PersonName());
		
		Person person = new Person();
		person.setBirthdate(birthdate);
		person.setAddresses(addresses);
		person.setBirthdateEstimated(birthdateEstimated);
		person.setCreator(user);
		person.setDateCreated(dateCreated);
		person.setGender(gender);
		person.setNames(names);
		person.setPersonCreator(user);
		person.setPersonDateCreated(dateCreated);
	}
	
}
