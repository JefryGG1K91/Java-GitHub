package xperiment.ui.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import xperiment.model.Deparment;
import xperiment.service.department.showalldepartment.ShowAllDepartmentService;
import xperiment.ui.builder.UiComponentBuilder;

@org.springframework.stereotype.Component
public class ShowAllDepartmentLayoutFactory implements UiComponentBuilder{

	private List<Deparment> list;
	private BeanItemContainer<Deparment> container;
	
	private class ShowAllDepartmentLayout extends VerticalLayout{

		private static final long serialVersionUID = 1L;
		private Grid departmentTable;

		public ShowAllDepartmentLayout load() {
			
			list = departmentService.getAllDepartment();
			return this;
		}

		public ShowAllDepartmentLayout init() {
			
			setMargin(true);
			container = new BeanItemContainer<Deparment>(Deparment.class, list);
			departmentTable = new Grid(container);
			departmentTable.setColumnOrder("departmentName","departmentLocation");
			departmentTable.removeColumn("id");
			departmentTable.setImmediate(true);
			
			return this;
		}

		public ShowAllDepartmentLayout layout() {

			addComponent(departmentTable);
			return this;
			
		}
		
	}
	
	@Autowired
	private ShowAllDepartmentService departmentService;
	
	public void refreshTable() {
		
		list = departmentService.getAllDepartment();
		container.removeAllItems();
		container.addAll(list);
		
	}

	public Component createComponent() {

		return new ShowAllDepartmentLayout().load().init().layout();
		
	}

}

