//package client.controller;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.layout.Pane;
//import server.MainServer;
//import server.model.TestUser;
//
//import java.util.List;
//
//public class ParticipantController {
//    @FXML
//    public Label ratingAmount5;
//    @FXML
//    public Label ratingAmount4;
//    @FXML
//    public Label ratingAmount3;
//    @FXML
//    public Label ratingAmount2;
//    @FXML
//    public Label ratingAmount1;
//
//    @FXML
//    public Pane ratingBar5;
//    @FXML
//    public Pane ratingBar4;
//    @FXML
//    public Pane ratingBar3;
//    @FXML
//    public Pane ratingBar2;
//    @FXML
//    public Pane ratingBar1;
//
//    @FXML
//    public void initialize() {
//        ratingAmount5.setText("0");
//        ratingAmount4.setText("0");
//        ratingAmount3.setText("0");
//        populate();
//    }
//
//    public void populate() {
//        List<TestUser> testUsersList = MainServer.tester.getActiveTestCase().getTestUserCatalog().findAll();
//        int amountTotal = 0;
//        int amount5 = 0;
//        int amount4 = 0;
//        int amount3 = 0;
//        int amount2 = 0;
//        int amount1 = 0;
//        for(TestUser testUser : testUsersList) {
//            if(testUser.getPersonalizeTest() == null) {
//                continue;
//            }
//            float grade = testUser.getPersonalizeTest().getGrade();
//            if(grade >= 8) {
//                amount5++;
//                amountTotal++;
//            }
//            else if(grade >= 6) {
//                amount4++;
//                amountTotal++;
//            }
//            else if(grade >= 4) {
//                amount3++;
//                amountTotal++;
//            }
//            else if(grade >= 2) {
//                amount2++;
//                amountTotal++;
//            }
//            else if(grade >= 0) {
//                amount1++;
//                amountTotal++;
//            }
//        }
//        if(amountTotal == 0) {
//            return;
//        }
//        ratingAmount5.setText(String.format("%.1f%%", ((float)amount5*100/amountTotal)));
//        ratingAmount4.setText(String.format("%.1f%%", ((float)amount4*100/amountTotal)));
//        ratingAmount3.setText(String.format("%.1f%%", ((float)amount3*100/amountTotal)));
//        ratingAmount2.setText(String.format("%.1f%%", ((float)amount2*100/amountTotal)));
//        ratingAmount1.setText(String.format("%.1f%%", ((float)amount1*100/amountTotal)));
//
//        ratingBar5.setMaxWidth(ratingBar5.getPrefWidth() * (float)amount5/amountTotal);
//        ratingBar4.setMaxWidth(ratingBar4.getPrefWidth() * (float)amount4/amountTotal);
//        ratingBar3.setMaxWidth(ratingBar3.getPrefWidth() * (float)amount3/amountTotal);
//        ratingBar2.setMaxWidth(ratingBar2.getPrefWidth() * (float)amount2/amountTotal);
//        ratingBar1.setMaxWidth(ratingBar1.getPrefWidth() * (float)amount1/amountTotal);
//    }
//}
