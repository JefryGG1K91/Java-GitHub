package xperiment.ui.employee;


import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import xperiment.model.employee.Employee;
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
		private TextField birthday;
		private BeanFieldGroup<Employee> beanField;
		private Employee employee;
		private SaveEmployeeListener employeeListener;
		
		public AddEmployeeLayout(SaveEmployeeListener employeeSavedListener) {
			this.employeeListener = employeeSavedListener;
		}
		
		public AddEmployeeLayout init() {
			
			beanField = new BeanFieldGroup<Employee>(Employee.class);
			this.employee = new Employee();
			
			name = new TextField(StringsUtils.NAME.getString());
			lastname =  new TextField(StringsUtils.LASTNAME.getString());
			birthday =  new TextField(StringsUtils.BIRTHDAY.getString());

			name.setNullRepresentation("");
			lastname.setNullRepresentation("");
			birthday.setNullRepresentation("");
			
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
			layout.addComponent(lastname, 1, 0);

			layout.addComponent(birthday, 0, 1);

			layout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 3);

			birthday.clear();

			return layout;
			
		}
		
		private void clearFields() {
			
			name.setValue(null);
			lastname.setValue(null);
			birthday.setValue(null);
			
		}
		
		private void save() {
			
			try {
				beanField.commit();
				Notification.show(NotificationMessages.SAVE_EMPLOYEE.getString(),
						NotificationMessages.SAVE_EMPLOYEE_MESSAGE.getString(),Type.ASSISTIVE_NOTIFICATION);
			} catch (CommitException e) {
				Notification.show(NotificationMessages.ERROR_SAVE_EMPLOYEE.getString(),
						NotificationMessages.ERROR_SAVE_EMPLOYEE_MESSAGE.getString(),Type.ERROR_MESSAGE);
				return;
			}finally {
				employeeService.save(employee);
				employeeListener.EmployeeSave();
				clearFields();
				Notification.show(NotificationMessages.SAVE_EMPLOYEE.getString(),
						NotificationMessages.SAVE_EMPLOYEE_MESSAGE.getString(),Type.ASSISTIVE_NOTIFICATION);
			
			}
			
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
	
	public Component createComponent(SaveEmployeeListener employeeSavedListener) {
		return new AddEmployeeLayout(employeeSavedListener).init().bind().layout();
	}

}
