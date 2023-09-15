package com.lmsproject.components;

import java.util.Properties;

import com.lmsproject.utility.CommonUtils;
import com.lmsproject.utility.ExcelFileReader;



public class ExcelDataInputReader {
	public static String programName;
	public static String programDesc;
	public static String programStatus;
	public static String batchName;
	public static String batchDesc;
	public static String Noofclasses;
	public static String classDate;
	public static String classTopic;
	public static String staffId;
	public static String classDesc;
	public static String notes;
	public static String recording;
	public static String batchStatus;
	public static String Comments;
	public static String Assignmentname;
    public static String gradeby;
    public static String Assignmentduedate;
    public static String AssignmentDescription;
    public static String AssignmentFile1;
    public static String AssignmentFile2;
    public static String AssignmentFile3;
    public static String AssignmentFile4;
    public static String AssignmentFile5;
    public static String classname;
	public static String studentname;
    






	public static String getAttendancename() {
		return Attendancename;
	}
	public static String Attendanceduedate;
    public static String Attendancename;
	static Properties properties = new Properties();
	static String excelURLFile = CommonUtils.getexcelfilepath(); 
	
	
	public static void loadProperties()  {
		
		//FileReader reader= null;
	ExcelFileReader excel = null;
		
		String excelURL = excelURLFile;
		String path=System.getProperty("user.dir");
		excel= new ExcelFileReader(path+excelURL,"LMS-PROJECT");
		
		
		
		
		programName =excel.getCellDataString(1, 0); 
		programDesc = excel.getCellDataString(1, 1); 
		programStatus = excel.getCellDataString(1, 2); 
		batchName =  excel.getCellDataString2(1, 3);
		batchDesc = excel.getCellDataString(1, 4); 
		Noofclasses =  excel.getCellDataString2(1, 5); 
		classDate = excel.getCellDataString2(1, 6); 
		classTopic = excel.getCellDataString(1, 7); 
		staffId = excel.getCellDataString2(1, 8); 
		classDesc = excel.getCellDataString(1, 9);
		notes = excel.getCellDataString(1, 10);
		recording = excel.getCellDataString(1, 11);
		batchStatus = excel.getCellDataString(1, 12);
		Comments = excel.getCellDataString(1, 13);
		Assignmentname=excel.getCellDataString2(1, 14);
        gradeby =excel.getCellDataString(1, 15);
        Assignmentduedate=excel.getCellDataString2(1, 16);
        AssignmentDescription=excel.getCellDataString(1, 17);
        AssignmentFile1 =excel.getCellDataString(1,18);
        AssignmentFile2 =excel.getCellDataString(1,19);
        AssignmentFile3 =excel.getCellDataString(1,20);
        AssignmentFile4 =excel.getCellDataString(1,21);
        AssignmentFile5 =excel.getCellDataString(1,22);
        classname=excel.getCellDataString(1, 23);
        studentname=excel.getCellDataString(1,24);
}
	
	
	
	
	
	
	public static String getProgramName() {
		return programName;
	}
	
	public static String getProgramDesc() {
		return programDesc;
	}
	
	public static String getProgramStatus() {
		return programStatus;
	}
	
	public static String getBatchName() {
		return batchName;
	}
	
	public static String getBatchDesc() {
		return batchDesc;
	}
	
	public static String getNoofclasses() {
		return Noofclasses;
	}
	
	public static String getClassDate() {
		return classDate;
	}
	
	public static String getClassTopic() {
		return classTopic;
	}
	
	public static String getStaffId() {
		return staffId;
	}
	
	public static String getClassDesc() {
		return classDesc;
	}
	
	public static String getNotes() {
		return notes;
	}
	
	public static String getRecording() {
		return recording;
	}
	
	public static String getBatchStatus() {
		return batchStatus;
	}
	
	 public static String getAssignmentname() {
	        return Assignmentname;
	    }
	    
	    public static String getGradeby() {
	        return gradeby;
	    }
	    
	    public static String getAssignmentduedate() {
	        return Assignmentduedate;
	    }
	    
	    public static String getAssignmentDescription() {
	        return AssignmentDescription;
	    }
	    
	    public static String getAssignmentFile1() {
	        return AssignmentFile1;
	    }
	    
	    public static String getAssignmentFile2() {
	        return AssignmentFile2;
	    }
	    
	    public static String getAssignmentFile3() {
	        return AssignmentFile3;
	    }
	    
	    public static String getAssignmentFile4() {
	        return AssignmentFile4;
	    }
	    
	    public static String getAssignmentFile5() {
	        return AssignmentFile5;
	    }
	    public static String getComments() {
			return Comments;

}
	    public static String getClassname() {
			return classname;
		}
	    public static String getStudentname() {
			return studentname;
		}

		public static String getAttendanceduedate() {
			return Attendanceduedate;
		}
}
