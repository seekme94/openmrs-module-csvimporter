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
 *
 */
public interface CsvImporterDAO {
	
	public CsvImporterConfiguration createConfiguration(CsvImporterConfiguration configuration) throws DAOException;
	
	public CsvImporterConfiguration updateConfiguration(CsvImporterConfiguration configuration) throws DAOException;

	public void deleteConfiguration(CsvImporterConfiguration configuration) throws DAOException;

	public CsvImporterConfiguration getConfigurationById(Integer id) throws DAOException;
	
	public CsvImporterConfiguration getConfigurationByName(String name) throws DAOException;
	
	public List<CsvImporterConfiguration> getAllConfigurations() throws DAOException;

	public CsvImporterMapping createMapping(CsvImporterMapping mapping) throws DAOException;

	public List<CsvImporterMapping> createMappings(List<CsvImporterMapping> mapping) throws DAOException;
	
	public CsvImporterMapping updateMapping(CsvImporterMapping mapping) throws DAOException;

	public void deleteMapping(CsvImporterMapping mapping) throws DAOException;

}
