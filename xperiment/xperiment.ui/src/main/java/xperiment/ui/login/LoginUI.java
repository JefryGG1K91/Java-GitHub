package xperiment.ui.login;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path=LoginUI.NAME)
@Title(value="X p e r i m e n t")
@Theme("valo")
public class LoginUI extends UI{

	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "/login";
	
	@Autowired
	private LoginFormFactory loginFormFactory;
	
	@Override
	protected void init(VaadinRequest request) {
		
		setContent(loginFormFactory.createComponent());
		
	}
	
}
