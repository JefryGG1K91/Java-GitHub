package xperiment.ui.employee;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import xperiment.ui.main.XperimentMainUI;
import xperiment.utils.enums.StringsUtils;

@SpringView(name=EmployeeLayoutFactory.NAME,ui=XperimentMainUI.class)
public class EmployeeLayoutFactory extends VerticalLayout implements View, SaveEmployeeListener{

	private static final long serialVersionUID = 1L;
	public static final String NAME = "addemployee";
	private TabSheet tabSheet;
	@Autowired
	private AddEmployeeLayoutFactory addEmployeeLayoutFactory;
	
	@Autowired
	private ShowAllEmployeeLayoutFactory showAllEmployeeLayoutFactory;

	@Override
	public void enter(ViewChangeEvent event) {

		removeAllComponents();
		addLayout();

	}

	private void addLayout() {

		setMargin(true);

		tabSheet = new TabSheet();

		tabSheet.setWidth("100%");

		Component sheetMainMenu=addEmployeeLayoutFactory.createComponent(this);
		Component sheetShowAllEmployee=showAllEmployeeLayoutFactory.createComponent();
		
		tabSheet.addTab(sheetMainMenu, StringsUtils.MAIN_MENU.getString());
		tabSheet.addTab(sheetShowAllEmployee, StringsUtils.LIST_EMPLOYEE.getString());

		addComponent(tabSheet);
	}

	@Override
	public void EmployeeSave() {
	
		showAllEmployeeLayoutFactory.refreshTable();
		
	}


}
