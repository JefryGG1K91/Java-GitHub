package xperiment.ui.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import xperiment.model.Deparment;
import xperiment.service.department.departmentstatistics.DepartmentStatisticsServ;
import xperiment.service.department.showalldepartment.ShowAllDepartmentService;
import xperiment.ui.builder.UiComponentBuilder;

@Component
public class StatisticsDeparmentLayoutFactory implements UiComponentBuilder {

	private List<Deparment> departments;

	@Autowired
	private DepartmentStatisticsServ departmentStatistics;

	@Autowired
	private ShowAllDepartmentService showAllDeparmentServices;

	private class StatisticsDeparmentLayout extends VerticalLayout {

		private static final long serialVersionUID = 1L;

		public StatisticsDeparmentLayout load() {

			departments = showAllDeparmentServices.getAllDepartment();
			return this;
		}

		public StatisticsDeparmentLayout layout() {

			try {
				setMargin(true);

				for (Deparment deparment : departments) {

					Integer numOfEmployees = departmentStatistics.getNumOfEmployeeForDepartment(deparment.getId());
					Label label = new Label("<p><b>"+deparment.getDepartmentName()+"</b>"+" - "+numOfEmployees+" employee(s)"+"</p>", ContentMode.HTML);
//					Label label = new Label("Test");
					addComponent(label);

				}

			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
				
				return this;
		}

	}

	@Override
	public com.vaadin.ui.Component createComponent() {
		return new StatisticsDeparmentLayout().load().layout();
	}

}
