// Slip 15:-
// Write a Java Program to implement Facade Design Pattern for Home Theater

// Subsystems
class Amplifier {
    void on() { System.out.println("Amplifier is ON"); }
    void off() { System.out.println("Amplifier is OFF"); }
    void setVolume(int level) { System.out.println("Amplifier volume set to " + level); }
}

class Tuner {
    void on() { System.out.println("Tuner is ON"); }
    void off() { System.out.println("Tuner is OFF"); }
}

class DVDPlayer {
    void on() { System.out.println("DVD Player is ON"); }
    void off() { System.out.println("DVD Player is OFF"); }
    void play(String movie) { System.out.println("Playing movie: " + movie); }
    void stop() { System.out.println("DVD stopped"); }
}

class Projector {
    void on() { System.out.println("Projector is ON"); }
    void off() { System.out.println("Projector is OFF"); }
    void wideScreenMode() { System.out.println("Projector in widescreen mode"); }
}

// Facade
class HomeTheaterFacade {
    private Amplifier amp;
    private Tuner tuner;
    private DVDPlayer dvd;
    private Projector projector;

    HomeTheaterFacade(Amplifier amp, Tuner tuner, DVDPlayer dvd, Projector projector) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.projector = projector;
    }

    void watchMovie(String movie) {
        System.out.println("\nGet ready to watch a movie...");
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    void endMovie() {
        System.out.println("\nShutting movie theater down...");
        dvd.stop();
        dvd.off();
        amp.off();
        projector.off();
    }
}

// Client
public class HomeTheaterDemo {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, projector);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}

//output:-
// Get ready to watch a movie...
// Projector is ON
// Projector in widescreen mode
// Amplifier is ON
// Amplifier volume set to 5
// DVD Player is ON
// Playing movie: Inception

// Shutting movie theater down...
// DVD stopped
// DVD Player is OFF
// Amplifier is OFF
// Projector is OFF
