package com.visitek.xyzproject.porting;

import java.awt.Image;
import java.util.Collection;

import org.jboss.seam.excel.ExcelFactory;
import org.jboss.seam.excel.ExcelWorkbook;

import com.visitek.xyzproject.model.entity.Contact;
import com.visitek.xyzproject.model.entity.Project;
import com.visitek.xyzproject.model.entity.Task;

public class ExcelReporter {
	private static final String DEFAULT_XLS_REPORT_FILENAME = "#{ProjectName} Report.xls";
	private static ExcelWorkbook xlsWB;
	private static Project curProject;
	private static String outputFilename = DEFAULT_XLS_REPORT_FILENAME;

	static {
		xlsWB = ExcelFactory.instance().getExcelWorkbook("jxl");
	}

	public ExcelReporter(Project project, String outputFile) {
		curProject = project;
		outputFilename = outputFile;
	}

	public void generateProjectSheet(Project pr) {

	}

	public void generateTaskSheet(Collection<Task> tasks) {

	}

	public void putImage(Image img) {

	}

	public void writeContacts(Collection<Contact> conts) {

	}

	public void writeTask(Task t) {

	}

}
