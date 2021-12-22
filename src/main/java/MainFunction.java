

public class MainFunction {

    public static void main(String[] args) {

        Daemon daemon = new Daemon();

        daemon.setDaemon(true);

        daemon.start();
    }
}
