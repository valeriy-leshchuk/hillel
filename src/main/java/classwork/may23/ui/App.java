package classwork.may23.ui;

public class App
{
    public static void main(String[] args)
    {
        Window window = new Window.WindowBuilder()
            .windowHeight(300)
            .windowWidth(400)
            .windowTitle("Title")
            .build();
        window.init();
    }
}
