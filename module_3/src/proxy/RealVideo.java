package proxy;

public class RealVideo implements Video {
    private String filename;
    
    public RealVideo(String filename) {
        this.filename = filename;
        loadVideo();
    }

    private void loadVideo() {
        System.out.println("**Загрузка видео: " + filename);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("--Видео '" + filename + "' загружено");
    }

    @Override
    public void play() {
        System.out.println("Воспроизводится видео: " + filename);
    }
}
