package xperiment.ui.main;

import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import xperiment.ui.builder.UiComponentBuilder;
import xperiment.ui.navigator.XperimentNavigator;
import xperiment.utils.enums.StringsUtils;

@org.springframework.stereotype.Component
public class XperimentMenuLayout implements UiComponentBuilder{

	private Tree treeMenu;

	private class XperimentMenu extends VerticalLayout implements Property.ValueChangeListener{

		private static final long serialVersionUID = 5782937847910924316L;

		public XperimentMenu init() {

			treeMenu = new Tree();
			treeMenu.addValueChangeListener(this);
			return this;

		}

		public XperimentMenu layout() {

			setWidth("100");
			setHeightUndefined();

			treeMenu.addItem(StringsUtils.EMPLOYEE.getString());
			treeMenu.expandItem(StringsUtils.EMPLOYEE.getString());
			
			treeMenu.addItem(StringsUtils.DEPARTMENT.getString());
			treeMenu.expandItem(StringsUtils.DEPARTMENT.getString());

			treeMenu.addItem(StringsUtils.LOGOUT.getString());
			treeMenu.expandItem(StringsUtils.LOGOUT.getString());
			
			
			treeMenu.addItem(StringsUtils.ADD_EMPLOYEE.getString());
			treeMenu.setChildrenAllowed(StringsUtils.ADD_EMPLOYEE.getString(), false);
			treeMenu.setParent(StringsUtils.ADD_EMPLOYEE.getString(), StringsUtils.EMPLOYEE.getString());
			
			treeMenu.addItem(StringsUtils.REMOVE_EMPLOYEE.getString());
			treeMenu.setChildrenAllowed(StringsUtils.REMOVE_EMPLOYEE.getString(), false);
			treeMenu.setParent(StringsUtils.REMOVE_EMPLOYEE.getString(), StringsUtils.EMPLOYEE.getString());
			
			treeMenu.addItem(StringsUtils.ADD_DEPARTMENT.getString());
			treeMenu.setChildrenAllowed(StringsUtils.ADD_DEPARTMENT.getString(), false);
			treeMenu.setParent(StringsUtils.ADD_DEPARTMENT.getString(), StringsUtils.DEPARTMENT.getString());
			
			treeMenu.addItem(StringsUtils.LOGOUT.getString());
			treeMenu.setChildrenAllowed(StringsUtils.LOGOUT.getString(), false);
			treeMenu.setParent(StringsUtils.LOGOUT.getString(), StringsUtils.LOGOUT.getString());
			
			addComponent(treeMenu);

			return this;
		}


		@Override
		public void valueChange(ValueChangeEvent event) {

			String selectedItemPath = (String) event.getProperty().getValue();

			System.out.println(selectedItemPath.toLowerCase().replaceAll("\\s+",""));
			
			if(selectedItemPath == null) return;
			
			if(selectedItemPath.equals(StringsUtils.LOGOUT.getString())) {
				SecurityContextHolder.clearContext();
				UI.getCurrent().getPage().setLocation("/xperiment.web-1.3.6.RELEASE/login");
			}

			String path = selectedItemPath.toLowerCase().replaceAll("\\s+","");

			XperimentNavigator.nagivate(path);

		}

	}

	@Override
	public Component createComponent() {

		return new XperimentMenu().init().layout();

	}

}
