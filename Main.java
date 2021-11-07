public class Main {
    public static void main(String[] args) {
        AutomaticTelephoneStation ats = new AutomaticTelephoneStation();
        Thread thread1 = new Thread(ats);
        Thread thread2 = new Thread(new Specialist(ats),"1" );
        Thread thread3 = new Thread(new Specialist(ats),"2" );
        Thread thread4 = new Thread(new Specialist(ats),"3" );
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все звонки обработаны");
    }
}
