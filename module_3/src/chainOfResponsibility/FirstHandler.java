package chainOfResponsibility;

public class FirstHandler extends Handler{
    @Override
    public void handle(Request request) {
        if (request.getDeep() <= 1) {
            System.out.println("First handler: processed the request.");
        } else if (next != null) {
            System.out.println("First handler: Передаю дальше");
            next.handle(request);
        }
    }
}
