package xperiment.utils.enums;

public enum StringsUtils {

	EMPLOYEE("EMPLOYEE"),
	ADD_EMPLOYEE("Add Employee"),
	LIST_EMPLOYEE("Employee View"),
	MAIN_MENU("Employee Menu"),
	NAME("Name"),
	LASTNAME("Last Name"),
	BIRTHDAY("Birth Day"),
	SAVE("Save"),
	CLEAR("Clear"),
	REMOVE_EMPLOYEE("Remove Employee"),
	REMOVE("Remove"),
	MAIN_MENU_DEPARTMENT("Department Menu"),
	LIST_DEPARTMENT("Department View"), 
	DEPARTMENT("Department"),
	ADD_DEPARTMENT("Add Department")
	;
	
	private final String string;
	
	private StringsUtils(String string) { this.string = string; }
	
	public String getString() { return string; }
}
