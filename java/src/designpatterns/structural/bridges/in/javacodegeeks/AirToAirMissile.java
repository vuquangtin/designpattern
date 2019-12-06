package in.javacodegeeks;

public class AirToAirMissile implements Missile {

    private Igniter igniter;

    public AirToAirMissile(Igniter igniter) {
        this.igniter = igniter;
    }

    public void explode() {

        //Actions relation to explosion

        igniter.ignite();
    }
}
