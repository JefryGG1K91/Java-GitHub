package xperiment.ui.employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import xperiment.model.department.Deparment;
import xperiment.model.employee.Employee;
import xperiment.service.department.showalldepartment.ShowAllDepartmentService;
import xperiment.service.employee.addemployee.AddEmployeeService;
import xperiment.utils.enums.NotificationMessages;
import xperiment.utils.enums.StringsUtils;

@org.springframework.stereotype.Component
public class AddEmployeeLayoutFactory {

	private class AddEmployeeLayout extends VerticalLayout implements Button.ClickListener{

		private static final long serialVersionUID = 1L;
		private Button saveButton;
		private Button clearButton;
		private TextField name;
		private TextField lastname;
		private TextField birthDay;
		private ComboBox department;
		private BeanFieldGroup<Employee> beanField;
		private Employee employee;
		private SaveEmployeeListener employeeListener;

		public AddEmployeeLayout(SaveEmployeeListener employeeSavedListener) {
			this.employeeListener = employeeSavedListener;
			this.employee = new Employee();
		}

		public AddEmployeeLayout load() {

			List<Deparment> departmentList = departmentService.getAllDepartment();
			department.addItems(departmentList);
			return this;
		}

		public AddEmployeeLayout init() {

			beanField = new BeanFieldGroup<Employee>(Employee.class);

			name = new TextField(StringsUtils.NAME.getString());
			lastname =  new TextField(StringsUtils.LASTNAME.getString());
			birthDay =  new TextField(StringsUtils.BIRTHDAY.getString());
			department = new ComboBox(StringsUtils.DEPARTMENT.getString());

			name.setNullRepresentation("");
			lastname.setNullRepresentation("");
			birthDay.setNullRepresentation("");

			saveButton = new Button(StringsUtils.SAVE.getString());
			clearButton = new Button(StringsUtils.CLEAR.getString());

			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

			saveButton.addClickListener(this);
			clearButton.addClickListener(this);

			return this;
		}

		public AddEmployeeLayout bind() {

			beanField.bindMemberFields(this);
			beanField.setItemDataSource(employee);
			return this;

		}

		public Component layout() {

			setMargin(true);

			GridLayout layout = new GridLayout(2, 4);
			layout.setSizeUndefined();
			layout.setSpacing(true);

			layout.addComponent(name, 0, 0);
			layout.addComponent(birthDay, 0, 1);

			layout.addComponent(lastname, 1, 0);
			layout.addComponent(department, 1, 1);

			layout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 3);

			return layout;

		}

		private void clearFields() {

			name.setValue(null);
			lastname.setValue(null);
			birthDay.setValue(null);
			department.setValue(null);

		}

		private void save() {

			if( !isSaveOperationValid() ) {

				Notification.show(NotificationMessages.EMPLOYEE_SAVE_INVALID_TITLE.getString(), 
						NotificationMessages.EMPLOYEE_SAVE_INVALID_DESCRIPTION.getString(), Type.ERROR_MESSAGE);			

				return;
			}else {
				
				savedEmployee();
				
			}

		}
		
		private void savedEmployee() {
			try {
				
				beanField.commit();
				
			} catch (CommitException e) {
				Notification.show(NotificationMessages.ERROR_SAVE_EMPLOYEE.getString(),
						NotificationMessages.ERROR_SAVE_EMPLOYEE_MESSAGE.getString(),Type.ERROR_MESSAGE);
				return;
			}
				employeeService.save(employee);
				employeeListener.EmployeeSave();
				Notification.show(NotificationMessages.SAVE_EMPLOYEE.getString(),
						NotificationMessages.SAVE_EMPLOYEE_MESSAGE.getString(),Type.ASSISTIVE_NOTIFICATION);

				clearFields();
			
		}

		private boolean isSaveOperationValid() {
			return departmentService.getAllDepartment().size() != 0;
		}

		@Override
		public void buttonClick(ClickEvent event) {

			if (event.getSource()==this.saveButton) {
				save();
			} else {
				clearFields();
			}

		}

	}

	@Autowired
	private AddEmployeeService employeeService;

	@Autowired
	private ShowAllDepartmentService departmentService;

	public Component createComponent(SaveEmployeeListener employeeSavedListener) {
		return new AddEmployeeLayout(employeeSavedListener).init().load().bind().layout();
	}

}
