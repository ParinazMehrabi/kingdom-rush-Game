package view.fxmlController;

import controller.UpdateController;
import exceptions.NullField;
import exceptions.RepeatedID;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import view.HelloApplication;

import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainHomeController implements Initializable
{
    @FXML private Label diamondsC;
    @FXML private ImageView settings;
    @FXML private ImageView shop;
    @FXML private ImageView closeS;
    @FXML private AnchorPane update;
    @FXML private AnchorPane options;
    @FXML private ImageView sound;
    @FXML private Slider vSlider;
    @FXML private ImageView op;
    @FXML private ImageView first;
    @FXML private ImageView firstG;
    @FXML private Label op2;
    @FXML private Label chEError;
    @FXML private TextField updateUsername;
    @FXML private PasswordField updatePassword;
    private boolean updateV;
    private Media mapSound;
    private MediaPlayer mapMusic;
    private boolean set;
    private boolean shopC;
    private boolean close;
    private boolean soundB;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        set = false;
        shopC = false;
        close = false;
        soundB = false;
        updateV = false;
        mapSound = new Media(Objects.requireNonNull(HelloApplication.class.getResource("soundEffects/Map.mp3")).toExternalForm());
        mapMusic = new MediaPlayer(mapSound);
        updatePassword.setText(null);
        updateUsername.setText(null);
        System.out.println(mapMusic.getVolume());
        vSlider.setValue(100);
        mapMusic.setOnEndOfMedia(()->
        {
            mapMusic.seek(Duration.seconds(0));
        });
        mapMusic.play();
        vSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mapMusic.setVolume(vSlider.getValue() * 0.01);
            }
        });
    }
    public void settings(MouseEvent event)
    {
//        set = !set;
//        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/settingsG.png")).toExternalForm());
//        Image image2 = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/settingsIcon.png")).toExternalForm());
//        if(set)
//        {
//            settings.setImage(image);
//        }
//        else
//        {
//            settings.setImage(image2);
//        }
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(2));
        slide1.setNode(options);
        slide1.setToY(-760);
        slide1.play();
    }

    public void shop(MouseEvent event)
    {
        shopC = !shopC;
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/GShop.png")).toExternalForm());
        Image image2 = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/shopIcon.png")).toExternalForm());
        if(shopC)
        {
            shop.setImage(image);
        }
        else
        {
            shop.setImage(image2);
        }
    }

    public void sh(MouseEvent event)
    {
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/GShop.png")).toExternalForm());
        shop.setImage(image);
    }

    public void op(MouseEvent event)
    {
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/shopIcon.png")).toExternalForm());
        shop.setImage(image);
    }

    public void setEn(MouseEvent event)
    {
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/settingsG.png")).toExternalForm());
        settings.setImage(image);
    }

    public void setEx(MouseEvent event)
    {
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/settingsIcon.png")).toExternalForm());
        settings.setImage(image);
    }

    public void close(MouseEvent event)
    {
        close = !close;
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/img.png")).toExternalForm());
        Image image2 = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/img_1.png")).toExternalForm());
        if(close)
        {
            closeS.setImage(image);
        }
        else
        {
            closeS.setImage(image2);
        }
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(2));
        slide1.setNode(options);
        slide1.setToY(760);
        slide1.play();
        System.out.println(update.getLayoutX());
        if(updateV) {
            op2.setVisible(false);
            op.setVisible(false);
            System.out.println("hhh");
            TranslateTransition slide2 = new TranslateTransition();
            slide2.setDuration(Duration.seconds(1.2));
            slide2.setNode(update);
            slide2.setToY(760);
            slide2.play();
        }
    }

    public void closeEn(MouseEvent event)
    {
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/img.png")).toExternalForm());
        closeS.setImage(image);
    }

    public void closeEx(MouseEvent event)
    {
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/img_1.png")).toExternalForm());
        closeS.setImage(image);
    }

    public void mute(MouseEvent event)
    {
        soundB = !soundB;
        Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/img_3.png")).toExternalForm());
        Image image2 = new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/img_2.png")).toExternalForm());
        if(soundB)
        {
            mapMusic.setMute(true);
            sound.setImage(image);
        }
        else
        {
            mapMusic.setMute(false);
            sound.setImage(image2);
        }
    }

    public void changeInfo(MouseEvent event)
    {
        op.setVisible(true);
        op2.setVisible(true);
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(1));
        slide1.setNode(update);
        slide1.setToX(1024);
        slide1.play();
        updateV = true;
        chEError.setVisible(false);
    }

    public void apply(MouseEvent event) throws SQLException, ClassNotFoundException, NullField
    {
        if(updateUsername.getText() == null && updatePassword.getText() == null)
        {
            chEError.setVisible(true);
            chEError.setText("you must fill at least one field");
            throw new NullField("fields cannot be null");
        }
        if(updatePassword != null && updateUsername.getText() != null)
        {
            UpdateController.getUpdateController().updatePassword(updatePassword.getText());
            try {
                UpdateController.getUpdateController().updateUsername(updateUsername.getText());
            } catch (RepeatedID e) {
                chEError.setVisible(true);
                chEError.setText("this id already exists");
            }
        }
        if(updateUsername.getText() == null)
        {
            UpdateController.getUpdateController().updatePassword(updatePassword.getText());
        }
        else if(updatePassword.getText() == null)
        {
            try {
                UpdateController.getUpdateController().updateUsername(updateUsername.getText());
            } catch (RepeatedID e) {
                chEError.setVisible(true);
                chEError.setText("this id already exists");
            }
        }
    }

    public void firstEn(MouseEvent event)
    {
        firstG.setVisible(true);
        first.setVisible(false);
    }

    public void firstEx(MouseEvent event)
    {
        firstG.setVisible(false);
        first.setVisible(true);
    }

    public void firstMap(MouseEvent event)
    {

    }
}
