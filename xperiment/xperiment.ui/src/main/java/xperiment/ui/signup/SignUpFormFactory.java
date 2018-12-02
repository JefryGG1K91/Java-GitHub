package xperiment.ui.signup;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;
import xperiment.service.security.RegistrationUserService;

@org.springframework.stereotype.Component
public class SignUpFormFactory {

	private class SignUpForm{

		private VerticalLayout root;
		private Panel panel;
		private TextField username;
		private PasswordField password;
		private PasswordField passwordAgain;
		private Button clearButton;
		private Button saveButton;

		public SignUpForm init() {

			root = new VerticalLayout();
			root.setMargin(true);
			root.setHeight("100%");

			panel = new Panel("Login");
			panel.setSizeUndefined();

			username = new TextField("Username");
			password = new PasswordField("Password");
			passwordAgain = new PasswordField("Password Again");

			saveButton = new Button("Save");
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

			clearButton = new Button("Clear");
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

			username.setNullRepresentation("");
			password.setNullRepresentation("");
			passwordAgain.setNullRepresentation("");

			return this;
		}

		public Component layout() {

			root.addComponent(panel);
			root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

			FormLayout loginLayout = new FormLayout();
			loginLayout.addComponent(username);
			loginLayout.addComponent(password);
			loginLayout.addComponent(passwordAgain);
			loginLayout.addComponent(new HorizontalLayout(saveButton, clearButton));
			loginLayout.setHeightUndefined();
			loginLayout.setMargin(true);

			panel.setContent(loginLayout);

			saveButton.addClickListener(new ClickListener() {

				private static final long serialVersionUID = 1L;

				public void buttonClick(ClickEvent event) {

					if(!password.getValue().equals(passwordAgain.getValue())) {
						new Notification("Error !","",Type.ERROR_MESSAGE);
						return;
					}
						
					registrationUserService.save(username.getValue(), password.getValue());
					UI.getCurrent().getPage().setLocation("/xperiment.web-1.3.6.RELEASE/login");
				}
			});

			clearButton.addClickListener(new ClickListener() {

				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {

					clearFields();

				}
			});

			return root;
		}

		private void clearFields() {

			username.setValue(null);
			password.setValue(null);
			passwordAgain.setValue(null);

		}

	}

	@Autowired
	private RegistrationUserService registrationUserService;

	public Component createComponent() {
		return new SignUpForm().init().layout();
	}

}
