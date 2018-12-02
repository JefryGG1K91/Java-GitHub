package xperiment.ui.signup;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path=SignUpUI.NAME)
@Theme("valo")
public class SignUpUI extends UI{

	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "/signup";
	
	@Autowired
	private SignUpFormFactory signUpFormFactory;
	
	@Override
	protected void init(VaadinRequest request) {
		
		setContent(signUpFormFactory.createComponent());
		
	}
}
