package xperiment.utils.enums;

public enum NotificationMessages {
	
	SAVE_EMPLOYEE("Save Employee"),
	SAVE_EMPLOYEE_MESSAGE("Employee saved succesfully"),
	ERROR_SAVE_EMPLOYEE("Error Saving Employee"),
	ERROR_SAVE_EMPLOYEE_MESSAGE("Employee Has not been saved"),
	REMOVE_EMPLOYEE("Remove Employee"),
	REMOVE_EMPLOYEE_DESCRIPTON("Employee have been removed succesfully"), 
	SAVE_DEPARTMENT("Save Department"),
	SAVE_DEPARTMENT_MESSAGE("Department saved succesfully"), 
	ERROR_SAVE_DEPARTMENT("Error Saving Department"),
	ERROR_SAVE_DEPARTMENT_MESSAGE("Department Has not been saved")
	;
	
	
	private final String string;
	
	private NotificationMessages(String string) { this.string = string; }
	
	public String getString() { return string; }
	
	
	
}
