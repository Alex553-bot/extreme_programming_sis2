import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestClass {
        private UserStory       us;
        private Version         version;
        private State           estado;
        public TestClass() {  
        }
        @BeforeEach
        public void setUp() {
            us = new UserStory(1);
            version = us.getVersion();
            estado = us.getState();  
        }
        @Test 
        public void testCreacionUserStory() {
            assertNotEquals(us, null);
        }
        @Test
        public void testGeneradorVersion() {  
            assertEquals("v1.0.0.0", version.getReadable());
        }
        @Test
        public void testUpdateVersion() {
                version.updMajorV();
                version.updMinorV();
                version.updBugFixRelease();
                version.updBugFixRelease();
                version.updBuildNumber(); 
                assertEquals("v2.1.2.1", version.getReadable());
        }
        @Test
        public void testPermitirCambioEstado() {
                us.setTeamScore(Valor.Ocho);
                us.setPriority(Valor.Uno);
                assertTrue(us.puedeImplementarse());
        }
        @Test
        public void testNoPermitePasoDeEstado() {
                us.setPriority(Valor.Cinco);
                assertFalse(us.puedeImplementarse());
        }
        @Test
        public void testObtenerEstado() {
                assertEquals(Phase.Planification, estado.getPhase());
        }
        @Test 
        public void testCreacionDeVersion() {
                Date date = new Date();
                assertEquals(date.compareTo(estado.getReleaseDate()), 0);
        }
        @Test 
        public void testPasarAEstadoDiseño() {
                us.setPriority(Valor.Dos);
                us.setTeamScore(Valor.Trece);
                us.nextPhase();
                State status = us.getState();
                State estimated = new State(); 
                estimated.next();
                assertEquals(estimated.getPhase(), status.getPhase());
        }
        @Test
        public void testNoPasarAEstadoDiseño() {
                us.setPriority(Valor.Infinito);
                us.setTeamScore(Valor.Trece);
                us.nextPhase();
                State status = us.getState();
                State estimated = new State(); 
                estimated.next();
                assertEquals(estimated.getPhase(), status.getPhase());
        }
        @Test
        public void testVerEstadoAnterior() {
                us.setPriority(Valor.Dos);
                us.setTeamScore(Valor.Trece);
                us.nextPhase();
                State status = us.getState();
                State estimated = new State(); 
                assertEquals(estimated.getPhase(), status.getPhase().getPrevious());
        }
        @AfterEach
        public void tearDown() {
        }
}
