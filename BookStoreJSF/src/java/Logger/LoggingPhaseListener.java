package Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jgutierrez
 */
public class LoggingPhaseListener implements PhaseListener {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingPhaseListener.class);
        
    @Override
    public void afterPhase(PhaseEvent event) {
        LOG.debug("After Phase {}",event.getPhaseId());
        System.out.println("Logger.LoggingPhaseListener.afterPhase():"+event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
           LOG.debug("Before Phase {}",event.getPhaseId());
           System.out.println("Logger.LoggingPhaseListener.beforePhase():"+event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
         return PhaseId.ANY_PHASE;
    }
    
}
