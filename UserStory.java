public class UserStory {
        private Version     version; 
        private String      name; 
        private final int   ID; 
        private Valor       teamScore; 
        private Valor       clientScore; 
        private State       state;
        public UserStory(int id) {
                version = new Version();
                ID      = id; 
                teamScore = Valor.Indefinido;
                clientScore = Valor.Indefinido;
                state = new State();
        }
        public boolean puedeImplementarse() {
                boolean resp     = Valor.Indefinido == teamScore;
                resp            |= Valor.Indefinido == clientScore; 
                resp            |= Valor.Infinito   == teamScore; 
                resp            |= Valor.Infinito   == clientScore;
                return !resp;
        }
        public void nextPhase() {
                if (puedeImplementarse()) 
                        state.next();
        }
        public void setTeamScore(Valor v) {teamScore = v;}
        public void setPriority(Valor v) {clientScore = v;}
        public Version getVersion() {return version;}
        public State getState() {return state;}
}
