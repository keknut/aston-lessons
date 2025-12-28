package chainOfResponsibility;

public class ThirdHandler extends Handler {
    @Override
    public void handle(Request request) {
        if (request.getDeep() > 2 && request.getDeep() <= 3) {
            System.out.println("Third handler: processed the request.");
        } else if (next != null) {
            System.out.println("Third handler: Некому передавать дальше");
            next.handle(request);
        } else {
            System.out.println("Запрос не был обработан: " + request.getDeep());
        }
    }
}
