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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Person;
import org.openmrs.PersonAddress;
import org.openmrs.PersonAttribute;
import org.openmrs.PersonAttributeType;
import org.openmrs.PersonName;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.ModuleMustStartException;
import org.openmrs.module.csvimporter.model.CsvImporterConfiguration;
import org.openmrs.module.csvimporter.model.CsvImporterMapping;
import org.openmrs.module.csvimporter.model.OpenMrsObjectCategory;
import org.openmrs.module.csvimporter.util.CsvUtil;
import org.openmrs.module.csvimporter.util.DateTimeUtil;
import org.openmrs.util.DatabaseUpdateException;
import org.openmrs.util.InputRequiredException;
import org.openmrs.util.OpenmrsUtil;

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

		CsvImporterService importerService = null;
		try {
			File propsFile = new File ("c:\\Application Data\\OpenMRS\\openmrs-runtime.properties");
			Properties props = new Properties ();
			OpenmrsUtil.loadProperties (props, propsFile);
			String url = (String) props.get ("connection.url");
			String username = (String) props.get ("connection.username");
			String password = (String) props.get ("connection.password");
			Context.startup (url, username, password, props);

	        importerService = new CsvImporterServiceImpl();
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
		
		// Initialize the service class
		CsvUtil csvUtil = new CsvUtil(filePath, separator, true);
		String[][] data = csvUtil.readData();
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
		map.add(new CsvImporterMapping(2, new Date(), user, null, null, configuration, "age", OpenMrsObjectCategory.PERSON, "age", null));
		map.add(new CsvImporterMapping(3, new Date(), user, null, null, configuration, "dob", OpenMrsObjectCategory.PERSON, "date_of_birth", null));
		map.add(new CsvImporterMapping(4, new Date(), user, null, null, configuration, "gender", OpenMrsObjectCategory.PERSON, "gender", null));
		map.add(new CsvImporterMapping(6, new Date(), user, null, null, configuration, "form_date", OpenMrsObjectCategory.PERSON, "date_created", null));
		// Person Names
		map.add(new CsvImporterMapping(0, new Date(), user, null, null, configuration, "first_name", OpenMrsObjectCategory.PERSON_NAME, "given_name", null));
		map.add(new CsvImporterMapping(1, new Date(), user, null, null, configuration, "surname", OpenMrsObjectCategory.PERSON_NAME, "family_name", null));
		// Person Address
		map.add(new CsvImporterMapping(7, new Date(), user, null, null, configuration, "address", OpenMrsObjectCategory.PERSON_ADDRESS, "address1", null));
		map.add(new CsvImporterMapping(7, new Date(), user, null, null, configuration, "city", OpenMrsObjectCategory.PERSON_ADDRESS, "city_village", null));
		map.add(new CsvImporterMapping(7, new Date(), user, null, null, configuration, "country", OpenMrsObjectCategory.PERSON_ADDRESS, "country", null));
		// Person attributes
		map.add(new CsvImporterMapping(7, new Date(), user, null, null, configuration, "phone1", OpenMrsObjectCategory.PERSON_ATTRIBUTE, "Primary Phone", null));
		map.add(new CsvImporterMapping(7, new Date(), user, null, null, configuration, "facility_name", OpenMrsObjectCategory.PERSON_ATTRIBUTE, "Location", null));
		map.add(new CsvImporterMapping(7, new Date(), user, null, null, configuration, "suspect", OpenMrsObjectCategory.PERSON_ATTRIBUTE, "Suspect/Non-Suspect", null));

// district_name,screener_id,user_id,nhls_id,tb_contact,hiv_positive,diabetes,sputum_collection_date,sputum_result_date,sputum_result,mdr,treatment_start_date,died,lost_followup,transferred,transfer_to,comments

		// Fetch all the mappings of the configuration
		Collection<CsvImporterMapping> mappings = configuration.getMappings();
		// Map each index in header to respective mapping column name
		Map<String, Integer> indices = new HashMap<String, Integer>();
		// Search for the index of each mapping in the header
		for (Iterator<CsvImporterMapping> iter = mappings.iterator(); iter.hasNext();)
		{
			CsvImporterMapping mapping = iter.next();
			int index = Arrays.binarySearch(header, mapping.getColumnName());
			indices.put(mapping.getColumnName(), index);
		}
		// Declare empty arrays to fill in
		Person[] people = new Person[data.length];
		PersonName[] names = new PersonName[data.length];
		PersonAddress[] addresses = new PersonAddress[data.length];
		List<CsvImporterMapping> definedAttributes = importerService.getCsvImporterMappingByObjectCategory(OpenMrsObjectCategory.PERSON_ATTRIBUTE);
		PersonAttributeType[] personAttributeTypes = new PersonAttributeType[definedAttributes.size()];
		for (int i = 0; i < definedAttributes.size(); i++) {
			personAttributeTypes[i] = Context.getPersonService().getPersonAttributeTypeByName(definedAttributes.get(i).getObjectName());
		}

		PersonAttribute[][] attributes = new PersonAttribute[data.length][definedAttributes.size()];
		// For each record, fill respective properties
		for (int i = 0; i < data.length; i++) {
			try {
				people[i].setGender(data[i][indices.get("gender")]);
	            people[i].setDateCreated(DateTimeUtil.getDateFromString(data[i][indices.get("date_created")], dateFormat));
	            people[i].setBirthdate(DateTimeUtil.getDateFromString(data[i][indices.get("date_of_birth")], dateFormat));
	            people[i].setCreator(user);
	            
	            names[i].setGivenName(data[i][indices.get("given_name")]);
	            names[i].setFamilyName(data[i][indices.get("family_name")]);
	            
	            addresses[i].setAddress1(data[i][indices.get("address1")]);
	            addresses[i].setCityVillage(data[i][indices.get("city_villate")]);
	            addresses[i].setCountry(data[i][indices.get("country")]);

	            for (int j = 0; j < definedAttributes.size(); j++) {
	            	attributes[i][j].setAttributeType(null);
	            }
            }
            catch (ParseException e) {
	            e.printStackTrace();
            }
		}
	}
}
