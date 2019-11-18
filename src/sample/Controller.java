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
import java.util.LinkedList;
import java.util.Random;

public class Controller {

    @FXML
    private Text text1_1, text1_2, text1_3, text1_4, text1_5,text1_6,text1_7,text1_8,text1_9,text1_10,text1_11,text1_12,text1_13;
    //@FXML
    //private Text ;
    @FXML
    private Rectangle rect1_1, rect1_2, rect1_3, rect1_4, rect1_5, rect1_6, rect1_7, rect1_8, rect1_9, rect1_10, rect1_11, rect1_12, rect1_13;
    //@FXML
    //private Rectangle ;

    @FXML
    private Group group1_1, group1_2, group1_3, group1_4, group1_5, group1_6, group1_7, group1_8, group1_9, group1_10, group1_11, group1_12, group1_13;
    @FXML
    private GridPane gridPane;
    @FXML
    public Button restartButton;
    @FXML
    private int clickedX=0;
    private int clickedY=0;
    private int movedX=0;
    private int movedY=0;
    private int size = 104;
    private int numCols = 18;
    private int numRows = 12;
    private int myScore=0;
    LinkedList<Integer> listElements = new LinkedList<>();
    GameCell[][] gameTable = new GameCell[numCols][numRows];
    String[] textsValues=new String[13];
    double  g1_1X;
    double g1_1Y;

    public void initialize() {
        startGame();


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

        //    rect1_1.fillProperty().set(Paint.valueOf("#ff1e1e"));
        //    gridPane.add(group1_1,1,1);
        //    for( int i=0; i<=12;i++)
        //        for( int j=0; j<=12;j++){
        //        gridPane.add(group1_1,i,j);
        for (int i = 0; i < numCols; i++)
            for (int j = 0; j < numRows; j++) {
                gameTable[i][j]=new GameCell();
            }
        for (int k = 0; k < numCols; k++)
            for (int l = 0; l < numRows; l++) {
                gameTable[k][l].setEnabled(true);
                gameTable[k][l].setValue(0);
            }


        // for (int i = 0 ; i < numCols ; i++) {
        //     ColumnConstraints colConstraints = new ColumnConstraints();
        //     colConstraints.setHgrow(Priority.SOMETIMES);
        //     gridPane.getColumnConstraints().add(colConstraints);
        //  }

        //  for (int i = 0 ; i < numRows ; i++) {
        //      RowConstraints rowConstraints = new RowConstraints();
        //      rowConstraints.setVgrow(Priority.SOMETIMES);
        //      gridPane.getRowConstraints().add(rowConstraints);
        //  }

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                addPane(i, j);
            }
        }


        //  gridPane.add(group1_1,1,1);


       group1_1.setOnMouseClicked((e) -> {
        //    if (rect1_1.getFill() == Color.DODGERBLUE) {
        //        rect1_1.setFill(javafx.scene.paint.Color.RED);
         //   } else rect1_1.setFill(Color.DODGERBLUE);

         if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_1, clickedX,clickedY);
               gameTable[clickedX][clickedY].setEnabled(false);
              gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_1.getText()));
               movedX=clickedX;
               movedY=clickedY;
           }
           System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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
          System.out.printf("WSPX " + clickedX + "wspyy " + clickedY + "\n");
          checkScore();
        });
        group1_3.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_3, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_3.getText()));
                movedX = clickedX;
                movedY = clickedY;

                // gridPane.add(group1_3, clickedX, clickedY);
                System.out.printf("WSPX " + clickedX + "wspyy " + clickedY + "\n");
                checkScore();
            }
            System.out.printf("WSPX " + clickedX + "wspyy " + clickedY + "\n");
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
            //gridPane.add(group1_4, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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
            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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
            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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
            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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
            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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
            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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
            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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

            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
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
            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
        });
        group1_13.setOnMouseClicked((e) -> {
            if (gameTable[clickedX][clickedY].isEnabled()) {
                gridPane.add(group1_13, clickedX, clickedY);
                gameTable[clickedX][clickedY].setEnabled(false);
                gameTable[clickedX][clickedY].setValue(Integer.valueOf(text1_13.getText()));
                movedX=clickedX;
                movedY=clickedY;
            }
            // gridPane.add(group1_5, clickedX, clickedY);
            System.out.printf("WSPX" + clickedX + "wspyy " + clickedY + "\n");
            checkScore();
        });

    }

    private void addPane(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        //pane.setOnMouseEntered(e -> {
        //    System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
        // });
        pane.setOnMouseClicked(e -> {
            System.out.printf("Mouse cliced cell [%d, %d]%n", colIndex, rowIndex);
            clickedX = colIndex;
            clickedY = rowIndex;
        });
        gridPane.add(pane, colIndex, rowIndex);
        // System.out.printf("dodano\n");
    }


//    @FXML
//    public void move() {
//    }


    @FXML
    private void startGame() {
       // Translate translateg1_1 = new Translate();
       // g1_1X=group1_1.getTranslateX();
       // g1_1Y=group1_1.getTranslateY();
       // /translateg1_1.setX(g1_1X);
       // translateg1_1.setY( g1_1Y);
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

           textsValues[counter]= (listElements.get(index)).toString();
            System.out.println("Selected: " + listElements.remove(index));
            counter++;
        }
        System.out.println("rozmiar listy po "+listElements.size());
        System.out.println(" listy do txt "+textsValues[0]);
    }
    @FXML
    private void checkScore() {
        //  if (movedX>0) {
        //       if (gameTable[movedX - 1][movedY].getValue() == gameTable[movedX][movedY].getValue()) {
        //           myScore = +1;
        //        }
        //   }else
        //      if (((gameTable[movedX][movedY].getValue()) == gameTable[movedX+1][movedY ].getValue())) {
        //          myScore = +1;
        //       }
        //    System.out.println("punkty: "+movedX ++ myScore);

        System.out.println("movedx:" + movedX + "movedy:" + movedY + " punkty:  " + myScore);
        // System.out.println("punkty pola "+gameTable[movedX][movedY].getValue());
        if (movedX > 0) {
            System.out.println("Wartosc komorki pop" + gameTable[movedX - 1][movedY].getValue());
            //dolozyc sprawdzanie cze w rzedzie sa osci 123 lub 333 jezeli tak do dodajemu punkty do komp lub nam
        }
    }
    @FXML
    private void reload() {
       System.exit(0);
    }

}





