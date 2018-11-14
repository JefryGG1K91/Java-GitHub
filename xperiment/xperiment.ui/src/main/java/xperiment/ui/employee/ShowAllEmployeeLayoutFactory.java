package xperiment.ui.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import xperiment.model.employee.*;
import xperiment.service.employee.showallemployee.ShowAllEmployeeService;
import xperiment.ui.builder.UiComponentBuilder;

@org.springframework.stereotype.Component
public class ShowAllEmployeeLayoutFactory implements UiComponentBuilder {

	private List<xperiment.model.employee.Employee> list;
	private BeanItemContainer<Employee> container;
	
	private class ShowAllEmployeeLayout extends VerticalLayout{

		private Grid employeeTable;
		private static final long serialVersionUID = 1L;

		public ShowAllEmployeeLayout init() {

			setMargin(true);
			container = new BeanItemContainer<Employee>(Employee.class, list);
			employeeTable = new Grid(container);
			employeeTable.setColumnOrder("name","lastname","birthDay");
			employeeTable.removeColumn("id");
			employeeTable.setImmediate(true);
			
			return this;
		}

		public ShowAllEmployeeLayout layout() {
			
			addComponent(employeeTable);
			return this;
		
		}
		
		public ShowAllEmployeeLayout load() {
			list = showAllEmployeeService.getAllEmployee();
			return this;
		}
		
	}

	public void refreshTable() {
		list = showAllEmployeeService.getAllEmployee();
		container.removeAllItems();
		container.addAll(list);
	}
	
	@Autowired
	private ShowAllEmployeeService showAllEmployeeService;
	
	@Override
	public Component createComponent() {
		return new ShowAllEmployeeLayout().load().init().layout();
	}

}
