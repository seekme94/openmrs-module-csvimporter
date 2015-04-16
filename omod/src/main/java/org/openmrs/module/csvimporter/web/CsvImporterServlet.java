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

package org.openmrs.module.csvimporter.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author owais.hussain@irdresearch.org
 *
 */
public class CsvImporterServlet extends HttpServlet
{
	private static final long	serialVersionUID	= 4017703416117969259L;

	/*
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init () throws ServletException
	{
		super.init ();
	}

	/*
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy ()
	{
		super.destroy ();
	}

	/*
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		super.doGet (req, resp);
	}

	/*
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		super.doPost (req, resp);
	}
}
