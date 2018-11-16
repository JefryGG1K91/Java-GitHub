package xperiment.ui.department;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;
import xperiment.model.department.Deparment;
import xperiment.service.department.adddepartment.AddDepartmentService;
import xperiment.utils.enums.NotificationMessages;
import xperiment.utils.enums.StringsUtils;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddDepartmentLayoutFactory {

	private class AddDepartmentLayout extends VerticalLayout implements Button.ClickListener{

		private static final long serialVersionUID = 1L;
		private Button saveButton;
		private Button clearButton;
		private TextField departmentName;
		private TextField departmentLocation;
		private Deparment department;
		private BeanFieldGroup<Deparment> beanField;
		private SaveDepartmentListener savedDepartmentListener;
		
		public AddDepartmentLayout(SaveDepartmentListener departmentSavedListener) {
			this.savedDepartmentListener = departmentSavedListener;
		}
		
		public AddDepartmentLayout init() {
			
			beanField = new BeanFieldGroup<Deparment>(Deparment.class);
			this.department= new Deparment();
			
			departmentName = new TextField(StringsUtils.DEPARTMENT_NAME.getString());
			departmentLocation = new TextField(StringsUtils.DEPARTMENT_LOCATION.getString());
			
			departmentName.setNullRepresentation("");
			departmentLocation.setNullRepresentation("");
			
			saveButton = new Button(StringsUtils.SAVE.getString());
			clearButton = new Button(StringsUtils.CLEAR.getString());
			
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
			
			saveButton.addClickListener(this);
			clearButton.addClickListener(this);
			
			return this;
		}

		public AddDepartmentLayout bind() {
			beanField.bindMemberFields(this);
			beanField.setItemDataSource(department);
			return this;
		}

		public Component layout() {
			
			setMargin(true);
			
			GridLayout layout = new GridLayout(1, 3);
			layout.setSizeUndefined();
			layout.setSpacing(true);

			layout.addComponent(departmentName, 0, 0);
			layout.addComponent(departmentLocation, 0, 1);

			layout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 2);
			

			return layout;
		}

		private void clearFields() {

			departmentName.setValue(null);
			departmentLocation.setValue(null);

		}

		private void save() {

			try {
				beanField.commit();
				Notification.show(NotificationMessages.SAVE_DEPARTMENT.getString(),
						NotificationMessages.SAVE_DEPARTMENT_MESSAGE.getString(),Type.ASSISTIVE_NOTIFICATION);
			} catch (CommitException e) {
				Notification.show(NotificationMessages.ERROR_SAVE_DEPARTMENT.getString(),
						NotificationMessages.ERROR_SAVE_DEPARTMENT_MESSAGE.getString(),Type.ERROR_MESSAGE);
				return;
			}finally {
				addDepartmentService.save(department);
				savedDepartmentListener.savedDepartment();
				clearFields();
				Notification.show(NotificationMessages.SAVE_DEPARTMENT.getString(),
						NotificationMessages.SAVE_DEPARTMENT_MESSAGE.getString(),Type.ASSISTIVE_NOTIFICATION);

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
	private AddDepartmentService addDepartmentService;

	public Component createComponent(SaveDepartmentListener departmentSavedListener) {

		return new AddDepartmentLayout(departmentSavedListener).init().bind().layout();

	}

}
