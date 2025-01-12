package view.fxmlController;

import controller.PurchaseController;
import controller.spells.CoinController;
import controller.spells.FreezeController;
import controller.spells.HealthController;
import controller.spells.LittleBoyController;
import exceptions.NotEnoughDiamonds;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Player;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static controller.SignupController.player;

public class ShopController implements Initializable {
    @FXML private Label hCount;
    @FXML private Label cCount;
    @FXML private Label fCount;
    @FXML private Label lBCount;
    @FXML private Label diamondsC;
    @FXML private ImageView hG;
    @FXML private ImageView lBG;
    @FXML private ImageView fG;
    @FXML private AnchorPane fInfo;
    @FXML private AnchorPane lBInfo;
    @FXML private AnchorPane cInfo;
    @FXML private AnchorPane hInfo;
    @FXML private ImageView fColor;
    @FXML private ImageView hColor;
    @FXML private ImageView lBcolor;
    @FXML private ImageView cColor;
    @FXML private AnchorPane error;
    private boolean fClick;
    private boolean lBClick;
    private boolean hClick;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        player = new Player(1,"k","k",0,2000,0);
        diamondsC.setText(String.valueOf(player.getDiamond()));
        fClick = false;
        lBClick = false;
        hClick = false;
    }

    public void fEn(MouseEvent event)
    {
        lBG.setVisible(false);
        hG.setVisible(false);
        fG.setVisible(true);
    }

    public void fEx(MouseEvent event) {
        if(!fClick)
            fG.setVisible(false);
    }

    public void lEn(MouseEvent event)
    {
        fClick = false;
        hClick = false;
        fG.setVisible(false);
        hG.setVisible(false);
        lBG.setVisible(true);
    }

    public void lEx(MouseEvent event) {
        if(!lBClick)
            lBG.setVisible(false);
    }

    public void hEn(MouseEvent event) {
        fClick = false;
        lBClick = false;
        lBG.setVisible(false);
        fG.setVisible(false);
        hG.setVisible(true);
    }

    public void hEx(MouseEvent event) {
        if(!hClick)
            hG.setVisible(false);
    }

    public void fInfo(MouseEvent event)
    {
        fClick = true;
        hInfo.setVisible(false);
        lBInfo.setVisible(false);
        cInfo.setVisible(false);
        fInfo.setVisible(true);
        fG.setVisible(true);
    }

    public void cInfo(MouseEvent event)
    {
        fClick = false;
        lBClick = false;
        hClick = false;
        fG.setVisible(false);
        hG.setVisible(false);
        hInfo.setVisible(false);
        lBInfo.setVisible(false);
        fInfo.setVisible(false);
        cInfo.setVisible(true);
    }

    public void lBInfo(MouseEvent event)
    {
        lBClick = true;
        fG.setVisible(false);
        hG.setVisible(false);
        lBG.setVisible(true);
        fInfo.setVisible(false);
        hInfo.setVisible(false);
        lBInfo.setVisible(true);
        cInfo.setVisible(false);
    }

    public void hInfo(MouseEvent event)
    {
        hClick = true;
        fG.setVisible(false);
        lBG.setVisible(false);
        hG.setVisible(true);
        fInfo.setVisible(false);
        lBInfo.setVisible(false);
        cInfo.setVisible(false);
        hInfo.setVisible(true);
    }

    public void buy(MouseEvent event) throws SQLException, ClassNotFoundException {
        try {
            if (fClick) {
                if (player.getDiamond() < FreezeController.getCoinController().getPrice())
                    throw new NotEnoughDiamonds("not enough diamonds");
                PurchaseController.getPurchaseController().purchase("FREEZE");
                fColor.setVisible(true);
                fCount.setVisible(true);
                int v = Integer.valueOf(fCount.getText());
                fCount.setText(String.valueOf(Integer.parseInt(fCount.getText()) + 1));
            } else if (lBClick) {
                if (player.getDiamond() < LittleBoyController.getLittleBoyController().getPrice())
                    throw new NotEnoughDiamonds("not enough diamonds");
                PurchaseController.getPurchaseController().purchase("LITTLEBOY");
                lBcolor.setVisible(true);
                lBCount.setVisible(true);
                lBCount.setText(String.valueOf(Integer.parseInt(lBCount.getText()) + 1));
            } else if (hClick) {
                if (player.getDiamond() < HealthController.getHealthController().getPrice())
                    throw new NotEnoughDiamonds("not enough diamonds");
                PurchaseController.getPurchaseController().purchase("HEALTH");
                hColor.setVisible(true);
                hCount.setVisible(true);
                hCount.setText(String.valueOf(Integer.parseInt(hCount.getText()) + 1));
            } else {
                if (player.getDiamond() < CoinController.getCoinController().getPrice())
                    throw new NotEnoughDiamonds("not enough diamonds");
                PurchaseController.getPurchaseController().purchase("COIN");
                cColor.setVisible(true);
                cCount.setVisible(true);
                cCount.setText(String.valueOf(Integer.parseInt(cCount.getText()) + 1));
            }
        }
    catch (NotEnoughDiamonds e) {
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(2));
        slide1.setNode(error);
        slide1.setToY(120);
        slide1.play();
    }
        diamondsC.setText(String.valueOf(player.getDiamond()));
    }

    public void back(MouseEvent event)
    {
        //load fxml
    }

    public void close(MouseEvent event)
    {
        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(2));
        slide1.setNode(error);
        slide1.setToY(-120);
        slide1.play();
    }
}
