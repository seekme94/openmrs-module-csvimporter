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

/**
 * This class is used to define metadata, i.e. map CSV headers to OpenMRS objects
 * 
 * @author owais.hussain@irdresearch.org
 */
public class MapObject {
	
	private String columnName;
	
	private OpenMRSObjectType objectType;
	
	private String objectName;
	
	public MapObject() {
		this.columnName = "";
		this.objectType = OpenMRSObjectType.PERSON_ATTRIBUTE;
		this.objectName = "";
	}
	
	public MapObject(String columnName, OpenMRSObjectType objectType, String objectName) {
		this.columnName = columnName;
		this.objectType = objectType;
		this.objectName = objectName;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public OpenMRSObjectType getObjectType() {
		return objectType;
	}
	
	public void setObjectType(OpenMRSObjectType objectType) {
		this.objectType = objectType;
	}
	
	public String getObjectName() {
		return objectName;
	}
	
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
}
