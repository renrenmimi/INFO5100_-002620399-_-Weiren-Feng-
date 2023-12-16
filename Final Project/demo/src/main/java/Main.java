package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        try {
            MainUI root = new MainUI("");
            Scene scene = new Scene(root, 600, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    class MainUI extends AnchorPane {

        private String mainid;
        public String getMainid() {
            return mainid;
        }
        public void setMainid(String mainid) {
            this.mainid = mainid;
        }

        ImageView imgView = new ImageView();

        public MainUI(String param) {
            this.mainid = param;

            Label labelConversion = new Label("Format Conversion");
            labelConversion.setFont(new Font("Arial", 14));
            labelConversion.setPrefWidth(Double.valueOf(100));
            labelConversion.setPrefHeight(Double.valueOf(23));
            this.setLeftAnchor(labelConversion, Double.valueOf(222));
            this.setTopAnchor(labelConversion, Double.valueOf(265));
            this.getChildren().add(labelConversion);

            Label pathLabel = new Label("Original Image Path");
            pathLabel.setFont(new Font("Arial", 14));
            pathLabel.setPrefWidth(Double.valueOf(100));
            pathLabel.setPrefHeight(Double.valueOf(23));
            this.setLeftAnchor(pathLabel, Double.valueOf(109));
            this.setTopAnchor(pathLabel, Double.valueOf(191));
            this.getChildren().add(pathLabel);

            Label sizeLabel = new Label("");
            sizeLabel.setFont(new Font("Arial", 14));
            sizeLabel.setPrefWidth(Double.valueOf(100));
            sizeLabel.setPrefHeight(Double.valueOf(23));
            this.setLeftAnchor(sizeLabel, Double.valueOf(101));
            this.setTopAnchor(sizeLabel, Double.valueOf(386));
            this.getChildren().add(sizeLabel);

            ComboBox<String> formatComboBox = new ComboBox<>();
            formatComboBox.setPrefWidth(Double.valueOf(93));
            formatComboBox.setPrefHeight(Double.valueOf(23));
            this.setLeftAnchor(formatComboBox, Double.valueOf(307));
            this.setTopAnchor(formatComboBox, Double.valueOf(265));
            formatComboBox.getItems().addAll("jpg", "jpeg", "png", "bmp");
            this.getChildren().add(formatComboBox);

            Label titleLabel = new Label("Image Conversion Tool");
            titleLabel.setFont(new Font("Arial", 24));
            titleLabel.setPrefWidth(Double.valueOf(300));
            titleLabel.setPrefHeight(Double.valueOf(40));
            this.setLeftAnchor(titleLabel, Double.valueOf(236));
            this.setTopAnchor(titleLabel, Double.valueOf(95));
            this.getChildren().add(titleLabel);

            TextField fromPathText = new TextField();
            fromPathText.setFont(new Font("Arial", 14));
            fromPathText.setPrefWidth(Double.valueOf(180));
            fromPathText.setPrefHeight(Double.valueOf(23));
            this.setLeftAnchor(fromPathText, Double.valueOf(226));
            this.setTopAnchor(fromPathText, Double.valueOf(193));
            this.getChildren().add(fromPathText);

            Button uploadButton = new Button("Upload");
            uploadButton.setFont(new Font("Arial", 14));
            uploadButton.setPrefWidth(Double.valueOf(93));
            uploadButton.setPrefHeight(Double.valueOf(23));
            this.setLeftAnchor(uploadButton, Double.valueOf(438));
            this.setTopAnchor(uploadButton, Double.valueOf(193));
            // Upload event
            uploadButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    FileChooser fileChooser = new FileChooser();
                    File selectedFile = fileChooser.showOpenDialog(((Stage) ((Button)event.getSource()).getScene().getWindow()));
                    if(selectedFile != null){
                        fromPathText.setText(selectedFile.getAbsolutePath());
                        imgView.setImage(new Image("file:///" + fromPathText.getText().replace("\\", "/")));
                        try {
                            FileImageInputStream fiis = new FileImageInputStream(new File(fromPathText.getText()));
                            Iterator<ImageReader> it1 = ImageIO.getImageReadersByFormatName(getExtension(fromPathText.getText()));
                            ImageReader jpegReader = null;
                            if (it1.hasNext()) {
                                jpegReader = it1.next();
                            }
                            jpegReader.setInput(fiis);
                            BufferedImage br = jpegReader.read(0);
                            sizeLabel.setText(br.getWidth() + "*" + br.getHeight());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        showMsg("Upload Successful");
                    }
                }
            });
            this.getChildren().add(uploadButton);

            Button transformButton = new Button("Transform");
            transformButton.setFont(new Font("Arial", 14));
            transformButton.setPrefWidth(Double.valueOf(93));
            transformButton.setPrefHeight(Double.valueOf(23));
            this.setLeftAnchor(transformButton, Double.valueOf(440));
            this.setTopAnchor(transformButton, Double.valueOf(264));
            // Transform event
            transformButton.setOnAction(e -> {
                imgTransform(fromPathText.getText(), "temp." + formatComboBox.getSelectionModel().getSelectedItem());
                showMsg("Transformation Successful");
            });
            this.getChildren().add(transformButton);

            imgView.setFitWidth(100);
            imgView.setFitHeight(100);
            this.setLeftAnchor(imgView, Double.valueOf(78));
            this.setTopAnchor(imgView, Double.valueOf(258));
            this.getChildren().add(imgView);

            Button downloadButton = new Button("Download");
            downloadButton.setFont(new Font("Arial", 14));
            downloadButton.setPrefWidth(Double.valueOf(93));
            downloadButton.setPrefHeight(Double.valueOf(23));
            this.setLeftAnchor(downloadButton, Double.valueOf(440));
            this.setTopAnchor(downloadButton, Double.valueOf(324));
            // Download event
            downloadButton.setOnAction(e -> {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save File As");
                String suffix = formatComboBox.getSelectionModel().getSelectedItem();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(suffix.toUpperCase(), "*." + suffix));
                fileChooser.setInitialFileName("converted-image." + suffix);

                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    try {
                        copyFileUsingStream(new File("temp." + formatComboBox.getSelectionModel().getSelectedItem()), file);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    showMsg("Download Successful");
                }
            });
            this.getChildren().add(downloadButton);
        }

        public void imgTransform(String from, String to) {
            try {
                FileImageInputStream fiis = new FileImageInputStream(new File(from));
                FileImageOutputStream fios = new FileImageOutputStream(new File(to));

                Iterator<ImageReader> it1 = ImageIO.getImageReadersByFormatName(getExtension(from));
                ImageReader reader = null;
                if (it1.hasNext()) {
                    reader = it1.next();
                }
                reader.setInput(fiis);

                Iterator<ImageWriter> it2 = ImageIO.getImageWritersByFormatName(getExtension(to));
                ImageWriter writer = null;
                if (it2.hasNext()) {
                    writer = it2.next();
                }
                writer.setOutput(fios);

                BufferedImage image = reader.read(0);
                writer.write(image);

                fiis.close();
                fios.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getExtension(String fileName) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }

        private void copyFileUsingStream(File source, File dest) throws IOException {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(source);
                os = new FileOutputStream(dest);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } finally {
                if (is != null) is.close();
                if (os != null) os.close();
            }
        }

        public void showMsg(String msg) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.titleProperty().set("Information");
            alert.headerTextProperty().set(msg);
            alert.showAndWait();
        }
    }
}