import java.util.HashMap;
import java.util.Date;
public class State {
        private State                      lastState;
        private HashMap<String, String>     changesMade;
        private Phase                       actualPhase;
        private Date                        releaseDate;
        public State(String s) {
                String[] lista = s.split(".\n");
                for (String x: lista) {
                        String cambio[] = x.split(":");
                        //cambiosRealizados.(cambio[0], cambio[1]);
                }
        }
        public State() {
                actualPhase = Phase.Planification;
                releaseDate = new Date();
        }
        public void next() {
                switch (actualPhase) {
                        case Planification: 
                                actualPhase = Phase.Design; break; 
                        case Design: 
                                actualPhase = Phase.Build; break;
                        case Build: 
                                actualPhase = Phase.Testing; break; 
                        case Testing: 
                                actualPhase = Phase.Deploy; break; 
                        case Deploy: 
                                break;
                        default:
                                actualPhase = Phase.Planification;
                }
        }
        public Date getReleaseDate() {return releaseDate;}
        public Phase getPhase() {return actualPhase;}
}