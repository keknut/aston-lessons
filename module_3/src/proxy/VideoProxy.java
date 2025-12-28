package proxy;

public class VideoProxy implements Video{
    private String filename;
    private RealVideo realVideo;
    private String userRole;

    public VideoProxy(String filename, String userRole) {
        this.filename = filename;
        this.userRole = userRole;
    }

    @Override
    public void play() {
        if (!"admin".equals(userRole) && !"user".equals(userRole)) {
            System.out.println("Недостаточно прав для просмотра видео");
            return;
        }

        if (realVideo == null) { 
            realVideo = new RealVideo(filename);
        }

        realVideo.play();
    }
}
