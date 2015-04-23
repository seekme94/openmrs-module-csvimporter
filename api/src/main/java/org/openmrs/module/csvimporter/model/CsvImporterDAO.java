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
package org.openmrs.module.csvimporter.model;

import java.util.List;

import org.openmrs.api.db.DAOException;

/**
 * @author owais.hussain@irdresearch.org
 */
public interface CsvImporterDAO {
	
	/**
	 * Save a new configuration object in database
	 * 
	 * @param configuration
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterConfiguration createConfiguration(CsvImporterConfiguration configuration) throws DAOException;
	
	/**
	 * Update an existing configuration in database
	 * 
	 * @param configuration
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterConfiguration updateConfiguration(CsvImporterConfiguration configuration) throws DAOException;
	
	/**
	 * Delete an existing configuration from database
	 * 
	 * @param configuration
	 * @throws DAOException
	 */
	public void deleteConfiguration(CsvImporterConfiguration configuration) throws DAOException;
	
	/**
	 * Get configuration by unique numeric ID
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterConfiguration getConfigurationById(Integer id) throws DAOException;
	
	/**
	 * Get configuration by matching exact name
	 * 
	 * @param name
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterConfiguration getConfigurationByName(String name) throws DAOException;
	
	/**
	 * Get all configurations in the database
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<CsvImporterConfiguration> getAllConfigurations() throws DAOException;
	
	/**
	 * Save new mapping in the database
	 * 
	 * @param mapping
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterMapping createMapping(CsvImporterMapping mapping) throws DAOException;
	
	/**
	 * Update existing mapping object in the database
	 * 
	 * @param mapping
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterMapping updateMapping(CsvImporterMapping mapping) throws DAOException;
	
	/**
	 * Delete an existing mapping object from the database
	 * 
	 * @param mapping
	 * @throws DAOException
	 */
	public void deleteMapping(CsvImporterMapping mapping) throws DAOException;
	
	/**
	 * Get mapping object from unique numeric ID
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterMapping getCsvImporterMappingById(Integer id) throws DAOException;
	
	/**
	 * Get mapping by unique column name defined in the original CSV header
	 * 
	 * @param name
	 * @return
	 * @throws DAOException
	 */
	public CsvImporterMapping getCsvImporterMappingByColumnName(String name) throws DAOException;
	
	/**
	 * Get all mappings of an OpenMRS object category
	 * 
	 * @param objectCategory
	 * @return
	 * @throws DAOException
	 */
	public List<CsvImporterMapping> getCsvImporterMappingByObjectCategory(String objectCategory) throws DAOException;
	
	/**
	 * Get all mappings of an OpenMRS object name
	 * 
	 * @param objectName
	 * @return
	 * @throws DAOException
	 */
	public List<CsvImporterMapping> getCsvImporterMappingByObjectName(String objectName) throws DAOException;
}
