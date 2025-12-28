package App;
import proxy.*;

public class Proxy {
    public static void main(String[] args) {
        Video video = new VideoProxy("GoF-patterns.mp4", "user");

        System.out.println("Видео ещё не загружено");

        video.play();

        System.out.println("\n=== Доступ с ограниченной ролью ===");
        Video restricteeVideo = new VideoProxy("GoF-patterns.mp4", "guest");
        restricteeVideo.play();
    }
}
