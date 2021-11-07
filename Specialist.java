public class Specialist implements Runnable {
    AutomaticTelephoneStation ats;
    private final int TIMEOUT = 4000;

    public Specialist(AutomaticTelephoneStation ats) {
        this.ats = ats;
    }

    @Override
    public void run() {
        String call;
        while (ats.isGeneration() || !ats.getCalls().isEmpty()) {
            if ((call = ats.getCalls().poll()) != null) {
                System.out.println("Специалист " + Thread.currentThread().getName() + " начал обработку звонка " + call);
                try {
                    Thread.sleep(TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Специалист " + Thread.currentThread().getName() + " обработал звонок "
                        + call);
            }
        }
    }
}
