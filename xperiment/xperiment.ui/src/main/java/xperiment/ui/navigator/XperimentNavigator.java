package xperiment.ui.navigator;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class XperimentNavigator extends Navigator{

	private static final long serialVersionUID = 6031668775889331351L;

	public XperimentNavigator(UI ui, SingleComponentContainer container) {

		super(ui, container);

	}

	private static  XperimentNavigator getNavigator() {
		
		UI ui = UI.getCurrent();

		Navigator navigator = ui.getNavigator();
		
		return (XperimentNavigator) navigator;
	}

	public static void nagivate(String path) {
		
		try {
			
			XperimentNavigator.getNavigator().navigateTo(Strings.nullToEmpty(path));
			
		} catch (Exception e) {

			return;
			
		}

	}
	
	@Override
	public void navigateTo(String navigationState) {

		super.navigateTo(Strings.nullToEmpty(navigationState));

	}

}
