package Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jgutierrez
 */
@Named
@ApplicationScoped
public class LoggingEventHandlers {
    
    private static final Logger LOG = LoggerFactory.getLogger(LoggingEventHandlers.class);
    
    public void valueChanged(ValueChangeEvent event){
        LOG.debug("Value of component {} was changed: [{}] => [{}]",event.getComponent().getId(), event.getOldValue().toString() + event.getNewValue().toString());
        System.out.println("Value of component {} was changed: [{}] => [{}]"+event.getComponent().getId()+"/"+ event.getOldValue().toString()+"/"+ event.getNewValue().toString());
    }
    
    public void actionPerformed(ActionEvent event){
         LOG.debug("",event.getComponent().getId());
         System.out.println("Logger.LoggingEventHandlers.actionPerformed(): "+event.getComponent().getId());
    }
    
    public void beforeValidation(ComponentSystemEvent event){
        LOG.debug("",event.getComponent().getId());
        System.out.println("Logger.LoggingEventHandlers.beforeValidation(): "+event.getComponent().getId());
    }
    
    public void afterValidation(ComponentSystemEvent event){
        UIInput inputComp = (UIInput) event.getComponent();
         LOG.debug("",inputComp.getId());
         System.out.println("Logger.LoggingEventHandlers.afterValidation():"+inputComp.getId());
    }
    
}
