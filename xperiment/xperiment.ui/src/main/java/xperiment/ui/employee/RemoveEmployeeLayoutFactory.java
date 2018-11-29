package xperiment.ui.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.MultiSelectionModel;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import xperiment.model.Employee;
import xperiment.service.employee.showallemployee.ShowAllEmployeeService;
import xperiment.services.employee.removedemployee.RemovedEmployeeServices;
import xperiment.ui.main.XperimentMainUI;
import xperiment.utils.enums.NotificationMessages;
import xperiment.utils.enums.StringsUtils;

@SpringView(name=RemoveEmployeeLayoutFactory.NAME,ui = XperimentMainUI.class)
public class RemoveEmployeeLayoutFactory extends  VerticalLayout implements View, Button.ClickListener{

	private static final long serialVersionUID = 1L;
	public static final String NAME= "removeemployee";
	private Grid removeEmployeeTable;
	private Button removeButton;
	private List<Employee> employeeList;
	@Autowired
	private ShowAllEmployeeService showAllEmployeeService;
	@Autowired
	private RemovedEmployeeServices removedEmployeeService;

	public void addLayout() {
		
		removeButton = new Button(StringsUtils.REMOVE.getString());
		
		setMargin(true);
		
		BeanItemContainer<Employee> container = new BeanItemContainer<Employee>(Employee.class,employeeList);
		
		removeEmployeeTable = new Grid(container);
		removeEmployeeTable.setColumnOrder("name","lastname","birthDay");
		removeEmployeeTable.removeColumn("id");
		removeEmployeeTable.setImmediate(true);
		removeEmployeeTable.setSelectionMode(SelectionMode.MULTI);
		
		removeButton.addClickListener(this);
		removeButton.setStyleName(ValoTheme.BUTTON_DANGER);
		
		addComponent(removeEmployeeTable);
		addComponent(removeButton);
	}
	
	private void loadEmployee() {
		
		employeeList = showAllEmployeeService.getAllEmployee();
	
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		if( removeEmployeeTable != null ) return;
		loadEmployee();
		addLayout();
	}

	@Override
	public void buttonClick(ClickEvent event) {
		
		MultiSelectionModel selectionMode = (MultiSelectionModel) removeEmployeeTable.getSelectionModel();
		
		for (Object selectedItem : selectionMode.getSelectedRows()) {
		
			Employee employeeTemp = (Employee)selectedItem;
			removeEmployeeTable.getContainerDataSource().removeItem(employeeTemp);
			removedEmployeeService.removeEmployee(employeeTemp);
		}
		
		Notification.show(NotificationMessages.REMOVE_EMPLOYEE.getString(),
				NotificationMessages.REMOVE_EMPLOYEE_DESCRIPTON.getString(), Type.WARNING_MESSAGE);
		
		removeEmployeeTable.getSelectionModel().reset();
		
	}

}
