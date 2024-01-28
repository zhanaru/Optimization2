package com.example.optimization2.dragAndDrop;

import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class CellWithDocument extends VBox {
    private TextArea textArea;

    public CellWithDocument() {
        this.setPrefSize(200, 200);
        this.setStyle("-fx-border-color: black; -fx-border-style: dashed;");

        textArea = new TextArea();
        textArea.setEditable(false);
        this.getChildren().add(textArea); // Добавление TextArea в VBox

        this.setOnDragOver(event -> {
            if (event.getGestureSource() != this && event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        this.setOnDragDropped(event -> {
            if (event.getDragboard().hasFiles()) {
                File file = event.getDragboard().getFiles().get(0);
                String fileName = file.getName();
                try {
                    if (fileName.endsWith(".txt")) {
                        String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                        textArea.setText(content);
                    } else if (fileName.endsWith(".docx")) {
                        FileInputStream fis = new FileInputStream(file);
                        XWPFDocument document = new XWPFDocument(fis);
                        StringBuilder docText = new StringBuilder();
                        document.getParagraphs().forEach(paragraph -> docText.append(paragraph.getText()).append("\n"));
                        textArea.setText(docText.toString());
                        fis.close();
                    } else if (fileName.endsWith(".xlsx")) {
                        FileInputStream fis = new FileInputStream(file);
                        Workbook workbook = new XSSFWorkbook(fis);
                        StringBuilder excelText = new StringBuilder();
                        Sheet sheet = workbook.getSheetAt(0);
                        sheet.forEach(row -> {
                            row.forEach(cell -> excelText.append(cell.toString()).append("\t"));
                            excelText.append("\n");
                        });
                        textArea.setText(excelText.toString());
                        fis.close();
                    } else if (fileName.endsWith(".pdf")) {
                        PDDocument document = PDDocument.load(file);
                        PDFTextStripper stripper = new PDFTextStripper();
                        String text = stripper.getText(document);
                        textArea.setText(text);
                        document.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    textArea.setText("Ошибка при чтении файла: " + file.getName());
                }
            }
            event.setDropCompleted(true);
            event.consume();
        });
    }
}
