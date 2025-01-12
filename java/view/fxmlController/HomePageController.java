package view.fxmlController;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePageController implements Initializable
{
    @FXML private ImageView close;
    @FXML private ImageView start;
    @FXML private ImageView settings;
    @FXML private AnchorPane rightAnc;
    @FXML private AnchorPane leftAnc;
    @FXML private AnchorPane login;
    private Media main;
    private MediaPlayer mainMusic;
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        rightAnc.setLayoutX(rightAnc.getLayoutX()+ 654);
        leftAnc.setLayoutX(-655);
        main = new Media(Objects.requireNonNull(HelloApplication.class.getResource("soundEffects/02. Main Music.mp3")).toExternalForm());
        mainMusic = new MediaPlayer(main);
        mainMusic.setVolume(0.3);
        mainMusic.setOnEndOfMedia(()->
        {
            mainMusic.seek(Duration.seconds(0));;
        });
        mainMusic.play();
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(2));
        slide1.setNode(start);
        slide1.setToY(100);
        slide1.play();
    }

    public void close(MouseEvent event)
    {
        Media media = new Media(Objects.requireNonNull(HelloApplication.class.getResource("soundEffects/146_Sound_GUIButtonCommon.mp3")).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setVolume(1.0);
        stage.close();
    }

    public void start(MouseEvent event) {
        Media media = new Media(Objects.requireNonNull(HelloApplication.class.getResource("soundEffects/146_Sound_GUIButtonCommon.mp3")).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(1.0);
        mediaPlayer.play();
        TranslateTransition slide1 = new TranslateTransition();
        TranslateTransition slide2 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(2));
        slide2.setDuration(Duration.seconds(2));
        slide1.setNode(rightAnc);
        slide2.setNode(leftAnc);
        slide1.setToX(-643);
        slide2.setToX(642);
        slide1.play();
        slide2.play();
        mainMusic.stop();
        main = new Media(Objects.requireNonNull(HelloApplication.class.getResource("soundEffects/01. Logo Shimmer.mp3")).toExternalForm());
        mainMusic = new MediaPlayer(main);
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2.0));
        pauseTransition.play();
        mediaPlayer.setOnEndOfMedia(() ->
        {
            mainMusic.play();
        });
        slide1.setOnFinished(actionEvent ->
        {
            loadingAnimation();
        });

    }
    public void loadingAnimation()
    {
        TranslateTransition slide3 = new TranslateTransition();
        TranslateTransition slide4 = new TranslateTransition();
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2.0));
        pauseTransition.play();
        login.setVisible(true);
        pauseTransition.setOnFinished(actionEvent ->
        {

            slide3.setDuration(Duration.seconds(2));
            slide4.setDuration(Duration.seconds(2));
            slide3.setNode(rightAnc);
            slide4.setNode(leftAnc);
            slide3.setToX(643);
            slide4.setToX(-654);
            slide3.play();
            slide4.play();
        });
        slide3.setOnFinished(actionEvent ->
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("initialPage.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Game!");
            stage.setScene(scene);
            stage.show();
            stage.setFullScreen(true);
        });
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
