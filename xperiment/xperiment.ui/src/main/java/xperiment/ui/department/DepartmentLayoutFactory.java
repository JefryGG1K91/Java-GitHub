package xperiment.ui.department;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import xperiment.ui.main.XperimentMainUI;
import xperiment.utils.enums.StringsUtils;

@SpringView(name=DepartmentLayoutFactory.NAME,ui=XperimentMainUI.class)
public class DepartmentLayoutFactory   extends VerticalLayout implements View, SaveDepartmentListener{

	private static final long serialVersionUID = 1L;
	public static final String NAME = "adddepartment";
	private TabSheet tabSheet;
	
	@Autowired
	private AddDepartmentLayoutFactory addDepartmentLayoutFactory;
	@Autowired
	private ShowAllDepartmentLayoutFactory showAllDepartmentLayoutFactory;


	private void addLayout() {

		setMargin(true);

		tabSheet = new TabSheet();

		tabSheet.setWidth("100%");

		Component sheetMainMenu=addDepartmentLayoutFactory.createComponent(this);
		Component sheetShowAllDepartments=showAllDepartmentLayoutFactory.createComponent();
	
		tabSheet.addTab(sheetMainMenu, StringsUtils.MAIN_MENU_DEPARTMENT.getString());
		tabSheet.addTab(sheetShowAllDepartments, StringsUtils.LIST_DEPARTMENT.getString());

		addComponent(tabSheet);
	}
	
	@Override
	public void savedDepartment() {
		
		showAllDepartmentLayoutFactory.refreshTable();
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		removeAllComponents();
		addLayout();
		
	}
}
