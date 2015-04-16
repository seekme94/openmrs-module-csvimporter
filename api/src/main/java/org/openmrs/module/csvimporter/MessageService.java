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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * @author owais.hussain@irdresearch.org
 */
@SuppressWarnings("rawtypes")
@Service
public class MessageService implements ApplicationListener {
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 
	 */
	public MessageService() {
	}
	
	/**
	 * @return the messageSource
	 */
	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	/**
	 * @param messageSource the messageSource to set
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	/**
	 * @param messageName
	 */
	public String getMessage(String messageName, Object[] objectArgs) {
		return getMessageSource().getMessage(messageName, objectArgs, "Message for " + messageName + "not found", null);
	}
	
	/**
	 * @param event
	 */
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.getSource() + " has generated an event on " + event.getTimestamp());
	}
}
