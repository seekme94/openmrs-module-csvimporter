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

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.csvimporter.model.CsvImporterConfiguration;
import org.openmrs.module.csvimporter.model.CsvImporterMapping;

/**
 * @author owais.hussain@irdresearch.org
 */
public interface CsvImporterService extends OpenmrsService {
	
	/**
	 * Get module service by name
	 * 
	 * @param name
	 * @return
	 */
	public CsvImporterService getMyModuleByName(String name);
	
	/**
	 * Create new or update an existing configuration
	 * 
	 * @param configuration
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterConfiguration saveConfiguration(CsvImporterConfiguration configuration) throws DAOException;
	
	/**
	 * Delete existing configuration
	 * 
	 * @param configuration
	 * @throws DAOException
	 */
	public void deleteConfiguration(CsvImporterConfiguration configuration) throws DAOException;
	
	/**
	 * Get configuration by integer config Id
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterConfiguration getConfigurationById(Integer id) throws DAOException;
	
	/**
	 * Get configuration by unique name
	 * 
	 * @param name
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterConfiguration getConfigurationByName(String name) throws DAOException;
	
	/**
	 * Get a list of existing configurations
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<CsvImporterConfiguration> getAllConfigurations() throws DAOException;
	
	/**
	 * Create new or update existing mapping
	 * 
	 * @param mapping
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterMapping saveMapping(CsvImporterMapping mapping) throws DAOException;
	
	/**
	 * Bulk save or update mappings
	 * 
	 * @param mapping
	 * @return
	 * @throws DAOException
	 */
	public List<CsvImporterMapping> saveMappings(List<CsvImporterMapping> mappings) throws DAOException;
	
	/**
	 * Delete existing mapping
	 * 
	 * @param mapping
	 * @throws DAOException
	 */
	public void deleteMapping(CsvImporterMapping mapping) throws DAOException;
}
