package xperiment.ui.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import xperiment.ui.department.DepartmentLayoutFactory;
import xperiment.ui.employee.EmployeeLayoutFactory;
import xperiment.ui.navigator.XperimentNavigator;

@SpringUI(path=XperimentMainUI.NAME)

@Theme("valo")
public class XperimentMainUI extends UI{

	private static final long serialVersionUID = 301936390478971926L;

	public static final String NAME="xperimentui";

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private SpringViewProvider viewProvider;

	public Panel changeTap= new Panel();

	@Autowired
	private XperimentMenuLayout xperimentMenuLayout;
	
	@Override
	protected void init(VaadinRequest request) {


		changeTap.setHeight("100%");

		VerticalLayout rootLayout= new VerticalLayout();
		rootLayout.setSizeFull();
		rootLayout.setMargin(true);

		Panel contentPanel= new Panel();
		contentPanel.setWidth("100%");
		contentPanel.setHeight("100%");

//		Panel logoPanel= new Panel();
//		logoPanel.setWidth("100%");
//		logoPanel.setHeightUndefined();

		HorizontalLayout uiLayout= new HorizontalLayout();
		uiLayout.setSizeFull();
		uiLayout.setMargin(true);

//		Component logo= logoFactory.createComponent();
		Component menu=xperimentMenuLayout.createComponent();

		uiLayout.addComponent(menu);
		uiLayout.addComponent(changeTap);

		uiLayout.setComponentAlignment(changeTap, Alignment.TOP_CENTER);
		uiLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);

		uiLayout.setExpandRatio(menu,1);
		uiLayout.setExpandRatio(changeTap,2);

//		logoPanel.setContent(logo);
		contentPanel.setContent(uiLayout);

//		rootLayout.addComponent(logoPanel);
		rootLayout.addComponent(contentPanel);
		rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
//		rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
		rootLayout.setExpandRatio(contentPanel, 1);

		initNavigation();

		setContent(rootLayout);


	}

	private void initNavigation() {
		XperimentNavigator nav = new XperimentNavigator(this, changeTap);
		appContext.getAutowireCapableBeanFactory().autowireBean(nav);
		nav.addProvider(viewProvider);
		nav.addView(EmployeeLayoutFactory.NAME, EmployeeLayoutFactory.class);
		nav.addView(DepartmentLayoutFactory.NAME, DepartmentLayoutFactory.class);
		nav.navigateTo(EmployeeLayoutFactory.NAME);
	}



}
