package chainOfResponsibility;

public class SecondHandler extends Handler {
    @Override
    public void handle(Request request) {
        if (request.getDeep() > 1 && request.getDeep() <= 2) {
            System.out.println("Second handler: processed the request.");
        } else if (next != null) {
            System.out.println("Second handler: Передаю дальше");
            next.handle(request);
        }
    }
}
