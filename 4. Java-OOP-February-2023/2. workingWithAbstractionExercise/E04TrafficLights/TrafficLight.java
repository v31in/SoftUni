package workingWithAbstractionExercise.E04TrafficLights;

public class TrafficLight {
    Signals signals;

    public TrafficLight(Signals signals) {
        this.signals = signals;
    }

    public void updateTrafficLight() {
        this.signals = signals.next();
    }
}
