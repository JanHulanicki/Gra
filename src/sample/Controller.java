package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
public class Controller {
    @FXML
    private Text text1_1, text1_2, text1_3, text1_4, text1_5,text1_6,text1_7,text1_8,text1_9,text1_10,text1_11,text1_12,text1_13,
            text2_1, text2_2, text2_3, text2_4, text2_5,text2_6,text2_7,text2_8,text2_9,text2_10,text2_11,text2_12,text2_13,yourScore,competitorScore;
    @FXML
    private Rectangle rect1_1, rect1_2, rect1_3, rect1_4, rect1_5, rect1_6, rect1_7, rect1_8, rect1_9, rect1_10, rect1_11, rect1_12, rect1_13,
            rect2_1, rect2_2, rect2_3, rect2_4, rect2_5, rect2_6, rect2_7, rect2_8, rect2_9, rect2_10, rect2_11, rect2_12, rect2_13;
    @FXML
    private Group group1_1, group1_2, group1_3, group1_4, group1_5, group1_6, group1_7, group1_8, group1_9, group1_10, group1_11, group1_12, group1_13,
            group2_1, group2_2, group2_3, group2_4, group2_5, group2_6, group2_7, group2_8, group2_9, group2_10, group2_11, group2_12, group2_13;;
    @FXML
    private GridPane gridPane;
    @FXML
    public Button restartButton,startButton;
    @FXML
    private int clickedX=0;
    private int clickedY=0;
    private int movedX=0;
    private int movedY=0;
    private int size = 104;
    private int numCols = 18;
    private int numRows = 12;
    private int yourScoreInt=0;
    private int competitorScoreInt=0;
    LinkedList<Integer> listElements = new LinkedList<>();
    GameCell[][] gameTable = new GameCell[numCols][numRows];
    String[] textsValues=new String[13];
    String[] textsValues2=new String[13];
    int[] intTextsValues2=new int[13];
    double  g1_1X;
    double g1_1Y;
    public void initialize() {
        yourScore.setText("0");
        competitorScore.setText("0");
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                addPane(i, j);
            }
        }
        for (int i = 0; i < numCols; i++)
            for (int j = 0; j < numRows; j++) {
                gameTable[i][j]=new GameCell();
            }
        for (int k = 0; k < numCols; k++)
            for (int l = 0; l < numRows; l++) {
                gameTable[k][l].setEnabled(true);
                gameTable[k][l].setValue(-1);
            }
    }
    private void addPane(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> {
            System.out.printf("Mouse cliced cell [%d, %d]%n", colIndex, rowIndex);
            clickedX = colIndex;
            clickedY = rowIndex;
        });
        gridPane.add(pane, colIndex, rowIndex);
    }
    @FXML
    private void startGame() {
       startButton.setVisible(false);
       for (int k = 0; k < 8; k++) {
           for (int j = 1; j <= 13; j++)
               listElements.add(j);
       }
       System.out.println(listElements);
       System.out.println("rozmiar listy przed"+listElements.size());
       int counter = 0;
       Random rand = new Random();
       while (counter < 13) {
           int index = rand.nextInt(listElements.size());
           int index1 = rand.nextInt(listElements.size());
           textsValues[counter]= (listElements.get(index)).toString();
           intTextsValues2[counter]=listElements.get(index1);
           counter++;
       }
       Arrays.sort(intTextsValues2);
       for(int i=0;i<13;i++){
          textsValues2[i]= Integer.toString(intTextsValues2[i]);
       }
       for(int i=1;i<13;i++){
           if (intTextsValues2[i]== intTextsValues2[i-1]){
               competitorScoreInt++;
           }
           if (Math.abs(intTextsValues2[i] - intTextsValues2[i-1])==1){
               competitorScoreInt++;
           }
       }
       gridPane.add(group2_1, 0, 11);
       gridPane.add(group2_2, 1, 11);
       gridPane.add(group2_3, 2, 11);
       gridPane.add(group2_4, 3, 11);
       gridPane.add(group2_5, 4, 11);
       gridPane.add(group2_6, 5, 11);
       gridPane.add(group2_7, 6, 11);
       gridPane.add(group2_8, 7, 11);
       gridPane.add(group2_9, 8, 11);
       gridPane.add(group2_10, 9, 11);
       gridPane.add(group2_11, 10, 11);
       gridPane.add(group2_12, 11, 11);
       gridPane.add(group2_13, 12, 11);
       for(int i=0;i<numCols;i++) {
           gameTable[i][11].setEnabled(false);
       }
       competitorScore.setText(Integer.toString(competitorScoreInt));
       text1_1.setText(textsValues[0]);
       text1_2.setText(textsValues[1]);
       text1_3.setText(textsValues[2]);
       text1_4.setText(textsValues[3]);
       text1_5.setText(textsValues[4]);
       text1_6.setText(textsValues[5]);
       text1_7.setText(textsValues[6]);
       text1_8.setText(textsValues[7]);
       text1_9.setText(textsValues[8]);
       text1_10.setText(textsValues[9]);
       text1_11.setText(textsValues[10]);
       text1_12.setText(textsValues[11]);
       text1_13.setText(textsValues[12]);
       text2_1.setText(textsValues2[0]);
       text2_2.setText(textsValues2[1]);
       text2_3.setText(textsValues2[2]);
       text2_4.setText(textsValues2[3]);
       text2_5.setText(textsValues2[4]);
       text2_6.setText(textsValues2[5]);
       text2_7.setText(textsValues2[6]);
       text2_8.setText(textsValues2[7]);
       text2_9.setText(textsValues2[8]);
       text2_10.setText(textsValues2[9]);
       text2_11.setText(textsValues2[10]);
       text2_12.setText(textsValues2[11]);
       text2_13.setText(textsValues2[12]);

        group1_1.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_1, clickedX,clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_1.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_2.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_2, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_2.getText()));
                movedX = clickedX;
                movedY = clickedY;
            }
            checkScore();
        });
        group1_3.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_3, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_3.getText()));
                movedX = clickedX;
                movedY = clickedY;
                checkScore();
            }
            checkScore();
        });
        group1_4.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_4, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_1.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_5.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_5, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_5.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_6.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_6, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_6.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_7.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_7, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_7.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_8.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_8, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_8.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_9.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_9, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_9.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_10.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_10, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_10.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_11.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_11, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_11.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
        group1_12.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_12, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_12.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
        });
        group1_13.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_13, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_13.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            checkScore();
        });
    }
    @FXML
    private void checkScore() {
         if (movedX>0) {
             if ((gameTable[movedX - 1][movedY].getValue() == gameTable[movedX][movedY].getValue())||
                (Math.abs((gameTable[movedX - 1][movedY].getValue() - gameTable[movedX][movedY].getValue())))==1) {
                   yourScoreInt += 1;
             }
         }else
             if ((gameTable[movedX][movedY].getValue() == gameTable[movedX+1][movedY].getValue())||
                 (Math.abs((gameTable[movedX][movedY].getValue() - gameTable[movedX+1][movedY].getValue())))==1){
                    yourScoreInt += 1;
             }
        yourScore.setText(Integer.toString(yourScoreInt));
    }
    @FXML
    private void reload() {
       System.exit(0);
    }
}





