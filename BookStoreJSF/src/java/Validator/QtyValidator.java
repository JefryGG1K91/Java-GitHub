package Validator;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author jgutierrez
 */
@FacesValidator("qtyValidator")
public class QtyValidator implements Validator{

    private static final String PATTERN = "^\\d+$";
    
    @Override
    public void validate(FacesContext arg0, UIComponent component, Object value) throws ValidatorException {
       
        if (!Pattern.matches(PATTERN, value.toString())) {
            FacesMessage fcmg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Qty invalid","Qty Invalid");
                throw  new ValidatorException(fcmg);
        }
        
    }
    
    
}
