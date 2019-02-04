
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dtSelectionView")
@ViewScoped
public class SelectionView implements Serializable {
     
    private List<Car> cars1;
    private Car selectedCar;
    private List<Car> selectedCars;
  
     
    @PostConstruct
    public void init() {
        cars1 = new ArrayList<>();
        cars1.add(new Car("1", "Toyota", 1999, "Red"));
    }
 
    public List<Car> getCars1() {
        return cars1;
    }
 
     
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
 
    public List<Car> getSelectedCars() {
        return selectedCars;
    }
 
    public void setSelectedCars(List<Car> selectedCars) {
        this.selectedCars = selectedCars;
    }
    

}