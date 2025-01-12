package view.fxmlController;

import controller.LoginController;
import controller.SignupController;
import exceptions.IdNotFound;
import exceptions.NullField;
import exceptions.RepeatedID;
import exceptions.WrongPassword;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.HelloApplication;

import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class InitialPageController implements Initializable
{
    private Media talk;
    private MediaPlayer talkVoice;
    @FXML private AnchorPane s_L;
    @FXML private AnchorPane initial;
    @FXML private VBox signupV;
    @FXML private VBox sVv;
    @FXML private VBox lVv;
    @FXML private VBox loginV;
    @FXML private Button signupBtn;
    @FXML private Button loginBtn;
    @FXML private ImageView sV;
    @FXML private ImageView sIn;
    @FXML private ImageView lV;

    @FXML private ImageView lIn;
    @FXML private TextField sVP;
    @FXML private TextField username;
    @FXML private TextField lUsername;
    @FXML private PasswordField sInP;
    @FXML private TextField lVP;
    @FXML private PasswordField lInP;
    @FXML private Label usernameError;
    @FXML private Label loginError;
    @FXML private Label passwordError;
    @FXML private HBox signupF;
    @FXML private HBox loginF;
    @FXML private AnchorPane rightAnc;
    @FXML private AnchorPane leftAnc;
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        rightAnc.setLayoutX(rightAnc.getLayoutX()+ 654);
        leftAnc.setLayoutX(-655);
        username.setText(null);
        sInP.setText(null);
        sVP.setText(null);
        lUsername.setText(null);
        lInP.setText(null);
        lVP.setText(null);
        sIn.setVisible(true);
        sV.setVisible(false);
        lIn.setVisible(true);
        lV.setVisible(false);
        sVv.getChildren().remove(sVP);
        lVv.getChildren().remove(lVP);
        talk = new Media(Objects.requireNonNull(HelloApplication.class.getResource("soundEffects/welcome 20to 20the 20Game 20.mp3")).toExternalForm());
        talkVoice = new MediaPlayer(talk);
        talkVoice.setOnEndOfMedia(()->
        {
            System.out.println("d");
        });
        talkVoice.play();
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public void signup(MouseEvent event)
    {
        Media media = new Media(Objects.requireNonNull(HelloApplication.class.getResource("soundEffects/146_Sound_GUIButtonCommon.mp3")).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setVolume(1.0);
        signupF.setVisible(true);
        loginF.setVisible(false);
        sIn.setVisible(true);
        lIn.setVisible(false);
        lV.setVisible(false);
        loginBtn.setVisible(false);
        signupBtn.setVisible(true);
        loginV.setVisible(false);
        signupV.setVisible(true);
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(2));
        slide1.setNode(initial);
        slide1.setToX(1200);
        slide1.play();
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(2));
        slide.setNode(s_L);
        slide.setToX(1105);
        slide.play();
        sInP.textProperty().addListener((observable, oldValue, newValue)->
        {
            sVP.setText(sInP.getText());
        });
        lInP.textProperty().addListener((observable, oldValue, newValue)->
        {
            lVP.setText(sInP.getText());
        });
    }

    public void login(MouseEvent event)
    {
        Media media = new Media(Objects.requireNonNull(HelloApplication.class.getResource("soundEffects/146_Sound_GUIButtonCommon.mp3")).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setVolume(1.0);
        signupF.setVisible(false);
        loginF.setVisible(true);
        sV.setVisible(false);
        sIn.setVisible(false);
        lIn.setVisible(true);
        lV.setVisible(false);
        loginBtn.setVisible(true);
        signupBtn.setVisible(false);
        loginV.setVisible(true);
        signupV.setVisible(false);
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(2));
        slide1.setNode(initial);
        slide1.setToX(1200);
        slide1.play();
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(2));
        slide.setNode(s_L);
        slide.setToX(1105);
        slide.play();
    }

    public void sVisible(MouseEvent event)
    {
        if(sInP.getText() != null)
            sVP.setText(sInP.getText());
        sVv.getChildren().remove(sInP);
        sVv.getChildren().remove(passwordError);
        sVv.getChildren().remove(sVP);
        sVv.getChildren().add(sVP);
        sVv.getChildren().add(passwordError);
        sIn.setVisible(false);
        sV.setVisible(true);
    }

    public void sInvisible(MouseEvent event)
    {
        if(sVP.getText() != null)
            sInP.setText(sVP.getText());
        sVv.getChildren().remove(passwordError);
        sVv.getChildren().add(sInP);
        sVv.getChildren().add(passwordError);
        sVv.getChildren().remove(sVP);
        sIn.setVisible(true);
        sV.setVisible(false);
    }

    public void lVisible(MouseEvent event)
    {
        if(lInP.getText() != null)
            lVP.setText(lInP.getText());
        lVv.getChildren().remove(lInP);
        lVv.getChildren().remove(loginError);
        lVv.getChildren().remove(lVP);
        lVv.getChildren().add(lVP);
        lVv.getChildren().add(loginError);
        lIn.setVisible(false);
        lV.setVisible(true);
    }

    public void lInvisible(MouseEvent event)
    {
        if (lVP.getText() != null)
            lInP.setText(lVP.getText());
        lVv.getChildren().remove(lVP);
        lVv.getChildren().remove(loginError);
        lVv.getChildren().remove(lInP);
        lVv.getChildren().add(lInP);
        lVv.getChildren().add(loginError);
        lIn.setVisible(true);
        lV.setVisible(false);
    }

    public void signUp(MouseEvent event) throws NullField, SQLException, ClassNotFoundException {
        System.out.println("hey");
        System.out.println(username.getText());
        System.out.println(sInP.getText());
        if(username.getText() == null)
        {
            usernameError.setVisible(true);
            throw new NullField("null field");
        }
        if(sInP.getText() == null)
        {
            passwordError.setText("password cannot be empty");
            passwordError.setVisible(true);
            throw new NullField("null field");
        }
        else
        {
            boolean result = false;
            try {
                result = SignupController.getSignupController().signup(username.getText(), sInP.getText());
            } catch (RepeatedID e) {
                passwordError.setText("this username exist");
                passwordError.setVisible(true);
            }
            if(result){
                passwordError.setVisible(false);
                usernameError.setVisible(false);
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
            }
        }
    }

    public void logIn(MouseEvent event) throws NullField, SQLException {
        if(lUsername.getText() == null || lInP.getText() == null)
        {
            loginError.setVisible(true);
            loginError.setText("all fields must be filled");
            throw new NullField("null field");
        }
        else
        {
            boolean result = false;
            try {
                result = LoginController.getLoginController().login(lUsername.getText(), lInP.getText());
            } catch (WrongPassword e) {
                loginError.setVisible(true);
                loginError.setText("password is wrong");
            }
            catch (IdNotFound e)
            {
                loginError.setText("this id already exist");
                loginError.setVisible(true);
            }
            if(result) {
                loginError.setVisible(false);
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
            }
        }
    }

    public void signupF(MouseEvent event)
    {

    }

    public void loginF(MouseEvent event)
    {

    }
}
