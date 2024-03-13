package MenstrualCycle;

public class User {

        private final String lastPeriodDate;

        public User(String lastPeriodDate) {
            this.lastPeriodDate = lastPeriodDate;
        }
        public String getLastPeriodDate() {
            return lastPeriodDate;
        }

        public void calculateMenstrualCycle(MenstrualApp cycleTracker) {
            getNextOvulationDay(cycleTracker);
            getNextPeriodDay(cycleTracker);
        }
        private void getNextOvulationDay(MenstrualApp cycleTracker) {
            cycleTracker.calculateNextOvulationDate();
        }
        private void getNextPeriodDay(MenstrualApp cycleTracker) {
            cycleTracker.calculateNextPeriodDate();
        }
    }

