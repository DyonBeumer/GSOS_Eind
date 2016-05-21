package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class MainController {


    @FXML
    public TextArea txt2;
    @FXML
    private TextField txt1;
    @FXML
    private Button btn2Save;
    private String url = "http://test-apppppp.rhcloud.com/rest/";

    public void initialize() {
        System.out.println("Application started");

    }

    @FXML
    private void btn2SaveClicked(ActionEvent event) {
        String tempurl = url + txt1.getText();
        System.out.println(tempurl);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(tempurl);
        try {
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            System.out.println(response1.getStatusLine());
            HttpEntity entity = response1.getEntity();
            txt2.setText(EntityUtils.toString(entity));
        } catch (Exception e) {
            txt2.setText("Er is iets mis gegaan, probeer het opnieuw!");
        }

    }
}